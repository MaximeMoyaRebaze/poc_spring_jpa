package com.maxime.corePackage.domains.users.response;

public class StudentResponse {
	private String name;

	public StudentResponse() {
	}

	public StudentResponse(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
