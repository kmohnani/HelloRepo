package com.example.demo.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommonUtils {

	private static JSONParser parser = new JSONParser();
	
	public static JSONObject parse(String strObj)  {
		try {
			JSONObject json = (JSONObject) parser.parse(strObj);
			return json;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject successResponse(Object obj) {
		JSONObject result = new JSONObject();
		result.put("success", true);
		result.put("result", obj);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject failureResponse(Object obj) {
		JSONObject result = new JSONObject();
		result.put("success", false);
		result.put("result", obj);
		return result;
	}
	
	public static void performMandatoryChk(JSONObject inputJson) throws Exception {
		if(inputJson != null) {
			if(inputJson.get("Source") == null || "".equals(inputJson.get("Source"))) {
				throw new Exception("Following mandatory parameter not passed: Source");
			}
			if(inputJson.get("Destination") == null || "".equals(inputJson.get("Destination"))) {
				throw new Exception("Following mandatory parameter not passed: Destination");
			}
			if(inputJson.get("Value") == null || "".equals(inputJson.get("Value"))) {
				throw new Exception("Following mandatory parameter not passed: Value");
			}
		}
	}
	
	public static Double getDouble(JSONObject inputJson, String key) throws Exception {
		Double value = 0.0;
		if(inputJson != null && key != null && !"".equals(key)) {
			try {
				value = Double.parseDouble(inputJson.get("Value").toString());
			} catch(NumberFormatException e) {
				throw new Exception("Invalid input: Non numeric input provided for - Value");
			}
		}
		
		return value;
	}
}
