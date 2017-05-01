package com.telstra.web.services;

import com.telstra.web.json.BasicResponse;

public interface IRetailMetaModelService {
	
	public BasicResponse getDiscounts(String uuid,String productId);
	
}
