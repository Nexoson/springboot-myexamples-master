package com.neo.fastdfsdemo;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FastdfsdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastdfsdemoApplication.class, args);
    }

    @Bean
    // TomcatServletWebServerFactory() ⽅法主要是为了解决上传⽂件⼤于 10M 出现连接重置的问题，此异常内容 GlobalException 也捕获不到
    public TomcatServletWebServerFactory tomcatEmbedded(){

        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

}
