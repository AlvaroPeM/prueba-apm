package com.inditex.pruebaapm.model.implementation;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.pruebaapm.dto.pojo.PricesDto;
import com.inditex.pruebaapm.exception.business.BusinessException;
import com.inditex.pruebaapm.exception.referential.HttpStatusException;
import com.inditex.pruebaapm.mapper.map.PricesMapper;
import com.inditex.pruebaapm.model.entity.Prices;
import com.inditex.pruebaapm.model.repository.PricesDao;
import com.inditex.pruebaapm.model.service.PricesService;

@Service
public class PricesServiceImpl implements PricesService {
	
	
	private static final Logger log = LoggerFactory.getLogger(PricesServiceImpl.class);
	
	
	@Autowired
	private PricesDao pricesDao;
	
	@Autowired
	private PricesMapper pricesMapper;
	
	
	protected Prices findFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc(Long productId, Integer brandId, LocalDateTime date) {
		return pricesDao.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(productId, brandId, date, date).orElse(null);
	}

	
	@Override
	@Transactional(readOnly = true)
	public PricesDto getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc(Long productId, Integer brandId, LocalDateTime date) throws BusinessException {
		
		var prices = findFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc(productId, brandId, date);
		
		// Aquí debería aplicarse la lógica del servicio en caso de que hubiera
		
		if (prices == null) {
			log.error(HttpStatusException.NOT_FOUND.getMessage());
			throw new BusinessException(HttpStatusException.NOT_FOUND);
		}
		
		return pricesMapper.pricesToPricesDto(prices);
		
	}
	

}
