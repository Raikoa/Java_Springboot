package com.luv2code.crudDemo;

import com.luv2code.crudDemo.DAO.DAO;
import com.luv2code.crudDemo.Entity.Instructer_details;
import com.luv2code.crudDemo.Entity.Instructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(DAO dao) {
		return runner -> {
			deleteInstructor(dao);
		};
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
