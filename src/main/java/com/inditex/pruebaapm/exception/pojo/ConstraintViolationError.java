package com.inditex.pruebaapm.exception.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConstraintViolationError {
	
	
	String parameterName;
	
	Object parameterValue;
	
	String detailMessage;
	

}
