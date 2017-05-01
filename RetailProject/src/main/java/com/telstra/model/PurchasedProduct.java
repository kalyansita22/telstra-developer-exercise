package com.telstra.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PurchasedProduct implements Serializable{

	String productId;
	String description;
	BigDecimal originalPrice;
	BigDecimal finalPrice;
	Discount discountInformation;
	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the originalPrice
	 */
	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}
	/**
	 * @param originalPrice the originalPrice to set
	 */
	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}
	/**
	 * @return the finalPrice
	 */
	public BigDecimal getFinalPrice() {
		return finalPrice;
	}
	/**
	 * @param finalPrice the finalPrice to set
	 */
	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}
	/**
	 * @return the discountInformation
	 */
	public Discount getDiscountInformation() {
		return discountInformation;
	}
	/**
	 * @param discountInformation the discountInformation to set
	 */
	public void setDiscountInformation(Discount discountInformation) {
		this.discountInformation = discountInformation;
	}
	
	
	

}
