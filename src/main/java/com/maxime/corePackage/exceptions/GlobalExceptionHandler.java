package com.maxime.corePackage.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ AlreadyExistException.class })
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(AlreadyExistException ex) {

		// With Static :
		// ErrorResponse errorResponse = ErrorResponse.create(ex, HttpStatusCode.valueOf(HttpStatus.CONFLICT.value()),ex.getMessage());

		// With BUILDER :
		ErrorResponse errorResponse = ErrorResponse.builder(ex, HttpStatusCode.valueOf(HttpStatus.CONFLICT.value()),ex.getMessage())
				//.header("headerName","HeaderValue")
				//.typeMessageCode("")
				.title("AlreadyExist")
				//.titleMessageCode(ex.getMessage())
				.detail(ex.getMessage())
				//.detailMessageCode("")
				//.detailMessageArguments("")
				.type(ex.getType())
				.build();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
	}

	// Other exception handlers

}