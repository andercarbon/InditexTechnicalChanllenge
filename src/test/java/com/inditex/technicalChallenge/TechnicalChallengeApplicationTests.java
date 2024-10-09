package com.inditex.technicalChallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.technicalChallenge.model.Product;
import com.inditex.technicalChallenge.model.dto.PrizeDto;
import com.inditex.technicalChallenge.service.BrandService;
import com.inditex.technicalChallenge.service.PrizeService;
import com.inditex.technicalChallenge.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TechnicalChallengeApplicationTests extends AbstractTest {
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PrizeService prizeService;
	
	public void setUp() {
		super.setUp();
	}
	
	@Test
	@Order(1)
	void contextLoads() {
		
		Date startDate = new Date();
		Date endDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		setUp();
		
		if(brandService.getBrandByBrandName("ZARA")==null) {
			brandService.insertBrandByAttributes("ZARA");
		}
		if(productService.getProductById(35455)==null) {
			productService.insertProductByEntity(new Product(35455, "", ""));
		}
		
		if(prizeService.getAllPrize().size()==0) {
			try {
				startDate = dateFormat.parse("2020-06-14 00:00:00");
				endDate = dateFormat.parse("2020-12-31 23:59:59");
				
				prizeService.insertBrandByAttributes(35455, "ZARA", startDate, endDate, 0, 35.50, "EUR");
				
				startDate = dateFormat.parse("2020-06-14 15:00:00");
				endDate = dateFormat.parse("2020-06-14 18:30:00");
				
				prizeService.insertBrandByAttributes(35455, "ZARA", startDate, endDate, 1, 25.45, "EUR");
				
				startDate = dateFormat.parse("2020-06-15 00:00:00");
				endDate = dateFormat.parse("2020-06-15 11:00:00");
				
				prizeService.insertBrandByAttributes(35455, "ZARA", startDate, endDate, 1, 30.50, "EUR");
				
				startDate = dateFormat.parse("2020-06-15 16:00:00");
				endDate = dateFormat.parse("2020-12-31 23:59:59");
				
				prizeService.insertBrandByAttributes(35455, "ZARA", startDate, endDate, 1, 38.95, "EUR");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	@Order(2)
	public void test1() throws Exception {
		setUp();

		ObjectMapper objectMapper = new ObjectMapper();
		
		PrizeDto testPrizeDto;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/getPrizesOfProduct/"+ 35455 + "/" + "ZARA" + "/" + "2020-06-14-10.00.00")
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		
		PrizeDto getterPrize = objectMapper.readValue(content, PrizeDto.class);
		
		testPrizeDto = fillPrizeDto(1, 1, "2020-06-14 00:00:00", "2020-12-31 23:59:59", 35455, "35.5EUR");
		
		assertEquals(testPrizeDto, getterPrize);
	}
	
	@Test
	@Order(3)
	public void test2() throws Exception {
		setUp();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		PrizeDto testPrizeDto;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/getPrizesOfProduct/"+ 35455 + "/" + "ZARA" + "/" + "2020-06-14-16.00.00")
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			
			PrizeDto getterPrize = objectMapper.readValue(content, PrizeDto.class);
			
			testPrizeDto = fillPrizeDto(2, 1, "2020-06-14 15:00:00", "2020-06-14 18:30:00", 35455, "25.45EUR");
			
			assertEquals(testPrizeDto, getterPrize);
	}
	
	@Test
	@Order(4)
	public void test3() throws Exception {
		setUp();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		PrizeDto testPrizeDto;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/getPrizesOfProduct/"+ 35455 + "/" + "ZARA" + "/" + "2020-06-14-21.00.00")
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			
			PrizeDto getterPrize = objectMapper.readValue(content, PrizeDto.class);
			
			testPrizeDto = fillPrizeDto(1, 1, "2020-06-14 00:00:00", "2020-12-31 23:59:59", 35455, "35.5EUR");
			
			assertEquals(testPrizeDto, getterPrize);
	}
	
	@Test
	@Order(5)
	public void test4() throws Exception {
		setUp();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		PrizeDto testPrizeDto;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/getPrizesOfProduct/"+ 35455 + "/" + "ZARA" + "/" + "2020-06-15-10.00.00")
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			
			PrizeDto getterPrize = objectMapper.readValue(content, PrizeDto.class);
			
			testPrizeDto = fillPrizeDto(3, 1, "2020-06-15 00:00:00", "2020-06-15 11:00:00", 35455, "30.5EUR");
			
			assertEquals(testPrizeDto, getterPrize);
	}

	@Test
	@Order(6)
	public void test5() throws Exception {
		setUp();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		PrizeDto testPrizeDto;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/getPrizesOfProduct/"+ 35455 + "/" + "ZARA" + "/" + "2020-06-16-21.00.00")
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			int status = mvcResult.getResponse().getStatus();
			assertEquals(200, status);
			String content = mvcResult.getResponse().getContentAsString();
			
			PrizeDto getterPrize = objectMapper.readValue(content, PrizeDto.class);
			
			testPrizeDto = fillPrizeDto(4, 1, "2020-06-15 16:00:00", "2020-12-31 23:59:59", 35455, "38.95EUR");
			
			assertEquals(testPrizeDto, getterPrize);
	}
	
	private PrizeDto fillPrizeDto(long prizeList, long brand, String startDate, String endDate, long product, String price) {
		PrizeDto prizeDto = new PrizeDto();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		prizeDto.setBrandId(brand);
		prizeDto.setProduct(product);
		prizeDto.setPrizeList(prizeList);
		prizeDto.setPrice(price);
		try {
			prizeDto.setStartDate(dateFormat.parse(startDate));
			prizeDto.setEndDate(dateFormat.parse(endDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return prizeDto;
	}
}
