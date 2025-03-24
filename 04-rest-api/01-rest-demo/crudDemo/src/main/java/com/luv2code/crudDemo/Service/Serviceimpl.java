package com.luv2code.crudDemo.Service;

import com.luv2code.crudDemo.Entity.Employee;
import com.luv2code.crudDemo.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class Serviceimpl implements EmployeeService{
    private EmployeeDAO DAO;
    @Autowired
    public Serviceimpl(EmployeeDAO dao){
        this.DAO = dao;
    }

    @Override
    public List<Employee> findAll() {
        return DAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return DAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return DAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void Delete(int id) {
        DAO.Delete(id);
    }
}
