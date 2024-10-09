package com.inditex.technicalChallenge.service;

import java.util.List;

import com.inditex.technicalChallenge.model.Product;

public interface ProductService {

	Product getProductById(long productId);
	List<Product> getAllProduct();
	void insertProductByEntity(Product product);
}
