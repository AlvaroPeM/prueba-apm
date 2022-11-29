package com.inditex.pruebaapm.mapper.map;

import org.mapstruct.Mapper;

import com.inditex.pruebaapm.controller.response.PricesControllerResponse;
import com.inditex.pruebaapm.dto.pojo.PricesDto;
import com.inditex.pruebaapm.model.entity.Prices;

@Mapper(componentModel = "spring")
public interface PricesMapper {
	
	PricesDto pricesToPricesDto(Prices source);
	
	PricesControllerResponse pricesDtoToPricesControllerResponse(PricesDto source);

}
