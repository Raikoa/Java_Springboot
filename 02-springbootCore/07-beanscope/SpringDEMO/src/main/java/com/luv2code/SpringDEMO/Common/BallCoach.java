package com.luv2code.SpringDEMO.Common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BallCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "BALLLLLLLLLLLLLLLS";
    }
}
