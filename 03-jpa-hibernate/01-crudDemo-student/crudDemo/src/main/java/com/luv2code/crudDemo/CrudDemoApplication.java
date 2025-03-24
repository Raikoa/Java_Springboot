package com.luv2code.crudDemo;

import com.luv2code.crudDemo.DAO.StudentDAO;
import com.luv2code.crudDemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//CreateStudent(studentDAO);
			CreateMultipleStudent(studentDAO);
			//CreateAndRead(studentDAO);
			//queryForStudent(studentDAO);
			//queryWithLastName(studentDAO);
			//Update(studentDAO);
			//Del(studentDAO);
			//DelAll(studentDAO);
		};
	}

	private void DelAll(StudentDAO studentDAO) {
		int rows = studentDAO.deleteAll();
		System.out.println(rows + " rows deleted");
	}

	private void Del(StudentDAO studentDAO) {
		int Id =3;
		studentDAO.delete(Id);

	}

	private void Update(StudentDAO studentDAO) {
		int studentID = 1;
		Student myStudent = studentDAO.findByID(studentID);
		myStudent.setFirstname("John");
		studentDAO.update(myStudent);
		System.out.println(myStudent);
	}

	private void queryWithLastName(StudentDAO studentDAO) {
		List<Student> results = studentDAO.findByLastName("Schmo");
		for(Student i:results){
			System.out.println(i);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for(Student i: students){
			System.out.println(i);
		}
	}

	private void CreateAndRead(StudentDAO studentDAO) {
		System.out.println("Creating students");
		Student Daffy = new Student("Bob","Schmo","Bob@gmail.com");
		System.out.println("Saving");
		studentDAO.save(Daffy);
		int theid= Daffy.getId();
		System.out.println("ID: " + theid);
		System.out.println("Retreving");
		Student mystudent = studentDAO.findByID(theid);
		System.out.println("Result: " + mystudent);
	}

	private void CreateMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating new students");
		Student temp1 = new Student("john", "Doe", "john@luv2code.com");
		Student temp2 = new Student("Paul", "cooper", "Paul@luv2code.com");
		Student temp3 = new Student("Jane", "bob", "Jane@luv2code.com");
		System.out.println("Saving");
		studentDAO.save(temp1);
		studentDAO.save(temp2);
		studentDAO.save(temp3);
		System.out.println("ID: " + temp1.getId());
		System.out.println("ID: " + temp2.getId());
		System.out.println("ID: " + temp3.getId());
	}

	private void CreateStudent(StudentDAO studentDAO){
		System.out.println("Creating temp student");
		Student temp = new Student("john", "Doe", "john@luv2code.com");

		System.out.println("Saving");
		studentDAO.save(temp);

		System.out.println("ID: " + temp.getId());


	}



}
