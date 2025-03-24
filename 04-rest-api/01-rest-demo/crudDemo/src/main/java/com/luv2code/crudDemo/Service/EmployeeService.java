package com.luv2code.crudDemo.Service;

import com.luv2code.crudDemo.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);

    void Delete(int id);
}
