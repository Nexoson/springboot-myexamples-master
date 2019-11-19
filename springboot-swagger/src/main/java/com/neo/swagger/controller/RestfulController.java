package com.neo.swagger.controller;

import com.neo.swagger.model.Message;
import com.neo.swagger.service.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName RestController
 * @Descripition Restful案例
 * @Auther huangX
 * @Date 2019/11/9 17:33
 * @Version 1.0
 **/

@RestController
@RequestMapping("/")
public class RestfulController {

    @Autowired
    private MessageRepository messageRepository;

    // 获取所有消息体
    @GetMapping(value = "messages")
    public List<Message> list(){

        List<Message> messages = this.messageRepository.findAll();
        return messages;
    }

    // 创建一个消息体
    @PostMapping(value = "message")
    public Message create(Message message){
        message = this.messageRepository.save(message);
        return message;
    }

    // 使用put请求进行修改
    @PutMapping(value = "message")
    public Message modify(Message message){
        message = this.messageRepository.update(message);
        return message;
    }

    // 更新消息的text字段
    @PatchMapping(value = "/message/text")
    public Message patch(Message message){
        Message result = this.messageRepository.updateText(message);
        return result;
    }

    @GetMapping(value = "message/{id}")
    public Message get(@PathVariable Long id){
        Message message = this.messageRepository.findMessage(id);
        return message;
    }

    @DeleteMapping(value = "message/{id}")
    public void delete(@PathVariable("id") Long id){
        this.messageRepository.deleteMessage(id);
    }

}
