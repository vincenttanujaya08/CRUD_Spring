package com.example.demo.config;

import jakarta.servlet.Servlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfig {

    @Bean
    public ServletRegistrationBean<Servlet> h2ConsoleServlet() {
        try {
            Class<?> clazz = Class.forName("org.h2.server.web.JakartaWebServlet");
            Servlet servlet = (Servlet) clazz.getDeclaredConstructor().newInstance();
            return new ServletRegistrationBean<>(servlet, "/h2-console/*");
        } catch (Exception e) {
            throw new IllegalStateException("H2 JakartaWebServlet not available", e);
        }
    }
}