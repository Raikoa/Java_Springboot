package com.luv2code.crudDemo.Service;

import com.luv2code.crudDemo.Entity.Employee;
import com.luv2code.crudDemo.dao.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Serviceimpl implements EmployeeService{
    private employeeRepository repo;
    @Autowired
    public Serviceimpl(employeeRepository dao){
        this.repo = dao;
    }

    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = repo.findById(id);
        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }else{
            throw new RuntimeException("no such id");
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return repo.save(theEmployee);
    }

    @Override
    public void Delete(int id) {
        repo.deleteById(id);
    }
}
