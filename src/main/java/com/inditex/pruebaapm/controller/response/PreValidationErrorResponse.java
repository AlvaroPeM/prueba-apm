package com.inditex.pruebaapm.controller.response;

import com.inditex.pruebaapm.exception.business.BusinessException;
import com.inditex.pruebaapm.exception.pojo.ConstraintViolationError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreValidationErrorResponse extends ErrorResponse {
	
	
	private ConstraintViolationError constraintViolationError;
	
	
	public PreValidationErrorResponse(BusinessException exception, ConstraintViolationError constraintViolationError) {
		super(exception);
		this.constraintViolationError = constraintViolationError;
	}
	
	
}