package RequestAndResponse;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.addPlace;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class PostResponsePOJO {

	@BeforeClass
	public void setup(){
		RestAssured.baseURI="https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
	}
	@Test
	public void getResponse()
	{
		Map <String, Double> locationMap= new HashMap<String, Double>();
		locationMap.put("lat",-33.8669710 );
		locationMap.put("lng", 151.1958750);
		
		List<String> types=new ArrayList<String>();
		types.add("shoe_store");
		addPlace places=new addPlace();
		places.setAccuracy(50);
		places.setName("");
		places.setPhone_number("");
		places.setTypes(types);
		places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
		places.setWebsite("http://www.google.com.au/");
		places.setLanguage("en-AU");
		
		 given()
		.queryParam("key", "AIzaSyDPHRlXJUOgUW9WXygRGzo5jY2ufRM9Xr4")
		.body(places)
		.when()
		.post("/place/add/json")
		.then()
		.statusCode(200);
		//.and()
		//.contentType(ContentType.JSON).and()
		//.body("scope", equalTo("APP"));
		
		
	}
	
}
