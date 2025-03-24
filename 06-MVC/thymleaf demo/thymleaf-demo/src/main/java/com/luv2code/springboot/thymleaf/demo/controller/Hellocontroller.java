package com.luv2code.springboot.thymleaf.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Hellocontroller {
    @GetMapping("/showForm")
    public String showForm(){
        return "hello-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormTwo")
    public String shout(HttpServletRequest request,Model model){
        String Name = request.getParameter("studentName");
        Name = Name.toUpperCase();
        String result = "yo " + Name;
        model.addAttribute("message", result);
        return "helloworld";
    }

    @PostMapping("/processFormThree")
    public String shoutparam(@RequestParam("studentName")  String Name, Model model){

        Name = Name.toUpperCase();
        String result = "hey " + Name;
        model.addAttribute("message", result);
        return "helloworld";
    }

}
