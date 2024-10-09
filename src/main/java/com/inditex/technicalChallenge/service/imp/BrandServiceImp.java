package com.inditex.technicalChallenge.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.technicalChallenge.model.Brand;
import com.inditex.technicalChallenge.repository.BrandRepository;
import com.inditex.technicalChallenge.service.BrandService;

@Service
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImp implements BrandService{

	Logger logger = LoggerFactory.getLogger(BrandServiceImp.class);
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Override
	public Brand getBrandById(long brandId) {
		Optional<Brand> optionalBrand = brandRepository.findById(brandId);
		
		if(optionalBrand.isPresent()) {
			return optionalBrand.get();
		}else {
			return null;
		}
	}
	
	@Override
	public Brand getBrandByBrandName(String brandName) {
		Optional<Brand> optionalBrand = brandRepository.findByBrandName(brandName);
		
		if(optionalBrand.isPresent()) {
			return optionalBrand.get();
		}else {
			return null;
		}
	}
	
	@Override
	public List<Brand> getAllBrand() {
		return brandRepository.findAll();
	}
	
	@Override
	public void insertBrandByEntity(Brand brand) {
		brandRepository.save(brand);
		
		logger.info("Brand was inserted");
	}
	
	@Override
	public void insertBrandByAttributes(String brandName) {
		
		Brand brand = new Brand();
		
		brand.setBrandName(brandName);
		brandRepository.save(brand);
		
		logger.info("Brand was inserted");
	}
}
