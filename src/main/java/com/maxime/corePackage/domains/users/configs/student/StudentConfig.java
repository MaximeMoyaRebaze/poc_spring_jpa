package com.maxime.corePackage.domains.users.configs.student;

import com.maxime.corePackage.domains.users.entities.student.StudentEntity;
import com.maxime.corePackage.domains.users.repositories.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    public static final String studentConfigName = "student_";

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                StudentEntity studentEntity = new StudentEntity().withName(studentConfigName + i);
                studentRepository.saveAllAndFlush(List.of(studentEntity));
            }
        };
    }

}
