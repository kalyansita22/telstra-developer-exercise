package com.telstra.web.services.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.telstra.commons.utility.Environment;
import com.telstra.constants.TelstraConstants;
import com.telstra.model.Customer;
import com.telstra.web.controllers.Application;
import com.telstra.web.json.BasicResponse;
import com.telstra.web.json.DiscountsJSON;
import com.telstra.web.json.ErrorResponseJSON;
import com.telstra.web.services.IRetailModelService;
@Service
public class RetailModelServices implements IRetailModelService{
	private static final Logger log = LoggerFactory.getLogger(Application.class);
    
	@Override
	public BasicResponse getDiscounts(String uuid, String productId) {
		RestTemplate restTemplate = new RestTemplate();
    	Customer customer = null;
    	try{
    		if(Environment.getInstance().isInternetOff()){
    			String reqInpFile = "";
    			if(Environment.getInstance().isInvalidUser()){
    				reqInpFile = TelstraConstants.INVALID_RESPONSE_FILE;
    				try {
    					FileInputStream fis = new FileInputStream(reqInpFile);
    					ObjectInputStream ois = new ObjectInputStream(fis);
    					ErrorResponseJSON response = (ErrorResponseJSON) ois.readObject();
    					return response;
    				} catch (IOException | ClassNotFoundException e) {
    					log.error("Exception occured while loading file " + e.getMessage());
    				}
    			}
    			else{
    				reqInpFile = TelstraConstants.CUSTOMER_SERVICE_RESPONSE_FILE;
    				try {
    					FileInputStream fis = new FileInputStream(reqInpFile);
    					ObjectInputStream ois = new ObjectInputStream(fis);
    					customer = (Customer) ois.readObject();
    				} catch (IOException | ClassNotFoundException e) {
    					log.error("Exception occured while loading file " + e.getMessage());
    				}
    			}
    			
    		}else{
    		customer = restTemplate.getForObject(
				TelstraConstants.END_POINT_URL + uuid, Customer.class);
    		}
    		log.info(customer.toString());
    	}
    	catch(HttpClientErrorException  exp){
		    ErrorResponseJSON response = new ErrorResponseJSON();
			response.setCode("ER0001");
			response.setMessage("User " + uuid + " not found in the system.");
			
			return response;
    	}
    	if(productId != null)
    		return new DiscountsJSON(customer.findByProductId(productId));
    	else
    		return new DiscountsJSON(customer.getEligibleDiscounts());
    	
	}

}
