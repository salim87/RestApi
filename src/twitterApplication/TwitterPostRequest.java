package twitterApplication;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class TwitterPostRequest {

	String consumerkey="i2EKGHwVYsPc1mBw5sQwfXGe9";
	String consumerSecret="D2uZ3aajX8MVNZA02tZPE5xDerNdHXwYMudrVMlX78fgoe0TcN";
	String accessToken="87446216-HIkXaEQhmstNqJQKQ65vaAXF8K3idjw7iJ1wmwgNp";
	String accessSecret="D8cKpVz5wKeJKO8wxCpvhZSeoK0AwCmMqJfvsQNXR6nwa";
	@BeforeClass
	public void setup(){
		RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses";
	}
	@Test
	public void getResponse()
	{
		 given()
				.auth()
				.oauth(consumerkey, consumerSecret, accessToken, accessSecret)
				.queryParam("status", "My First Tweet")
			.when()
				.post("/update.json").then()
				.statusCode(200);
			
	}
	
}
