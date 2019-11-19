package com.neo.swagger.service;

import com.neo.swagger.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName InMemoryMessageRepository
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/11/9 17:39
 * @Version 1.0
 **/
@Service("MessageRepository")
public class InMemoryMessageRepository implements MessageRepository{
    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, Message> messages = new ConcurrentHashMap<>();



    /**
     * 查询所有用户,就是将Map中的信息全部返回.
     **/
    @Override
    public List<Message> findAll() {
        ArrayList<Message> messages = new ArrayList<>(this.messages.values());
        return messages;
    }


    /**
     * 保存消息时,需要判断是否存在ID,如果没有,可以使用AtomicLong获取一个
     **/
    @Override
    public Message save(Message message) {
        Long id = message.getId();

        if(null == id){
            id = counter.incrementAndGet();
            message.setId(id);
        }
        this.messages.put(id,message);
        return message;
    }

    @Override
    public Message update(Message message) {
        this.messages.put(message.getId(),message);
        return message;
    }


    /**
     * 更新text字段
     **/
    @Override
    public Message updateText(Message message) {
        Message msg = this.messages.get(message.getId());
        msg.setText(message.getText());
        this.messages.put(msg.getId(),msg);
        return msg;
    }

    @Override
    public Message findMessage(Long id) {
        return this.messages.get(id);
    }

    @Override
    public void deleteMessage(Long id) {
        this.messages.remove(id);
    }
}
