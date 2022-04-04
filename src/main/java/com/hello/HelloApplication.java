package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@ComponentScan(basePackages={"com.hello"})
@EnableJpaAuditing
@SpringBootApplication
public class HelloApplication {
    public static void main(String[] args) {

        SpringApplication.run(HelloApplication.class, args);
    }
}
