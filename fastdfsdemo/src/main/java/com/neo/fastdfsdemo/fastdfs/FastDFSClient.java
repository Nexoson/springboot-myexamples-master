package com.neo.fastdfsdemo.fastdfs;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName FastDFSClient
 * @Descripition FastDFS工具类
 * @Auther huangX
 * @Date 2019/10/29 21:20
 * @Version 1.0
 **/
public class FastDFSClient {

    private static Logger log = LoggerFactory.getLogger(FastDFSClient.class);


    static{

        try {
            String filePth = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePth);
        } catch (Exception e) {
            log.error("FastDFS Client Init Fail!",e);
            e.printStackTrace();
        }
    }

    public static String[] upload(FastDFSFile file) {

        log.info("File Name: " + file.getName() + "File Length:" + file.getContent().length);

        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

        long startTime = System.currentTimeMillis();
        String[] uploadResults = null;
        StorageClient storageClient = null;

        try {
            storageClient = getTrackerClient();
            uploadResults = storageClient.upload_file(file.getContent(),file.getExt(),meta_list);
        } catch (IOException e) {
            log.error("IO Exception when uploadind the file:" + file.getName(), e);
        } catch (MyException e) {
            log.error("Non IO Exception when uploadind the file:" + file.getName(), e);
        }
        log.info("upload_file time used:" + (System.currentTimeMillis() - startTime) + " ms");
        if(uploadResults == null && storageClient != null){
            log.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];

        log.info("upload file successfully!!!" + "group_name:" + groupName + ", remoteFileName:" + " " + remoteFileName);
        return uploadResults;
    }

    public static FileInfo getFile(String groupName, String remoteFileName){

        try {
            StorageClient storageClient = getTrackerClient();
            return storageClient.get_file_info(groupName,remoteFileName);
        } catch (IOException e) {
            log.error("IO Exception: Get File from Fast DFS failed", e);
            e.printStackTrace();
        } catch (MyException e) {
            log.error("Non IO Exception: Get File from Fast DFS failed", e);
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream downFile(String groupName, String romoteFileName){
        try {
            StorageClient storageClient = getTrackerClient();
            byte[] fileBytes = storageClient.download_file(groupName, romoteFileName);
            ByteArrayInputStream ins = new ByteArrayInputStream(fileBytes);
            return ins;
        } catch (IOException e) {
            log.error("IO Exception: Get File from Fast DFS failed", e);
            e.printStackTrace();
        } catch (MyException e) {
            log.error("Non IO Exception: Get File from Fast DFS failed", e);
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteFile(String groupName, String remoteFileName) throws Exception {
         StorageClient storageClient= getTrackerClient();
        int i = storageClient.delete_file(groupName, remoteFileName);
        log.info("delete file successfully!!!" + i);
    }

    public static StorageServer[] getStoreStorages(String groupName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getStoreStorages(trackerServer,groupName);
    }

    public static ServerInfo[] getFetchStorages(String groupName,String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer,groupName,remoteFileName);
    }

    public static String getTrackerUrl() throws IOException {
        String str1 = getTrackerServer().getInetSocketAddress().getHostString();
        String str2 = ClientGlobal.getG_tracker_http_port()+"/";
        return "http://"+str1+":"+str2;
    }

    private static StorageClient getTrackerClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return  storageClient;
    }

    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }
}
