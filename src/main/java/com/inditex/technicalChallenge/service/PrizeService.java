package com.inditex.technicalChallenge.service;

import java.util.Date;
import java.util.List;

import com.inditex.technicalChallenge.model.Prize;
import com.inditex.technicalChallenge.model.dto.PrizeDto;

public interface PrizeService {

	Prize getPrizeById(long prizeList);
	List<Prize> getAllPrize();
	void insertPrizeByEntity(Prize prize);
	Prize getPrizeByProductBrandAndDate(long productId, String brandName, Date applyDate);
	PrizeDto getPrizeDtoByProductBrandAndDate(long productId, String brandName, Date applyDate);
	boolean insertBrandByAttributes(long productId, String brandName, Date startDate, Date endDate, int priority,
			double price, String curr);
}
