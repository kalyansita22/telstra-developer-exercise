package com.telstra.web.json;

import java.util.ArrayList;
import java.util.List;

import com.telstra.model.Discount;

public class DiscountsJSON implements BasicResponse {
	List<Discount> discounts;
	
	public DiscountsJSON(List<Discount> discounts){
		this.discounts = discounts;
	}

	/**
	 * @return the discounts
	 */
	public List<Discount> getDiscounts() {
		return discounts;
	}

	/**
	 * @param discounts the discounts to set
	 */
	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}
	
}
