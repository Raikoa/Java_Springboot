package com.luv2code.demo.Rest;

import com.luv2code.demo.Entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Bob","cooper"));
        students.add(new Student("mario","jane"));
        students.add(new Student("john","fred"));
    }
    @GetMapping("/Students")
    public List<Student> getStudents(){


        return students;
    }

    @GetMapping("/Students/{studentID}")
    public Student getStudentById(@PathVariable int studentID){
        if(studentID < 0 || studentID >= students.size()){
            throw new StudentNotFound("No such ID");
        }
        return students.get(studentID);
    }


}
