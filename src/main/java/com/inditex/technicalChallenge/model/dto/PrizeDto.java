package com.inditex.technicalChallenge.model.dto;

import java.util.Date;
import java.util.Objects;

import com.inditex.technicalChallenge.model.Brand;
import com.inditex.technicalChallenge.model.Prize;
import com.inditex.technicalChallenge.model.Product;

public class PrizeDto {

	private long prizeList;
	private long brandId;
	private Date startDate;
	private Date endDate;
	private long productId;
	private String price;
	
	public PrizeDto() {
		super();
	}
	
	public PrizeDto(long prizeList, long brandId, Date startDate, Date endDate, long product, String price) {
		super();
		this.prizeList = prizeList;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = product;
		this.price = price;
	}
	
	public PrizeDto(long prizeList, Brand brand, Date startDate, Date endDate, Product product, String price) {
		super();
		this.prizeList = prizeList;
		this.brandId = brand.getBrandId();
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = product.getProductId();
		this.price = price;
	}
	
	public PrizeDto(Prize prize) {
		super();
		this.prizeList = prize.getPrizeList();
		this.brandId = prize.getBrand().getBrandId();
		this.startDate = prize.getStartDate();
		this.endDate = prize.getEndDate();
		this.productId = prize.getProduct().getProductId();
		this.price = String.valueOf(prize.getPrice()) + prize.getCurr();
	}

	public long getPrizeList() {
		return prizeList;
	}

	public void setPrizeList(long prizeList) {
		this.prizeList = prizeList;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getProductId() {
		return productId;
	}

	public void setProduct(long productId) {
		this.productId = productId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandId, endDate, price, prizeList, productId, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrizeDto other = (PrizeDto) obj;
		return brandId == other.brandId && Objects.equals(endDate, other.endDate) && Objects.equals(price, other.price)
				&& prizeList == other.prizeList && productId == other.productId
				&& Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "PrizeDto [prizeList=" + prizeList + ", brandId=" + brandId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", product=" + productId + ", price=" + price + "]";
	}
}
