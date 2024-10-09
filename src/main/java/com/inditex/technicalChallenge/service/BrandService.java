package com.inditex.technicalChallenge.service;

import java.util.List;

import com.inditex.technicalChallenge.model.Brand;

public interface BrandService {

	Brand getBrandById(long brandId);
	public Brand getBrandByBrandName(String brandName);
	List<Brand> getAllBrand();
	void insertBrandByEntity(Brand brand);
	void insertBrandByAttributes(String brandName);
}
