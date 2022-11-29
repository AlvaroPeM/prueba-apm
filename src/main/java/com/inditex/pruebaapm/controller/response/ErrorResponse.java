package com.inditex.pruebaapm.controller.response;

import com.inditex.pruebaapm.exception.business.BusinessException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse extends DefaultResponse {

	
	private String erreurCode;
	
	private String erreurMessage;

	
	public ErrorResponse(BusinessException exception) {
		super.setStatus(exception.getStatus().value());
		this.erreurCode = exception.getCode();
		this.erreurMessage = exception.getMessage();
	}
	
	
}
