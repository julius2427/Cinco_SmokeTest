package mav.cintastesting;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestTesting {
	public static void basicpingtest() {
		//Basic Body Response to JSON with Formatting
		
		RestAssured.baseURI = "https://www.cintas.com";
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/sitefinity/public/services/locationfinder.svc/search/45324/25");
		
		String responseBody = response.getBody().asString();
		//jo = jo.getAsJsonObject("MESSAGE");
		
//		String distance = (String) jo.get("distance");
		
		
		
//		Beautify the JSON...NOBODY CARES ABOUT BEING PRETTY!		
//		JsonParser parser = new JsonParser();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		JsonElement el = parser.parse(responseBody);
//		responseBody = gson.toJson(el);
		System.out.println("Response Body is => " + responseBody);
		
		
		
	}

	public static void basicpingtestxml() {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://www.cintas.com";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Accept","application/xml");
		Response response = httpRequest.request(Method.GET, "/sitefinity/public/services/locationfinder.svc/search/45324/25");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is => " + responseBody);
	}
}
