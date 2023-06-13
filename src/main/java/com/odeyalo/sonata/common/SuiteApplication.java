package com.odeyalo.sonata.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication@EnableReactiveFeignClients
public class SuiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuiteApplication.class, args);
    }

}
