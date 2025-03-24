package com.luv2code.springboot.thymeleafDemo.Controller;

import com.luv2code.springboot.thymeleafDemo.entity.Employee;
import com.luv2code.springboot.thymeleafDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService  employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees",employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model){
        Employee theEmployee = new Employee();
        model.addAttribute("employee",theEmployee);
        return "employees/SaveForm";
    }
    @GetMapping("/Update")
    public String update(@RequestParam("employeeId") int id, Model model){
        Employee theEmployee = employeeService.findById(id);
        model.addAttribute("employee", theEmployee);

        return "/employees/SaveForm";
    }

    @PostMapping("/save")
    public String Save(@ModelAttribute("employee") Employee theEmployee ){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}
