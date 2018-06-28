package com.alloiz.alloizserver.config;

import com.alloiz.alloizserver.service.utils.FileBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@EnableJpaRepositories(basePackages = "com.alloiz.alloizserver.repository")
@Component
public class Beans {

    @Bean
    FileBuilder fileBuilder() {
        return new FileBuilder();
    }
}
