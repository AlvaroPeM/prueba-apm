package com.inditex.pruebaapm.model.service;

import java.time.LocalDateTime;

import com.inditex.pruebaapm.dto.pojo.PricesDto;
import com.inditex.pruebaapm.exception.business.BusinessException;

public interface PricesService {
	
	
	public PricesDto getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc(Long productId, Integer brandId, LocalDateTime date) throws BusinessException;
	

}
