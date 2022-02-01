package com.rs.configuration;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.h2.server.web.WebServlet;


/**
 * created by rs 1/30/2022.
 */
@Configuration
public class WebConfiguration {
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
       registrationBean.addUrlMappings("/console/*");
       return registrationBean;
    }
}
