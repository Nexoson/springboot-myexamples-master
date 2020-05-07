package com.neo.websocket.utils;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName WebSocketUtils
 * @Descripition TODO
 * @Auther huangX
 * @Date 2019/12/4 23:01
 * @Version 1.0
 **/
public final class WebSocketUtils {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketUtils.class);

    // 存储 websocket session
    public static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap<>();

    // 存储机器人话术
    public static final Map<Integer, String> ONLINE_REPORT_WORDS = new ConcurrentHashMap<>();

    // 存储机器人回答
    public static final Map<Integer, String> ONLINE_REPORT_ANSWERS = new ConcurrentHashMap<>();

    static {
        ONLINE_REPORT_WORDS.put(0, "你好! 很高兴为你服务,有什么可以帮到您的吗?");
        ONLINE_REPORT_WORDS.put(1, "\n1.什么时候提车呢?");
        ONLINE_REPORT_WORDS.put(2, "\n2.提车手续费是指什么?");
        ONLINE_REPORT_WORDS.put(3, "\n3.上路手续怎么办理?");
        ONLINE_REPORT_WORDS.put(4, "\n4.都有什么颜色呢?");
        ONLINE_REPORT_WORDS.put(5, "\n5.可以帮忙办理分期吗?");

        ONLINE_REPORT_ANSWERS.put(1, "\n您好，提车时间因订单火爆目前无法保证，您支付尾款之后会尽快安排哈，咱们这里尽快帮您办理手续！");
        ONLINE_REPORT_ANSWERS.put(2, "\n车辆购置税,车船使用税,强险,上牌费回");
        ONLINE_REPORT_ANSWERS.put(3, "\n如果在我们门店未覆盖地区是无法帮忙办理上牌、保险和购置税的，只能提供裸车哦！目前我们门店遍布于云南、贵州、四川、重庆、湖南、广东、广西、江西、福建。其他地区是没有的哈。");
        ONLINE_REPORT_ANSWERS.put(4, "\n塔夫绸白,海洋蓝,冰河银,天空蓝,绽放橙,鲜韵绿");
        ONLINE_REPORT_ANSWERS.put(5, "\n我们这有多种金融方案,可以帮忙办理分期的");
    }

    /**
     * @param session 用户 session
     * @param message 发送内容
     */
    public static void sendMessage(Session session, String message) {
        if (null == session) {
            return;
        }
        final RemoteEndpoint.Basic basic = session.getBasicRemote();
        if (basic == null) {
            return;
        }
        try {
            basic.sendText(message);
        } catch (IOException e) {
            logger.error("sendMessage IOException ", e);
        }
    }

    public static void sendMessageAll(String message) {
        ONLINE_USER_SESSIONS.forEach((sessionId, session) -> sendMessage(session, message));
    }


    /**
     * @return
     * @Author huangX
     * @Date 11:11 2020/5/7
     * @Param
     * @Description 触发机器人信息
     **/
    public static void getReportMsg(Session session, String msg) {

        // 首次登陆,触发欢迎语(msg 为null)
        if (null == msg) {
            sendMessage(session, ONLINE_REPORT_WORDS.values().toString());
        } else {
            if (ONLINE_REPORT_ANSWERS.keySet().contains(Integer.valueOf(msg))) {
                sendMessage(session, ONLINE_REPORT_ANSWERS.get(Integer.valueOf(msg)));
            } else {
                sendMessage(session, "请咨询人工客服");
            }

        }
    }
}
