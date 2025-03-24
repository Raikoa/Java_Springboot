package com.luv2code.springboot.demoSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String show(){
        return "fancy-login";
    }
    @GetMapping("/access-denied")
    public String denied(){
        return "denied";
    }
}
