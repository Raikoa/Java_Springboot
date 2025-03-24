package com.luv2code.SpringDEMO;

import org.springframework.stereotype.Component;

@Component
public class BallCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "BALLLLLLLLLLLLLLLS";
    }
}
