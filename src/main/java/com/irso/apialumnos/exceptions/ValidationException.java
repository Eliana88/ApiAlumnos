package com.irso.apialumnos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends BadRequestException {
	
	public ValidationException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

   

}