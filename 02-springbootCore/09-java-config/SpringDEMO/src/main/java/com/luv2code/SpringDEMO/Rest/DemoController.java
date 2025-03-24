package com.luv2code.SpringDEMO.Rest;

import com.luv2code.SpringDEMO.Common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;
    private Coach another;

    @Autowired
    public DemoController(@Qualifier("aqua") Coach thecoach){
        this.coach = thecoach;

        System.out.println("in class" + getClass().getSimpleName());
    }



    @GetMapping("/dailyworkout")
    public String workout(){
        return coach.getDailyWorkout();
    }
}
