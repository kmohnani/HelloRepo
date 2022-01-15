package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.service.DemoService;
import com.example.demo.utils.APIConstants;

class TestDemoService {

	DemoService ds = new DemoService();
	
	@Test
	void testMetricAndImperialConversions1() throws Exception {
		Double expectedValue = 12.0;
		Double actualValue = ds.perforCalculation(APIConstants.FEET, APIConstants.INCH, 1.0);
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testMetricAndImperialConversions2() throws Exception {
		Double expectedValue = 5.0;
		Double actualValue = ds.perforCalculation(APIConstants.SQ_FOOT, APIConstants.SQ_YARD, 45.0);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	void testMetricAndImperialConversions3() throws Exception {
		Double expectedValue = 4.0;
		Double actualValue = ds.perforCalculation(APIConstants.LITRE, APIConstants.GALLON, 22.0);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	void testMetricAndImperialConversions4() throws Exception {
		Double expectedValue = 30.0;
		Double actualValue = ds.perforCalculation(APIConstants.POUND, APIConstants.KILOGRAM, 15.0);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	void testMetricAndImperialConversions5() throws Exception {
		Double expectedValue = 212.0;
		Double actualValue = ds.perforCalculation(APIConstants.CELCIUS, APIConstants.FAHRENHEIT, 100.0);
		assertEquals(expectedValue, actualValue);
	}
}
