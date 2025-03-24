package com.CRUDEXAM.EXAM.DAO;

import com.CRUDEXAM.EXAM.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface DAO extends JpaRepository<Employee, Integer> {
}
