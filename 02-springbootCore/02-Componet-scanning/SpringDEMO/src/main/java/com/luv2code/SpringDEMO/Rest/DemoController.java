package com.luv2code.SpringDEMO.Rest;

import com.luv2code.SpringDEMO.Common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach coach;
    @Autowired
    public DemoController(Coach Mycoach){
        this.coach = Mycoach;

    }

    @GetMapping("/dailyworkout")
    public String workout(){
        return coach.getDailyWorkout();
    }
}
