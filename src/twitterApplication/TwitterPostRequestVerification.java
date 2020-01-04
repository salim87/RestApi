package twitterApplication;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class TwitterPostRequestVerification {

	String consumerkey="dncyTmNwHBQ28pIOD8jFAwabx";
	String consumerSecret="SeDOvU0AHoVdyMRi49ud0K0jsc1vr0qckYafcIIpqyRLJPyeCu";
	String accessToken="87446216-HIkXaEQhmstNqJQKQ65vaAXF8K3idjw7iJ1wmwgNp";
	String accessSecret="D8cKpVz5wKeJKO8wxCpvhZSeoK0AwCmMqJfvsQNXR6nwa";
	@BeforeClass
	public void setup(){
		RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses";
	}
	@Test
	
		public void extractResponse() {
			Response response = given()
				.auth()
				.oauth(consumerkey, consumerSecret, accessToken, accessSecret)
				.queryParam("status", "My First Tweet 3")
			.when()
				.post("/update.json")
			.then()
				.statusCode(200)
				.extract().response();
			System.out.println(response.asString());
			String id = response.path("id_str");
			System.out.println(id);
		}
			
	}
	

