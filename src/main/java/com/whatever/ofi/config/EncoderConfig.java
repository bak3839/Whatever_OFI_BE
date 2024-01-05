package com.whatever.ofi.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncoderConfig {

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public ServletListenerRegistrationBean<CustomServletContextListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new CustomServletContextListener());
    }
}
