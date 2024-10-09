package com.inditex.technicalChallenge.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRIZE")
public class Prize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long prizeList;
	
	@ManyToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "brandId")
	private Brand brand;
	
	private Date startDate;
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;
	
	private int priority;
	private double price;
	private String curr;
	
	public Prize() {
		super();
	}

	public Prize(long prizeList, Brand brand, Date startDate, Date endDate, Product product, int priority, double price, String curr) {
		super();
		this.prizeList = prizeList;
		this.brand = brand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.product = product;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}
	
	public Prize(Brand brand, Date startDate, Date endDate, Product product, int priority, double price, String curr) {
		super();
		this.brand = brand;
		this.startDate = startDate;
		this.endDate = endDate;
		this.product = product;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}

	public long getPrizeList() {
		return prizeList;
	}

	public void setPrizeList(long prizeList) {
		this.prizeList = prizeList;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, curr, endDate, price, priority, prizeList, product, startDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prize other = (Prize) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(curr, other.curr)
				&& Objects.equals(endDate, other.endDate)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && priority == other.priority
				&& prizeList == other.prizeList && Objects.equals(product, other.product)
				&& Objects.equals(startDate, other.startDate);
	}

	@Override
	public String toString() {
		return "Prize [prizeList=" + prizeList + ", brand=" + brand + ", startDate=" + startDate + ", endDate="
				+ endDate + ", product=" + product + ", priority=" + priority + ", price=" + price + ", curr=" + curr
				+ "]";
	}
}
