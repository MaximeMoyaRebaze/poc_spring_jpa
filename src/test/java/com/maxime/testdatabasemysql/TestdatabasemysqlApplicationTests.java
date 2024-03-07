package com.maxime.testdatabasemysql;

import com.maxime.testdatabasemysql.student.Student;
import com.maxime.testdatabasemysql.student.StudentRepository;
import com.maxime.testdatabasemysql.student.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.List;

import static com.maxime.testdatabasemysql.student.StudentConfig.studentConfig01Name;

@SpringBootTest
// @ExtendWith({ WithMySQLExtension.class })
class TestdatabasemysqlApplicationTests {

	@Autowired
	StudentRepository studentRepository;
	private StudentService studentService;

	@BeforeEach
	void setUp() {
		studentService = new StudentService(studentRepository);
	}

	@Test
	void contextLoads() {

		studentService.addStudent(new Student().withName("Paul"), URI.create("test"));
		List<Student> students = studentService.getStudents();
		Assertions.assertThat(students).isNotEmpty();
		Assertions.assertThat(students.get(999).getName()).isEqualTo(studentConfig01Name);
		Assertions.assertThat(students.get(1000).getName()).isEqualTo("Paul");

	}

}
