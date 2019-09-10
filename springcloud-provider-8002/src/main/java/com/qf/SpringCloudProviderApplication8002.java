package com.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableEurekaClient    //开启eureka的客户端
public class SpringCloudProviderApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderApplication8002.class, args);
    }
}
