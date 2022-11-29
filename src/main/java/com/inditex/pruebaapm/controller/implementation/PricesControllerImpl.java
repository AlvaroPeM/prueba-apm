package com.inditex.pruebaapm.controller.implementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.pruebaapm.controller.response.DefaultResponse;
import com.inditex.pruebaapm.controller.service.PricesController;
import com.inditex.pruebaapm.exception.business.BusinessException;
import com.inditex.pruebaapm.mapper.map.PricesMapper;
import com.inditex.pruebaapm.model.service.PricesService;

@Validated
@RestController
@RequestMapping(value = "/v1")
public class PricesControllerImpl implements PricesController {
	
	
	@Autowired
	private PricesService pricesService;
	
	@Autowired
	private PricesMapper pricesMapper;
	

	@Override
	@GetMapping(value = "/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/{productId}/{brandId}/{date}", produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<DefaultResponse> getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc(
			 @PathVariable(name="productId", required=true) Long productId,
			 @PathVariable(name="brandId", required=true) Integer brandId,
			 @PathVariable(name="date", required=true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) throws BusinessException {
		
		
		var pricesDto = pricesService.getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc(productId, brandId, date);
		
		var pricesResponse = pricesMapper.pricesDtoToPricesControllerResponse(pricesDto);
		
		return ResponseEntity.ok(pricesResponse);
		
	}

	
}
