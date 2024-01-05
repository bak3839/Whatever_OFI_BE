package com.whatever.ofi.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.SessionCookieConfig;

@Component
public class CustomServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SessionCookieConfig sessionCookieConfig = sce.getServletContext().getSessionCookieConfig();
        sessionCookieConfig.setComment("SameSite=None");
    }

    @Bean
    public ServletListenerRegistrationBean<CustomServletContextListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new CustomServletContextListener());
    }
}
