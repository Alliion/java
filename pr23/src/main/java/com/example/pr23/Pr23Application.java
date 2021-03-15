package com.example.pr23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Pr23Application {

    public static void main(String[] args) {
        SpringApplication.run(Pr23Application.class, args);
    }

}
