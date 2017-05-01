package com.telstra.web.controllers;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.telstra.commons.utility.Environment;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RetailControllerTests {

    @Autowired
    private MockMvc mockMvc;

    
    @Test
    public void getDiscountsWithNoFilterTest() throws Exception {
        this.mockMvc.perform(get("/rest/v1/users/qa-test-user/discounts")).
        			 andDo(print()).andExpect(status().isOk());
    }
    
   
    @Test
    public void getDiscountsWithFilterTest() throws Exception {
        this.mockMvc.perform(get("/rest/v1/users/qa-test-user/discounts")
        		    .param("productId", "sku-1234567890"))
        			.andDo(print()).andExpect(status().isOk())
        			.andExpect(jsonPath("$.discounts[0].discountId").value("5-dollars-off"));
    }

    
    @Test
    public void getDiscountsUserNotFoundTest() throws Exception {
    	String uuid = "kalyan";
    	this.mockMvc.perform(get("/rest/v1/users/"+ uuid + "/discounts")
        		    .param("productId", "sku-1234567890"))
        			.andDo(print()).andExpect(jsonPath("$.code").value("ER0001"));
        			
        
    }

    @Test
    public void getDiscountsWithNoFilterNoInternetTest() throws Exception {
    	Environment.getInstance().getServerProp().put(Environment.INTERNET_OFF, "true");
        this.mockMvc.perform(get("/rest/v1/users/qa-test-user/discounts")).
        			 andDo(print()).andExpect(status().isOk());
        Environment.getInstance().getServerProp().put(Environment.INTERNET_OFF, "false");
    }
    
   
    @Test
    public void getDiscountsWithFilterNoInternetTest() throws Exception {
    	Environment.getInstance().getServerProp().put(Environment.INTERNET_OFF, "true");
        this.mockMvc.perform(get("/rest/v1/users/qa-test-user/discounts")
        		    .param("productId", "sku-1234567890"))
        			.andDo(print()).andExpect(status().isOk())
        			.andExpect(jsonPath("$.discounts[0].discountId").value("5-dollars-off"));
        Environment.getInstance().getServerProp().put(Environment.INTERNET_OFF, "false");
    }

    
    @Test
    public void getDiscountsUserNotFoundNoInternetTest() throws Exception {
    	Environment.getInstance().getServerProp().put(Environment.INTERNET_OFF, "true");
    	String uuid = "kalyan";
    	Environment.getInstance().getServerProp().put(Environment.INVALID_USER, "true");
        this.mockMvc.perform(get("/rest/v1/users/"+ uuid + "/discounts")
        		    .param("productId", "sku-1234567890"))
        			.andDo(print()).andExpect(jsonPath("$.code").value("ER0001"));
        Environment.getInstance().getServerProp().put(Environment.INTERNET_OFF, "false");
        			
        Environment.getInstance().getServerProp().put(Environment.INVALID_USER, "false");
    }
    

    
}
