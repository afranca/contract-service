package com.starritt.contract.controllers;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ContractController.class)
public class ContractControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	//@MockBean
	//private ContractService contractService;	
	
	@Test
	public void testFirstBasicTest() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/"+ContractController.CONTRACT_BASE_URI+"/1")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"name\":\"alexandre\",\"id\":1}"))
				.andReturn();		
	}

}
