package com.inditex.technicalChallenge.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.technicalChallenge.model.Brand;
import com.inditex.technicalChallenge.model.Prize;
import com.inditex.technicalChallenge.model.Product;
import com.inditex.technicalChallenge.model.dto.PrizeDto;
import com.inditex.technicalChallenge.repository.PrizeRepository;
import com.inditex.technicalChallenge.service.BrandService;
import com.inditex.technicalChallenge.service.PrizeService;
import com.inditex.technicalChallenge.service.ProductService;

@Service
@Transactional(rollbackFor = Exception.class)
public class PrizeServiceImp implements PrizeService{

	Logger logger = LoggerFactory.getLogger(PrizeServiceImp.class);
	
	@Autowired
	private PrizeRepository prizeRepository;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ProductService prodcutService;
	
	@Override
	public Prize getPrizeById(long prizeList) {
		Optional<Prize> optionalPrize = prizeRepository.findById(prizeList);
		
		if(optionalPrize.isPresent()) {
			return optionalPrize.get();
		}else {
			return null;
		}
	}
	
	@Override
	public Prize getPrizeByProductBrandAndDate(long productId, String brandName, Date applyDate) {
		
		Brand brand = brandService.getBrandByBrandName(brandName);
		Product product = prodcutService.getProductById(productId);
		
		List<Prize> prizes;
		
		if(brand!=null&&product!=null) {
			prizes = prizeRepository.findByProductBrandAndApplyDateOrderByPriorityDesc(product, brand, applyDate);
			
			if(prizes!=null&&prizes.size()>0) {
				return prizes.get(0);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	@Override
	public PrizeDto getPrizeDtoByProductBrandAndDate(long productId, String brandName, Date applyDate) {
		
		PrizeDto prizeDto;
		
		Prize prize = getPrizeByProductBrandAndDate(productId, brandName, applyDate);
		
		if(prize != null) {
			prizeDto = new PrizeDto(prize);
		}else {
			prizeDto = null;
		}
		
		return prizeDto;
	}
	
	@Override
	public List<Prize> getAllPrize() {
		return prizeRepository.findAll();
	}
	
	@Override
	public void insertPrizeByEntity(Prize prize) {
		prizeRepository.save(prize);
		
		logger.info("Prize was inserted");
	}
	
	@Override
	public boolean insertBrandByAttributes(long productId, String brandName, Date startDate, Date endDate, int priority, double price, String curr) {
		
		Prize prize;
		
		Brand brand = brandService.getBrandByBrandName(brandName);
		Product product = prodcutService.getProductById(productId);
		
		if(brand!=null&&product!=null) {
			
			prize = new Prize(brand, startDate, endDate, product, priority, price, curr);
			
			prizeRepository.save(prize);
			
			logger.info("Prize was inserted");
			
			return true;
		}else {
			return false;
		}
	}
}
