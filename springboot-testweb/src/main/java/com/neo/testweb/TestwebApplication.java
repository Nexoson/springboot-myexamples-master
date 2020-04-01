package com.neo.testweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.neo"})
public class TestwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestwebApplication.class, args);
    }

}
