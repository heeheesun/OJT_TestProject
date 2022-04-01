package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.hello"})
@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {

        SpringApplication.run(HelloApplication.class, args);
    }
}
