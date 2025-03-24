package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);

    void Delete(int id);
}
