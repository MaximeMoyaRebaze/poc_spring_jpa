package com.maxime.corePackage.domains.users.usecases.student;

import an.awesome.pipelinr.Command;
import com.maxime.corePackage.domains.users.response.StudentResponse;

public class CreateStudentRequest implements Command<StudentResponse> {
	private String name;

	public CreateStudentRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
