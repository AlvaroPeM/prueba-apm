package com.inditex.pruebaapm.exception.referential;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpStatusException {
	
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "Err-1", "The request format is not correct"),
	NOT_FOUND(HttpStatus.NOT_FOUND, "Err-2", "There is no record in prices table for the input parameters"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Err-3", "An unexpected error has occurred");
	
	private final HttpStatus status;
		
	private final String code;
	
	private final String message;		
	

}
