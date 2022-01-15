package com.example.demo.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;
import com.example.demo.utils.APIConstants;
import com.example.demo.utils.CommonUtils;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;

	@PostMapping("/conversion")
	public String convertLength(@RequestBody String inputStr) throws Exception {
		try {
			String resultStr = "";
			JSONObject inputJson = CommonUtils.parse(inputStr);
			if(inputJson != null) {
				// Doing mandatory param check
				CommonUtils.performMandatoryChk(inputJson);
				
				Double result = 0.0;
				String source = inputJson.get(APIConstants.SOURCE).toString();
				String destination = inputJson.get(APIConstants.DESTINATION).toString();
				Double value = CommonUtils.getDouble(inputJson, APIConstants.VALUE);
				
				result = demoService.perforCalculation(source, destination, value);
				
				resultStr = "Conversion Result: " + result + " " + destination;
			}
			
			return CommonUtils.successResponse(resultStr).toJSONString();
		} catch(Exception e) {
			String msg = e.getMessage() != null ? e.getMessage() : "Some exception occurred"; 
			System.out.println(msg);
			return CommonUtils.failureResponse(msg).toJSONString();
		}
	}
}
