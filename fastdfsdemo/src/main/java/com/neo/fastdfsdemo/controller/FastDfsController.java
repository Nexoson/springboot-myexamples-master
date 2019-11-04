package com.neo.fastdfsdemo.controller;

import com.neo.fastdfsdemo.fastdfs.FastDFSClient;
import com.neo.fastdfsdemo.fastdfs.FastDFSFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @ClassName Upload
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/10/28 21:49
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "home")
public class FastDfsController {

    private static Logger log = LoggerFactory.getLogger(FastDfsController.class);

    @GetMapping("/uploadIndex")
    public String index(){
        return "upload";
    }

    @GetMapping("/uploadStatus")
    public String index1(){
        return "uploadStatus";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","Please select a file to upload");
            return  "redirect:/home/uploadStatus";
        }
        try {
            // 保存到本地指定文件夹内
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get("H:\\Java学习\\temp\\" + file.getOriginalFilename());
//            Files.write(path,bytes);

            // 调用FastDFS工具类上传到FastDFS文件服务器
            String path = saveFile(file);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("path",
                    "file path url '" + path + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/home/uploadStatus";
    }


    /**
     * @Author huangX
     * @Description TODO
     * @Date 23:19 2019/11/4
     * @Param multipartFile
     * @return
     **/
    public String saveFile(MultipartFile multipartFile) throws IOException {

        String [] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if(null != inputStream){
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }

        inputStream.close();
        FastDFSFile file = new FastDFSFile(fileName, file_buff, ext);
        try {
            // upload to fastdfs
            fileAbsolutePath = FastDFSClient.upload(file);
        } catch (Exception e) {
            log.error("upload file Exception!",e);
            e.printStackTrace();
        }

        if(null == fileAbsolutePath){
            log.error("upload file failed,please upload again!");
        }
        String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        return path;
    }
}
