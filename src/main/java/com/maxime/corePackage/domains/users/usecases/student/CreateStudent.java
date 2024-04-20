package com.maxime.corePackage.domains.users.usecases.student;

import an.awesome.pipelinr.Command;
import com.maxime.corePackage.domains.users.entities.student.StudentEntity;
import com.maxime.corePackage.domains.users.repositories.student.StudentRepository;
import com.maxime.corePackage.domains.users.response.StudentResponse;
import com.maxime.corePackage.utils.exceptions.AlreadyExistException;

public class CreateStudent implements Command.Handler<CreateStudentRequest, StudentResponse> {

	private final StudentRepository studentRepository;

	public CreateStudent(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public StudentResponse handle(CreateStudentRequest createStudentRequest) {
		if (studentRepository.findByName(createStudentRequest.getName()).isPresent()) {
			throw new AlreadyExistException(
					"student with the name '" + createStudentRequest.getName() + "' already exist");
		}
		StudentEntity studentEntity = studentRepository.save(
				new StudentEntity().withCreateStudentRequest(createStudentRequest));
		return new StudentResponse(studentEntity.getName());
	}

}
