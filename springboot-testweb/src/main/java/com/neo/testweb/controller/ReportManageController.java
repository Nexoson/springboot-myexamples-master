package com.neo.testweb.controller;

import com.jcraft.jsch.SftpException;
import com.neo.testweb.utils.SftpCustomUtil;
import com.neo.testweb.utils.base.EnumFormResultMsg;
import com.neo.testweb.utils.base.FormDataResult;
import com.neo.thymeleafupload.feign.ReportManageFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName ReportManageController
 * @Descripition 报表文件管理
 * @Auther huangX
 * @Date 2020/4/1 9:58
 * @Version 1.0
 **/
@RestController
@Api(tags = "app报表管理")
@RequestMapping("/report/reportManage")
@Slf4j
public class ReportManageController {


    @Autowired
    private ReportManageFeign reportManageFeign;

    @ApiOperation("测试响应")
    @RequestMapping(value = "/hi")
//    @ResponseBody
    public String sayhi(){
       log.info("请求进来了");
       return "hello Max";
    }



    @ApiOperation("上传报表文件")
    @RequestMapping(value = "/uploadReportFile", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String uploadReportFile(HttpServletRequest request, @RequestPart(value = "file", required = false) MultipartFile file,
                                   @RequestParam("fileName") String fileName,
                                   @RequestParam("fileType") String fileType,
                                   @RequestParam("showFlag") String showFlag,
                                   @RequestParam("remark") String remark) {
        log.info("\n springboot-web服务的请求路径：{} 请求方法名：{} 请求参数:{}", "/report/reportManage/reportManage", "uploadReportFile()", file, fileName, fileType, showFlag, remark);

        FormDataResult<Object> result = new FormDataResult<>();

        // 服务器文件路径
        String remotefile = null;
        String curPath = "/media/pdf_folder";
        double fileSize = 0F;
        File tempfile = null;
        try {
            if (null == file || StringUtils.isBlank(fileName) || StringUtils.isBlank(fileType) || StringUtils.isBlank(showFlag)) {
                result.setSasisError(EnumFormResultMsg.PARAM_NULL_ERROR);
                return result.toString();
            }

            // 上传到文件服务器
            // 时间戳(文件唯一性)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
            String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
            // 连接文件服务器(linux)
            SftpCustomUtil.connectServer("192.168.247.129", 22, "root", "888888", "/media/pdf_folder");
            //上传测试
            long size = file.getSize();
            fileSize = size / (double) (1024 * 1024);
            fileSize = (double) Math.round(fileSize * 100) / 100;
            // 判断文件有没有带.pdf后缀
            fileName = fileName.toLowerCase();
            if (-1 == fileName.indexOf(".pdf")) {
                fileName = fileName + ".pdf";
            }
            remotefile = dateTime + fileName;
            try {
                tempfile = File.createTempFile("tmp", null);
                file.transferTo(tempfile);
                tempfile.deleteOnExit();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                InputStream inputStream = new FileInputStream(tempfile);
                SftpCustomUtil.upload(curPath, remotefile, inputStream);
                SftpCustomUtil.closeChannel();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (SftpException e) {
                e.printStackTrace();
            }
            result.setSasisError(EnumFormResultMsg.SUCCESS);
        } catch (Exception e) {
            result.setSasisError(EnumFormResultMsg.SYSTEM_ERROR);
            log.error("上传报表到文件服务器出现错误", e);
            e.printStackTrace();
            return result.toString();
        }

        // 上传到文件服务器没有异常则执行插入记录操作

        log.info("插入信息为:" + "userId" + " " + remotefile + " " + fileType + " " + fileSize + " " + curPath + " " + showFlag + " " + remark);
        //保存操作日志

        return result.toString();
    }

    @ApiOperation("调用其它模块上传")
    @RequestMapping(value = "/jumpReportFile", method = RequestMethod.POST)
    public String jumpReportFile(@RequestPart(value = "file", required = false) MultipartFile file, @RequestParam("fileName") String fileName, @RequestParam("remark") String remark){
        String msg = reportManageFeign.jumpReportFile(file, remark);
        return msg;
    }
}
