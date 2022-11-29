package com.inditex.pruebaapm.controller.service;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

import com.inditex.pruebaapm.controller.response.DefaultResponse;
import com.inditex.pruebaapm.exception.business.BusinessException;

public interface PricesController {
	
	
	ResponseEntity<DefaultResponse> getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc(Long productId, Integer brandId, LocalDateTime date) throws BusinessException;


}
