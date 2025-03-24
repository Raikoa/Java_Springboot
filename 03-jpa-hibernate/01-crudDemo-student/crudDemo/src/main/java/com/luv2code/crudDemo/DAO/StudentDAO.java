package com.luv2code.crudDemo.DAO;

import com.luv2code.crudDemo.Entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findByID(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String last);

    void update(Student newStudent);
    void delete(int ID);
    int deleteAll();

}
