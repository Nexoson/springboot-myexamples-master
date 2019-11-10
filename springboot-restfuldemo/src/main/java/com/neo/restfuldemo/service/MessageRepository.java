package com.neo.restfuldemo.service;

import com.neo.restfuldemo.model.Message;

import java.util.List;

/**
 * @ClassName MessageRepository
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/11/10 13:11
 * @Version 1.0
 **/
public interface MessageRepository {

    List<Message> findAll();

    Message save(Message message);

    Message update(Message message);

    Message updateText(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);

}
