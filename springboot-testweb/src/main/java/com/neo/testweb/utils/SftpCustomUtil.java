package com.neo.testweb.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.io.IOUtils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SftpCustomUtil
 * @Descripition 连接linux文件操作类
 * @Auther huangX
 * @Date 2020/4/1 11:16
 * @Version 1.0
 **/

@Slf4j
public class SftpCustomUtil {

    public static ChannelSftp channel;
    public static Session session;
    public static String sftpPath;

    public static void connectServer(String ftpHost, int ftpPort, String ftpUserName, String ftpPassword, String sftpPath) {
        try {
            SftpCustomUtil.sftpPath = sftpPath;
            // 创建JSch对象
            JSch jsch = new JSch();
            // 根据用户名，主机ip，端口获取一个Session对象
            session = jsch.getSession(ftpUserName, ftpHost, ftpPort);
            if (ftpPassword != null) {
                // 设置密码
                session.setPassword(ftpPassword);
            }
            Properties configTemp = new Properties();
            configTemp.put("StrictHostKeyChecking", "no");
            // 为Session对象设置properties
            session.setConfig(configTemp);
            // 设置timeout时间
            session.setTimeout(60000);
            session.connect();
            // 通过Session建立链接
            // 打开SFTP通道
            channel = (ChannelSftp) session.openChannel("sftp");
            // 建立SFTP通道的连接
            channel.connect();
        } catch (JSchException e) {
            //throw new RuntimeException(e);
            log.info("链接失败："+e);
        }
    }

    /**
     * 	断开SFTP Channel、Session连接
     */
    public static void closeChannel() {
        try {
            if (channel != null) {
                channel.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        } catch (Exception e) {
            //
        }
    }

    /**
     *	上传文件
     *
     * @param localFile  本地文件
     * @param remoteFile 远程文件
     * @return
     */
    public static void upload(String localFile, String remoteFile) {
        try {
            remoteFile = sftpPath + remoteFile;
            channel.put(localFile, remoteFile, ChannelSftp.OVERWRITE);
            channel.quit();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }

    /**
     * 	将byte[] 上传到SFTP服务器，作为文件
     * 	注： 从String转换成byte[] 需要指定字符集
     * @param directory     上传到SFTP服务器的路径
     * @param sftpFileName  上传SFTP服务器后的文件名
     * @param bytes         字节数组
     */
    public static void upload(String directory, String sftpFileName, byte[] bytes){
        try{
            upload(directory, sftpFileName, new ByteArrayInputStream(bytes));
        }catch (SftpException e){
            log.error("上传文件异常！", e);
        }
    }
    /**
     *	将输入流上传到SFTP服务器，作为文件
     *
     * @param directory     上传到SFTP服务器的路径
     * @param sftpFileName  上传到SFTP服务器后的文件名
     * @param input         输入流
     * @throws SftpException
     */
    public static void upload(String directory, String sftpFileName, InputStream input) throws SftpException{
        long start = System.currentTimeMillis();
        try{
            //如果文件夹不存在，则创建文件夹
            if(channel.ls(directory) == null){
                channel.mkdir(directory);
            }
            //切换到指定文件夹
            channel.cd(directory);
        }catch (SftpException e){
            //创建不存在的文件夹，并切换到文件夹
            channel.mkdir(directory);
            channel.cd(directory);
        }
        channel.put(input, sftpFileName);
        log.info("文件上传成功！！ 耗时：{}ms",(System.currentTimeMillis() - start));
    }
    /**
     *	下载文件到指定文件夹
     *
     * @param remoteFile 远程文件
     * @param localFile  本地文件
     */
    public static void download(String remoteFile, String localFile) {
        try {
            remoteFile = sftpPath + remoteFile;
            channel.get(remoteFile, localFile);
            channel.quit();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }

    /**
     *	下载文件到指定文件夹
     *
     * @param directory  本地文件
     * @param fileName 远程文件
     * @return
     * @throws IOException
     */
    public static byte[] downloadFile(String directory, String fileName) throws IOException {
        try{
            if(directory != null && !"".equals(directory)){
                channel.cd(directory);
            }
            InputStream inputStream = channel.get(fileName);
            return IOUtils.toByteArray(inputStream);
        }catch (SftpException | IOException e){
            log.error("文件下载异常！", e);
        }
        return null;
    }

    /**
     * 下载文件
     *
     * @param directory     SFTP服务器的文件路径
     * @param downloadFile  SFTP服务器上的文件名
     * @return              输入流
     */
    public static InputStream downloadStream(String directory, String downloadFile){
        try{
            if(directory != null && !"".equals(directory)){
                channel.cd(directory);
            }
            return channel.get(downloadFile);
        }catch (SftpException e){
            log.error("文件下载异常！", e);
        }
        return null;
    }


    /**
     *	删除指定文件
     */
    public static void delete(String directory, String deleteFile) {
        try {
            channel.cd(directory);
            channel.rm(deleteFile);
            channel.quit();
        } catch (Exception e) {
            System.out.println("delete:"+e);
        }
    }

    /**
     *	 判断目录是否存在
     *
     * @param directory     路径
     * @return
     */
    public static boolean isDirExist(String directory) {
        boolean isDirExistFlag = false;
        try {
            SftpATTRS sftpATTRS = channel.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        } catch (Exception e) {
            if (e.getMessage().toLowerCase().equals("no such file")) {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }


    /**
     * 	获取文件夹下的文件
     *
     * @param directory     路径
     * @return
     */
    public static Vector<?> listFiles(String directory){
        try{
            if(isDirExist(directory)){
                Vector<?> vector =  channel.ls(directory);
                //移除上级目录和根目录："." ".."
                vector.remove(0);
                vector.remove(0);
                return vector;
            }
        }catch (SftpException e){
            log.error("获取文件夹信息异常！", e);
        }
        return null;
    }

}
