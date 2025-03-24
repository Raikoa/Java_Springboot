package com.example.quickstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
    @GetMapping(path  = "/hello")
    public String hello(){
        return "hello world";
    }
}
