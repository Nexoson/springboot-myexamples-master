package com.neo.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import static com.neo.websocket.utils.WebSocketUtils.*;


/**
 * @ClassName ChatRoomServerEndpoint
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/12/4 23:13
 * @Version 1.0
 **/

@RestController
@ServerEndpoint("/chat-room/{username}")
public class ChatRoomServerEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(ChatRoomServerEndpoint.class);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        ONLINE_USER_SESSIONS.put(username, session);
        String message = "欢迎用户[" + username + "] 来到聊天室！";
        logger.info("用户登录：" + message);
        // 首次触发机器人信息
        if (ONLINE_USER_SESSIONS.keySet().size() > 1) {
            sendMessageAll(LocalDateTime.now().format(formatter) + message);
        } else {
            getReportMsg(session, null);
        }
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {
        logger.info("发送消息: " + message);
        if (ONLINE_USER_SESSIONS.keySet().size() > 1) {
            sendMessageAll(LocalDateTime.now().format(formatter) + " 用户[" + username + "] : " + message);
        } else {
            getReportMsg(ONLINE_USER_SESSIONS.get(username), message);
        }
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        // 当前的Session 移除
        ONLINE_USER_SESSIONS.remove(username);
        // 并且通知其他人当前用户已经离开聊天室了
        sendMessageAll(LocalDateTime.now().format(formatter) + " 用户[" + username + "] 已经离开聊天室了！");
        if (ONLINE_USER_SESSIONS.keySet().size() == 1) {
            ONLINE_USER_SESSIONS.forEach((sessionId, onesession) -> getReportMsg(onesession, null));
        }
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onClose error", e);
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            logger.error("onError excepiton", e);
        }
        logger.info("Throwable msg " + throwable.getMessage());
    }

}
