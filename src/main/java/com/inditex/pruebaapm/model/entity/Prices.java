package com.inditex.pruebaapm.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Prices implements Serializable {
	
	
	private static final long serialVersionUID = 4288070440608250385L;

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long techniqueId;
	
	
	// Aquí posiblemente debería haber alguna unión del tipo @ManyToOne
	@Column
	private Integer brandId;
	
	@Column
	private LocalDateTime startDate;
	
	@Column
	private LocalDateTime endDate;
	
	@Column
	private Integer priceList;
	
	@Column
	private Long productId;
	
	@Column
	private Integer priority;
	
	@Column
	private Double price;
	
	@Column
	private String curr;
	
	
}
