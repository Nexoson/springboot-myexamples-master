package com.neo.restfuldemo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @ClassName AsyncConfiguration
 * @Auther huangX
 * @Date 2020/5/18 20:04
 * @Version 1.0
 * @Descripition 自定义线程池
 **/

@Configuration
@EnableAsync // 启动异步任务
public class AsyncThreadPool {

    // 声明一个线程池(并指定线程池的名字)
    @Bean("taskExecutor")
    public Executor asyncExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数5: 线程池创建时候初始化的线程数
        executor.setCorePoolSize(5);
        // 最大线程数5: 线程池最大的线程数, 只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(5);
        // 缓冲队列500: 用来缓冲执行任务的队列
        executor.setQueueCapacity(500);
        // 允许线程的空闲时间60秒: 当超过核心线程出之外的线程在空闲时间到达后都会被销毁
        executor.setKeepAliveSeconds(60);
        // 线程池名的前缀: 设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setThreadNamePrefix("DailyAsync-");
        // 线程池初始化
        executor.initialize();
        return executor;


        /**
         * 在使用spring的异步多线程时经常回碰到多线程失效的问题，解决方式为：
         * 异步方法和调用方法一定要写在不同的类中 ,如果写在一个类中,是没有效果的！
         *
         * 原因：
         * spring对@Transactional注解时也有类似问题，spring扫描时具有@Transactional注解方法的类时，
         * 是生成一个代理类，由代理类去开启关闭事务，而在同一个类中，方法调用是在类体内执行的，spring无法截获这个方法调用。
         **/
    }

}
