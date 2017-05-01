package com.telstra.web.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telstra.web.json.BasicResponse;
import com.telstra.web.services.IRetailMetaModelService;
import com.telstra.web.services.IRetailModelService;

@Service
public class RetailMetaModelServices implements IRetailMetaModelService{

	@Autowired
	private IRetailModelService retailModelService;
	
	@Override
	public BasicResponse getDiscounts(String uuid,String productId) {
		
		return retailModelService.getDiscounts(uuid,
				productId);
	}

}
