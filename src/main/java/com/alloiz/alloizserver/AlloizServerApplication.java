package com.alloiz.alloizserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.alloiz.alloizserver.repository")
public class AlloizServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlloizServerApplication.class, args);
    }
}
