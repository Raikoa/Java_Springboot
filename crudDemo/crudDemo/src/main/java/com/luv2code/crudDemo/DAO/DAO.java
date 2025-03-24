package com.luv2code.crudDemo.DAO;

import com.luv2code.crudDemo.Entity.Instructor;

public interface DAO {
    void save(Instructor instructor);
    Instructor findInstrructorByid(int id);

    void deleteById(int id);
}
