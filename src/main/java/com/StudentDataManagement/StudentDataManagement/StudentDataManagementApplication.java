package com.StudentDataManagement.StudentDataManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.StudentDataManagement.StudentDataManagement.Repository") // Add this line
public class StudentDataManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentDataManagementApplication.class, args);
	}
}
