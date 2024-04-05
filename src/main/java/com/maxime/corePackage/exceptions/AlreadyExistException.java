package com.maxime.corePackage.exceptions;

import java.net.URI;

public class AlreadyExistException extends RuntimeException {

	private final URI type;
	public AlreadyExistException(String message, URI type) {
		super(message);
		this.type = type;
	}

	public URI getType() {
		return type;
	}

}
