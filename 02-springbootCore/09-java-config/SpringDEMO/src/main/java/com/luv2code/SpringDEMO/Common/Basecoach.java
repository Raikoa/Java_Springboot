package com.luv2code.SpringDEMO.Common;

import org.springframework.stereotype.Component;

@Component
public class Basecoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Based";
    }
}
