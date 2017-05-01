package com.telstra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer implements Serializable{
	
	String uuid;
	String name;
	String address;
	
	List<Discount> eligibleDiscounts;
	List<PurchasedProduct> products;

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the eligibleDiscounts
	 */
	public List<Discount> getEligibleDiscounts() {
		return eligibleDiscounts;
	}
	/**
	 * @return the eligibleDiscounts after filtering by productId
	 */
	
	public List<Discount> findByProductId(String productId) {
		ArrayList<Discount> discountsAfterFilter = new ArrayList<Discount>();
		for(Discount discount : getEligibleDiscounts()){
			if(discount.getProductId() !=null )
				if(discount.getProductId().equals(productId))
					discountsAfterFilter.add(discount);
		}
		return discountsAfterFilter;
	}
	/**
	 * @param eligibleDiscounts the eligibleDiscounts to set
	 */
	public void setEligibleDiscounts(List<Discount> eligibleDiscounts) {
		this.eligibleDiscounts = eligibleDiscounts;
	}
	/**
	 * @return the products
	 */
	public List<PurchasedProduct> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<PurchasedProduct> products) {
		this.products = products;
	}
			
}
