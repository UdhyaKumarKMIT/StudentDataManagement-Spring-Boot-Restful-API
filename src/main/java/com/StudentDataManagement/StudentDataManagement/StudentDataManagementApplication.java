package com.StudentDataManagement.StudentDataManagement;

import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StudentDataManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentDataManagementApplication.class, args);
	}
}
