package com.neo.fastdfsdemo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @ClassName GlobalExceptionHandler
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/11/4 21:58
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String handleError1(MultipartException e, RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("message",e.getCause().getMessage());
        return  "redirect:/home/uploadStatus";
    }
}
