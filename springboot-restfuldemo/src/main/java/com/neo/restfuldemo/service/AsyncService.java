package com.neo.restfuldemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AsyncService
 * @Auther huangX
 * @Date 2020/5/18 20:12
 * @Version 1.0
 * @Descripition 多线程服务
 **/
@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);


    @Autowired
    private RestTemplate restTemplate;

    @Async("taskExecutor")
    public CompletableFuture<String> findUser(String msg) throws InterruptedException {
        logger.info("Looking up " + msg);
        String url = String.format("http://192.168.0.107:8080/home/%s", msg);
        String results = restTemplate.getForObject(url, String.class);
        TimeUnit.SECONDS.sleep(3);
        return CompletableFuture.completedFuture(results);
    }


}
