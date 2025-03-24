package com.luv2code.springboot.demo.myCourseProject.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
