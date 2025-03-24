package com.luv2code.SpringDEMO.config;

import com.luv2code.SpringDEMO.Common.Coach;
import com.luv2code.SpringDEMO.Common.Swimcoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuration {
    @Bean("aqua")
    public Coach swimcoach(){
        return new Swimcoach();
    }
}
