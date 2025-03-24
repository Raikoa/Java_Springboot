package com.luv2code.springboot.thymleaf.demo.controller;

import com.luv2code.springboot.thymleaf.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> codes;
    @Value("${System}")
    private List<String> System;
    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        Student a = new Student();
        model.addAttribute("student", a);
        model.addAttribute("countries",countries);
        model.addAttribute("languages",codes);
        model.addAttribute("System",System);
        return "show-form";
    }

    @PostMapping("/processStudent")
    public String process(@ModelAttribute("student") Student theStudent){

        return "Student-confirm";
    }
}
