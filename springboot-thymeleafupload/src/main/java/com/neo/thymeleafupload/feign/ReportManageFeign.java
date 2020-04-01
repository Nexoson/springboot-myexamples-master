package com.neo.thymeleafupload.feign;

import com.neo.thymeleafupload.fallback.ReportManageFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName ReportManageFeign
 * @Descripition TODO
 * @Auther huangX
 * @Date 2020/4/1 15:37
 * @Version 1.0
 **/

//@FeignClient(value = "thymeleafupload", fallback = ReportManageFeignFallback.class, path = "/report/reportManage")
public interface ReportManageFeign {


    @PostMapping(value = "/jumpReportFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    String jumpReportFile(@RequestPart(value = "file") MultipartFile file, @RequestParam("remark") String remark);

}
