package com.luv2code.SpringDEMO.Common;

import org.springframework.stereotype.Component;

@Component
public class Tenniscoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "tennis";
    }
}
