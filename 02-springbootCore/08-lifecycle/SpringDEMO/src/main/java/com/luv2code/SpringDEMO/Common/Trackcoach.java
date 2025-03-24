package com.luv2code.SpringDEMO.Common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Trackcoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Runnnnnn";
    }
}
