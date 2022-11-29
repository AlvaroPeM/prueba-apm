package com.inditex.pruebaapm.controller.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricesControllerResponse extends DefaultResponse {
	
	
	private Long productId;
	
	private Integer brandId;
	
	private Integer priceList;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private Double price;
	
	private String curr;

	
	public PricesControllerResponse() {
		super.setStatus(HttpStatus.OK.value());
	}

	
}
