package com.luv2code.crudDemo.Controller;

import com.luv2code.crudDemo.Entity.Employee;
import com.luv2code.crudDemo.Service.EmployeeService;
import com.luv2code.crudDemo.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService ser){
        this.service = ser;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return service.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee findById(@PathVariable int employeeID){
        Employee target = service.findById(employeeID);
        if(target == null){
            throw new RuntimeException("Employee ID not found");
        }
        return target;
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee){
        employee.setId(0);
        Employee Saved = service.save(employee);
        return Saved;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee){
        Employee db = service.save(employee);
        return db;
    }

    @DeleteMapping("/employees/{employeeID}")
    public String delete(@PathVariable int employeeID){
        Employee target = service.findById(employeeID);
        if(target == null){
            throw new RuntimeException("no such id");
        }
        service.Delete(employeeID);
        return "deleted";
    }
}
