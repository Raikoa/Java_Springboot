package com.luv2code.springboot.demoSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String show(){
        return "home";
    }

    @GetMapping("/leaders")
    public String leader(){
        return "leaders";
    }
    @GetMapping("/systems")
    public String sys(){
        return "systems";
    }
}
