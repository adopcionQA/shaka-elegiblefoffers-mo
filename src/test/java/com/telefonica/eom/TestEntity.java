package com.telefonica.eom;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.telefonica.eom.commons.Constant;

@SpringBootTest
class TestEntity {

	public MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext context;
	
	@BeforeEach
    public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
	@Test
	void getOfferingsTest() throws Exception {
		String url = "/offerings";
		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		
		params.add("action", "CH");
		params.add("region", "15");
		params.add("productType", "mobile");
		params.add("categoryId", "1220911");
		params.add("customerId", "56843169");
		params.add("isRetention", "false");
		params.add("customerSegment", "R");
		params.add("sourceType", "OFFER");
		params.add("creditScore", "9999");
		params.add("creditLimit", "999");
		params.add("siteId", "05650001");
		params.add("dealerId", "05650");
		params.add("paginationInfoSize", "100");
		params.add("paginationInfoPageCount", "1");
		params.add("paginationInfoPage", "1");
		params.add("paginationInfoMaxResultCount", "1");
		params.add("sortCriteriaName", "NAME");
		params.add("sortCriteriaAscending", "true");
		params.add("product", "Control");
		params.add("isPortability", "false");
		params.add("productId", "8091659649");
		params.add("planId", "4348019");
		params.add("planRankInitial", "9999");
		params.add("subscriberGroupValue", "POS2");
		params.add("productOfferingCatalogId", "1814373");
		params.add("type", "elegibles");
		params.add("productPublicId", "920951098");
		
		mockMvc
			.perform(
					get(url)
					.params(params)
					.header("Origin", "*")
					.header("Accept-Encoding", "gzip, deflate, br")
					.header("Connection", "keep-alive")
					.accept(MediaType.ALL)
					.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
			)
			.andDo(print())
			.andExpect(status().isOk());
		
		//	assertEquals(Constant.CODE_200, result.getResponse().getStatus());
	}


}
