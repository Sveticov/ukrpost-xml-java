package com.svetikov.ukrpostxmljava.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfigurator {

    @Bean
    public WSOController wsoController(){
        return new WSOController();
    }
}
