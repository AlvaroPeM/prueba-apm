package com.inditex.pruebaapm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.inditex.pruebaapm.exception.referential.HttpStatusException;

@SpringBootTest
@AutoConfigureMockMvc
class PruebaApmApplicationTests {
	
	
	@Autowired
    private MockMvc mvc;
	
	
	@Test
	void integrationTestPricesControllerWrongProductId() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/1A/12/2000-10-31T01:30:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isBadRequest())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.erreurCode").value(HttpStatusException.BAD_REQUEST.getCode()));
		} catch (Exception e) {

		}
		
	}
	
	@Test
	void integrationTestPricesControllerWrongBrandId() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/1/12A/2000-10-31T01:30:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isBadRequest())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.erreurCode").value(HttpStatusException.BAD_REQUEST.getCode()));
		} catch (Exception e) {

		}
		
	}
	
	@Test
	void integrationTestPricesControllerWrongDate() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/1/12/2000-10-3AY").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isBadRequest())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.erreurCode").value(HttpStatusException.BAD_REQUEST.getCode()));
		} catch (Exception e) {

		}
		
	}
	
	@Test
	void integrationTestPricesControllerNotInDB() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/35454/0/2020-06-14T10:00:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isNotFound())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.erreurCode").value(HttpStatusException.NOT_FOUND.getCode()));
		} catch (Exception e) {

		}
		
	}
	
	
	@Test
	void test1() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/35455/1/2020-06-14T10:00:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.curr").value("EUR"));
		} catch (Exception e) {

		}
		
	}
	
	@Test
	void test2() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/35455/1/2020-06-14T16:00:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("2"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T15:00:00"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-14T18:30:00"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("25.45"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.curr").value("EUR"));
		} catch (Exception e) {

		}
		
	}
	
	@Test
	void test3() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/35455/1/2020-06-14T21:00:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-14T00:00:00"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("35.5"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.curr").value("EUR"));
		} catch (Exception e) {

		}
		
	}
	
	@Test
	void test4() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/35455/1/2020-06-15T10:00:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("3"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T00:00:00"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-06-15T11:00:00"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("30.5"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.curr").value("EUR"));
		} catch (Exception e) {

		}
		
	}
	
	@Test
	void test5() {
		
		try {
			mvc.perform(MockMvcRequestBuilders.get("/v1/getFirstByProductIdAndBrandIdAndBetweenDateOrderByPriorityDesc/35455/1/2020-06-16T21:00:00").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.productId").value("35455"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value("1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value("4"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.startDate").value("2020-06-15T16:00:00"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.endDate").value("2020-12-31T23:59:59"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.price").value("38.95"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.curr").value("EUR"));
		} catch (Exception e) {

		}
		
	}
	
	

}
