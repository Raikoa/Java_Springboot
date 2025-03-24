package com.luv2code.crudDemo;

import com.luv2code.crudDemo.DAO.DAO;
import com.luv2code.crudDemo.Entity.Course;
import com.luv2code.crudDemo.Entity.Instructer_details;
import com.luv2code.crudDemo.Entity.Instructor;
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
	public CommandLineRunner commandLineRunner(DAO dao) {
		return runner -> {
			//deleteInstructor(dao);
			//find_details(dao);
			//deletedetail(dao);
			//createInstructor(dao);
			//createInstructorWithCourses(dao);
			//findInstructorCourses(dao);
			//findcourse(dao);
			//join_search(dao);
			updateInstructor(dao);
		};
	}

	private void updateInstructor(DAO dao) {
		int id = 1;
		Instructor temp = dao.findInstrructorByid(id);

		temp.setLastName("TESTER");

		dao.update(temp);
		System.out.println("done");
	}

	private void join_search(DAO dao) {
		int id = 1;
		Instructor temp = dao.findInstructorJoin(id);
		System.out.println(temp);
		System.out.println(temp.getCourses());
		System.out.println("done");
	}

	private void findcourse(DAO dao) {
		int id = 1;
		Instructor temp = dao.findInstrructorByid(id);
		System.out.println(temp);
		List<Course> courses = dao.findCourses(id);

		temp.setCourses(courses);
		System.out.println(temp.getCourses());

	}

	private void findInstructorCourses(DAO dao) {
		int id = 1;
		Instructor temp = dao.findInstrructorByid(id);
		System.out.println(temp);
		System.out.println(temp.getCourses());
		System.out.println("done");
	}

	private void createInstructorWithCourses(DAO dao) {
		Instructor instructor = new Instructor("susan","rere","sus@gmail.com");
		Instructer_details instructer_details = new Instructer_details("sdsf","ddastuff");
		instructor.setInstructer_details(instructer_details);
		Course temp = new Course("guitar");
		Course temp1 = new Course("weak");
		instructor.add(temp);
		instructor.add(temp1);
		dao.save(instructor);
	}

	private void deletedetail(DAO dao) {
		int id = 3;
		dao.deleteInstructordetailsbyid(id);
		System.out.println("done");
	}

	private void find_details(DAO dao) {
		int id = 3;
		Instructer_details temp = dao.find_instructor_edetailsByid(id);
		System.out.println(temp);
		System.out.println(temp.getInstructor());
		System.out.println("Done");
	}

	private void deleteInstructor(DAO dao) {
		int id = 1;
		dao.deleteById(1);
		System.out.println("deleting");
	}

	private void createInstructor(DAO dao){
		//Instructor instructor = new Instructor("paul","lase","paul@gmail.com");
		//Instructer_details instructer_details = new Instructer_details("youtube","watching movies");
		Instructor instructor = new Instructor("chad","resc","chad@gmail.com");
		Instructer_details instructer_details = new Instructer_details("stuff","doing stuff");
		instructor.setInstructer_details(instructer_details);
		System.out.println("saving " + instructor);
		dao.save(instructor);
	}

	private void findInstructor(DAO dao){
		int id =2;
		Instructor temp = dao.findInstrructorByid(id);
		System.out.println(temp);
		System.out.println(temp.getInstructer_details());
	}
}
