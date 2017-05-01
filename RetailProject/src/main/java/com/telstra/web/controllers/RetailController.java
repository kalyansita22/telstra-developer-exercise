package com.telstra.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.web.json.BasicResponse;
import com.telstra.web.services.IRetailMetaModelService;

@RestController
public class RetailController {
    
    @Autowired
	private IRetailMetaModelService retailMetaModelService;

    
    @RequestMapping("/rest/v1/users/{uuid}/discounts")
    public BasicResponse getDiscounts(@PathVariable("uuid") String uuid,@RequestParam(value="productId",required=false) String productId) {
       	return retailMetaModelService.getDiscounts(uuid,productId);
    }
}
