package com.luv2code.crudDemo.DAO;

import com.luv2code.crudDemo.Entity.Course;
import com.luv2code.crudDemo.Entity.Instructer_details;
import com.luv2code.crudDemo.Entity.Instructor;

import java.util.List;

public interface DAO {
    void save(Instructor instructor);
    Instructor findInstrructorByid(int id);

    void deleteById(int id);

    Instructer_details find_instructor_edetailsByid(int id);

    void deleteInstructordetailsbyid(int id);

    List<Course> findCourses(int id);

    Instructor findInstructorJoin(int id);

    void update(Instructor instructor);
}
