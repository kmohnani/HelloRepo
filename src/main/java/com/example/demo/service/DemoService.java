package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.utils.APIConstants;

@Service
public class DemoService {

	public Double perforCalculation(String source, String destination, Double value) throws Exception {
		Double result = 0.0;
		if(source.equals(APIConstants.FEET) && destination.equals(APIConstants.INCH)) {
			result = value * 12;
		} else if(source.equals(APIConstants.INCH) && destination.equals(APIConstants.FEET)) {
			result = value / 12;
		} else if(source.equals(APIConstants.SQ_FOOT) && destination.equals(APIConstants.SQ_YARD)) {
			result = value / 9;
		} else if(source.equals(APIConstants.SQ_YARD) && destination.equals(APIConstants.SQ_FOOT)) {
			result = value * 9;
		} else if(source.equals(APIConstants.GALLON) && destination.equals(APIConstants.LITRE)) {
			result = value * 3.785;
		} else if(source.equals(APIConstants.LITRE) && destination.equals(APIConstants.GALLON)) {
			result = value / 3.785;
		} else if(source.equals(APIConstants.KILOGRAM) && destination.equals(APIConstants.POUND)) {
			result = value * 2.205;
		} else if(source.equals(APIConstants.POUND) && destination.equals(APIConstants.KILOGRAM)) {
			result = value / 2.205;
		} else if(source.equals(APIConstants.CELCIUS) && destination.equals(APIConstants.FAHRENHEIT)) {
			result = (value * 9/5) + 32;
		} else if(source.equals(APIConstants.FAHRENHEIT) && destination.equals(APIConstants.CELCIUS)) {
			result = (value - 32) * 5/9;
		} else {
			throw new Exception("Un-supported "+APIConstants.SOURCE+" & "+APIConstants.DESTINATION+" are provided");
		}
		
		return result;
	}
}
