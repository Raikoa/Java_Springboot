package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @InitBinder
    public void binder(WebDataBinder bind){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        bind.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("customer",new Customer());
        return "customer-form";
    }


    @PostMapping("/processForm")
    public String process(@Valid @ModelAttribute("customer") Customer cust, BindingResult bind){
        System.out.println("last name: |" + cust.getLastName() + "|");
        System.out.println("Binding result:" + bind.toString());
        if(bind.hasErrors()){
            return "customer-form";
        }else {
            return "process-form";
        }
    }
}
