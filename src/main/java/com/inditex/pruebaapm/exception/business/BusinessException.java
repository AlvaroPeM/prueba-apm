package com.inditex.pruebaapm.exception.business;

import org.springframework.http.HttpStatus;

import com.inditex.pruebaapm.exception.referential.HttpStatusException;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {

	
	private static final long serialVersionUID = -4033446668370553527L;
	
	private final HttpStatus status;
	
	private final String code;
	
	
	public BusinessException(HttpStatusException status) {
		super(status.getMessage());
		this.status = status.getStatus();
		this.code = status.getCode();
	}
	

}
