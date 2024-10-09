package com.inditex.technicalChallenge.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inditex.technicalChallenge.model.Brand;
import com.inditex.technicalChallenge.model.Prize;
import com.inditex.technicalChallenge.model.Product;

public interface PrizeRepository extends JpaRepository<Prize, Long>{

	@Query("SELECT p FROM Prize p WHERE p.product = ?1 and p.brand = ?2 and p.startDate < ?3 and p.endDate > ?3 ORDER BY p.priority DESC")
	List<Prize> findByProductBrandAndApplyDateOrderByPriorityDesc(Product product, Brand brand, Date applyDate);
}
