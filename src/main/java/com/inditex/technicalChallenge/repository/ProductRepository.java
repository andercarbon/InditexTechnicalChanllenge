package com.inditex.technicalChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.technicalChallenge.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
