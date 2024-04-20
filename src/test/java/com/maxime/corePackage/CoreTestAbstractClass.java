package com.maxime.corePackage;

import org.springframework.beans.factory.annotation.Autowired;

import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import com.maxime.corePackage.domains.users.repositories.student.InMemoryStudentRepository;
import com.maxime.corePackage.domains.users.repositories.student.StudentRepository;
import com.maxime.corePackage.domains.users.services.student.StudentService;
import com.maxime.corePackage.domains.users.usecases.student.CreateStudent;

import java.util.Objects;
import java.util.stream.Stream;

public abstract class CoreTestAbstractClass {

	@Autowired
	private StudentRepository studentRepository;
	public Pipeline pipeline = new Pipelinr().with(() -> Stream.of(new CreateStudent(getStudentRepository())));
	@Autowired
	private StudentService studentService;

	// GETTERS :

	public StudentRepository getStudentRepository() {
		if (Objects.isNull(studentRepository)) {
			this.studentRepository = new InMemoryStudentRepository();
		}
		return studentRepository;
	}

	public StudentService getStudentService() {
		if (Objects.isNull(studentService)) {
			this.studentService = new StudentService(getStudentRepository());
		}
		return studentService;
	}

}
