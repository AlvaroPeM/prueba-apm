package com.inditex.pruebaapm.model.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inditex.pruebaapm.model.entity.Prices;

@Repository
public interface PricesDao extends JpaRepository<Prices, Long> {
	
	
	Optional<Prices> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Long productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate);
	

}
