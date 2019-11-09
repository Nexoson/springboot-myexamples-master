package com.neo.thymeleafupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
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
public class UploadController {

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
            byte[] bytes = file.getBytes();
            Path path = Paths.get("H:\\Java学习\\temp\\" + file.getOriginalFilename());
            Files.write(path,bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/home/uploadStatus";
    }
}
