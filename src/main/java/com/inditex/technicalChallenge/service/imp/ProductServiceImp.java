package com.inditex.technicalChallenge.service.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inditex.technicalChallenge.model.Product;
import com.inditex.technicalChallenge.repository.ProductRepository;
import com.inditex.technicalChallenge.service.ProductService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImp implements ProductService{

	Logger logger = LoggerFactory.getLogger(ProductServiceImp.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProductById(long productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}else {
			return null;
		}
	}
	
	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	@Override
	public void insertProductByEntity(Product product) {
		productRepository.save(product);
		
		logger.info("Product was inserted");
	}
	
	public void insertProductByAttributes() {
		
		Product product = new Product();
		
		productRepository.save(product);
		
		logger.info("Product was inserted");
	}
}
