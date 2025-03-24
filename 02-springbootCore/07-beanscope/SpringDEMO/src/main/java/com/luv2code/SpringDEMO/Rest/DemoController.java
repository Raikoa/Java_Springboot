package com.luv2code.SpringDEMO.Rest;

import com.luv2code.SpringDEMO.Common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;
    private Coach another;

    @Autowired
    public DemoController(@Qualifier("ballCoach") Coach thecoach,
                          @Qualifier("ballCoach") Coach anotherone){
        this.coach = thecoach;
        this.another = anotherone;
        System.out.println("in class" + getClass().getSimpleName());
    }

    @GetMapping("/check")
    public String check(){
        return "Compare " + (coach == another);
    }
    @GetMapping("/dailyworkout")
    public String workout(){
        return coach.getDailyWorkout();
    }
}
