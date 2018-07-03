package com.alloiz.alloizserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.alloiz.alloizserver.repository")
public class AlloizServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AlloizServerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AlloizServerApplication.class);
    }
}
