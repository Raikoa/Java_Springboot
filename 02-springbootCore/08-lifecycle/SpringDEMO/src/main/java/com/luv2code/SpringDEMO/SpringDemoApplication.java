package com.luv2code.SpringDEMO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(
		scanBasePackages = {"com.luv2code.SpringDEMO","com.luv2code.util"}
)*/
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
