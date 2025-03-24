package com.luv2code.crudDemo.dao;

import com.luv2code.crudDemo.Entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOimpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOimpl(EntityManager entityManager1){
        this.entityManager = entityManager1;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> result = theQuery.getResultList();
        return result;
    }

    @Override
    public Employee findById(int id) {
        Employee TargetEmployee = entityManager.find(Employee.class,id);
        return TargetEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void Delete(int id) {
        Employee target = entityManager.find(Employee.class,id);
        entityManager.remove(target);
    }
}
