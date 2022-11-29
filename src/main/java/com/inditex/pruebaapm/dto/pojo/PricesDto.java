package com.inditex.pruebaapm.dto.pojo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricesDto {
	
	
	private Integer brandId;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private Integer priceList;
	
	private Long productId;
	
	private Integer priority;
	
	private Double price;
	
	private String curr;
	

}
