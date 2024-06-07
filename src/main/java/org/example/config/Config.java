package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new GsonHttpMessageConverter());
        adapter.setMessageConverters(messageConverters);
        return adapter;
    }
}
