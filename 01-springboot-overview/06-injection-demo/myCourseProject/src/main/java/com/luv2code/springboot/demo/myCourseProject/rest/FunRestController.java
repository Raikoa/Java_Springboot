package com.luv2code.springboot.demo.myCourseProject.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;
    @Value(("${team.name}"))
    private String TeamName;


    @GetMapping("/teaminfo")
    public String getTeam(){
        return "Coach " + coachName + " " + "Team: " + TeamName;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/workout")
    public String work(){
        return "workout";
    }

    @GetMapping("/oww")
    public String oww(){
        return "oww";
    }

}
