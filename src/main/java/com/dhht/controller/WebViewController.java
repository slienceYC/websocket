package com.dhht.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebViewController extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("/ws");
        registry.addViewController("/upload").setViewName("/upload");
        registry.addViewController("/uploadStatus").setViewName("/uploadStatus");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/loginStatus").setViewName("/loginStatus");
    }
}
