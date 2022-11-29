package com.inditex.pruebaapm.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.inditex.pruebaapm.controller.response.ErrorResponse;
import com.inditex.pruebaapm.controller.response.PreValidationErrorResponse;
import com.inditex.pruebaapm.exception.business.BusinessException;
import com.inditex.pruebaapm.exception.pojo.ConstraintViolationError;
import com.inditex.pruebaapm.exception.referential.HttpStatusException;

@ControllerAdvice
public class RestExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
			
		var exception = new BusinessException(HttpStatusException.INTERNAL_SERVER_ERROR);
		
		var response = new ErrorResponse(exception);

		return ResponseEntity.status(exception.getStatus()).body(response);

	}
	
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
			
		var response = new ErrorResponse(ex);

		return ResponseEntity.status(ex.getStatus()).body(response);

	}	
	
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<ErrorResponse> handleBusinessException(MethodArgumentTypeMismatchException ex) {
		
		var exception = new BusinessException(HttpStatusException.BAD_REQUEST);
		
		var error = new ConstraintViolationError(ex.getName(),ex.getCause(),ex.getValue().toString());
		
		var response = new PreValidationErrorResponse(exception, error);	
		
		return ResponseEntity.status(exception.getStatus()).body(response);

	}
	

}

