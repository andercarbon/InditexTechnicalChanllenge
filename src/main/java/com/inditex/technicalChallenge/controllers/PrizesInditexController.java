package com.inditex.technicalChallenge.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.inditex.technicalChallenge.model.dto.PrizeDto;
import com.inditex.technicalChallenge.service.PrizeService;

@RestController
public class PrizesInditexController {
	
	@Autowired
	private PrizeService prizeService;

	@GetMapping("/getPrizesOfProduct/{productId}/{brandName}/{applyDate}")
	public PrizeDto getPrizesOfProduct(@PathVariable("productId") long productId, @PathVariable("brandName") String brandName,
			@PathVariable("applyDate") String applyDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
		
		try {
			return prizeService.getPrizeDtoByProductBrandAndDate(productId, brandName, dateFormat.parse(applyDate));
		} catch (ParseException e) {
			e.printStackTrace();
			
			return null;
		}
	}
}
