package com.example.springboottutorialvalidate.config;

import com.example.springboottutorialvalidate.convertor.PersonConvertor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * convertor註冊
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new PersonConvertor());
    }
}
