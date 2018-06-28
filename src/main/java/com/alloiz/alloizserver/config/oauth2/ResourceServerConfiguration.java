package com.alloiz.alloizserver.config.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import static com.alloiz.alloizserver.config.oauth2.AuthorizationServerConfiguration.RESOURCE_ID;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/oauth/token").permitAll()
                //ПРИКЛАД
                .antMatchers(HttpMethod.POST, "/article/**").access("hasAuthority('MODERATOR')")
                .antMatchers(HttpMethod.DELETE, "/article/**").access("hasAuthority('MODERATOR')")
                .antMatchers(HttpMethod.GET, "/article/**").permitAll()
                .antMatchers("/article/find-one-available/**").permitAll()
                .antMatchers("/add").permitAll()
                .anyRequest().permitAll();
    }


}