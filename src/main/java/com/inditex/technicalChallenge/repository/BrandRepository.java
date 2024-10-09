package com.inditex.technicalChallenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.technicalChallenge.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{

	public Optional<Brand> findByBrandName(String brandName);
}
