package com.maxime.testdatabasemysql.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

	public static final String studentConfig01Name = "student_01";

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			for (int i = 0; i < 1000; i++) {
				Student student = new Student().withName(studentConfig01Name);
				studentRepository.saveAllAndFlush(List.of(student));
			}
		};
	}

}
