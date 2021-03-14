package com.example.pr22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Pr22Application {

    public static void main(String[] args) {
        SpringApplication.run(Pr22Application.class, args);
    }

}
