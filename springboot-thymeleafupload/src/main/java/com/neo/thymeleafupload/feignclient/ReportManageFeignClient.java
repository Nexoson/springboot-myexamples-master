package com.neo.thymeleafupload.feignclient;


import com.neo.thymeleafupload.feign.ReportManageFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName ReportManageFeignClient
 * @Descripition TODO
 * @Auther huangX
 * @Date 2020/4/1 16:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("/report/reportManage")
@Slf4j
public class ReportManageFeignClient implements ReportManageFeign {

//    @Autowired
//    private ReportManageService reportManageService;

    @Override
    public String jumpReportFile(MultipartFile file, String remark) {

        log.info("进入新的上传文件方法");
        // 将pdf文件存到本地磁盘
        // 原文件名
        String path = null;
        try {
            String filename = file.getOriginalFilename();
            String filePath = "C:\\Users\\Administrator\\Desktop\\面试准备";
            // 获取文件后缀名
            String suffix = filename.substring(filename.lastIndexOf("."));
            // 判断目录是否为空,若为空则新建目录
            final File targetFile  = new File(filePath);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            //上传文件路径
            path = filePath+"/"+filename;
            log.info(path);
            //上传
            FileOutputStream out = new FileOutputStream(path);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
