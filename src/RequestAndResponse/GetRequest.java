package RequestAndResponse;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class GetRequest {

	@BeforeClass
	public void setup(){
		RestAssured.baseURI="https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
	}
	@Test(enabled=false)
	public void getResponse()
	{
		given().param("units", "imperial").param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyDPHRlXJUOgUW9WXygRGzo5jY2ufRM9Xr4")
		.when().get("/distancematrix/json")
		.then()
		.statusCode(200);
	}
	@Test
	public void getResponseVerification()
	{
		Response res=
		given().param("units", "imperial").param("origins", "Washington,DC")
		.param("destinations", "New+York+City,NY")
		.param("key", "AIzaSyDPHRlXJUOgUW9WXygRGzo5jY2ufRM9Xr4")
		.when().get("/distancematrix/json");
		
		System.out.println(res.body().prettyPrint());
	}

}
