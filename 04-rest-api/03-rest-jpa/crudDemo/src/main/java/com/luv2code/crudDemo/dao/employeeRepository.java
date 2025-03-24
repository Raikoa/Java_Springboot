package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<Employee,Integer>{
}
