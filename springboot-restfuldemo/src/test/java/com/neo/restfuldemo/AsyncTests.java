package com.neo.restfuldemo;

import com.neo.restfuldemo.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName AsyncTests
 * @Auther huangX
 * @Date 2020/5/18 20:30
 * @Version 1.0
 * @Descripition Springboot多线程测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AsyncTests {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTests.class);

    @Autowired
    private AsyncService asyncService;

    @Test
    public void asyncTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<String> page1 = asyncService.findUser("hi");
        CompletableFuture<String> page2 = asyncService.findUser("yes");
        CompletableFuture<String> page3 = asyncService.findUser("good");

        // wait until they all done
        // join()的作用: 让"主线程"等待"子线程"结束之后才能继续运行
        CompletableFuture.allOf(page1, page2, page3).join();

        // Print results, including elapsed time
        float exc = (float) (System.currentTimeMillis() - start) / 1000;
        logger.info("Elapsed time: " + exc + " seconds");
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }
}
