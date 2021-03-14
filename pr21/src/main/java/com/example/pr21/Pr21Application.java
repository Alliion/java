package com.example.pr21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Pr21Application {

    public static void main(String[] args) {
        SpringApplication.run(Pr21Application.class, args);
    }

}
