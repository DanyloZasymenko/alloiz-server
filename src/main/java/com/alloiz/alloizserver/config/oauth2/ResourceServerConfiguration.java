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
                .antMatchers(HttpMethod.POST, "/image/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/image/**").authenticated()
                .antMatchers(HttpMethod.GET, "/image/**").permitAll()
                .antMatchers(HttpMethod.POST, "/callback/update").authenticated()
                .antMatchers(HttpMethod.POST, "/callback/save").permitAll()
                .antMatchers(HttpMethod.DELETE, "/callback/**").authenticated()
                .antMatchers(HttpMethod.GET, "/callback/**").permitAll()
                .antMatchers(HttpMethod.POST, "/incumbency/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/incumbency/**").authenticated()
                .antMatchers(HttpMethod.GET, "/incumbency/**").permitAll()
                .antMatchers(HttpMethod.POST, "/portfolio/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/portfolio/**").authenticated()
                .antMatchers(HttpMethod.GET, "/portfolio/**").permitAll()
                .antMatchers(HttpMethod.POST, "/portfolio-description/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/portfolio-description/**").authenticated()
                .antMatchers(HttpMethod.GET, "/portfolio-description/**").permitAll()
                .antMatchers(HttpMethod.POST, "/technology/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/technology/**").authenticated()
                .antMatchers(HttpMethod.GET, "/technology/**").permitAll()
                .antMatchers(HttpMethod.POST, "/technology-description/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/technology-description/**").authenticated()
                .antMatchers(HttpMethod.GET, "/technology-description/**").permitAll()
                .antMatchers(HttpMethod.POST, "/worker/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/worker/**").authenticated()
                .antMatchers(HttpMethod.GET, "/worker/**").permitAll()

                .anyRequest().permitAll();
    }

}