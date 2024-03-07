package com.maxime.testdatabasemysql.student;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student addStudent(Student student, URI type) {
		if (studentRepository.findByName(student.getName()).isPresent()) {
			throw new AlreadyExistException("student with the name '" + student.getName() + "' already exist", type);
		}
		studentRepository.save(student);
		return student;
	}

	public Boolean isStudentExist(String name) {
		return studentRepository.isStudentExist(name);
	}


}
