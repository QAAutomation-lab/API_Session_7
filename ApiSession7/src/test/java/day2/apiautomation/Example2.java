package day2.apiautomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Example2 {

	@Test
	public void tc5_getUserList() {
		RestAssured.baseURI = "https://reqres.in/";
		Response res = RestAssured.given()
						.header("Content-Type", "application/json")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.get("api/users?page=2");
		// then--> Validation
		String statusLine = res.getStatusLine();
		int statusCode = res.getStatusCode();
		String resBody = res.getBody().asString();
		System.out.println("Status Line: " + statusLine);
		System.out.println("Status Code: " + statusCode);
		System.out.println("Response Body: " + resBody);
		res.then().statusCode(200);
		// or
		// Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void tc6_updateUser() {
		String payload="{\"name\": \"Shailesh\",\"job\": \"Delivery Lead\"}";
		
		RestAssured.baseURI = "https://reqres.in/";
		Response res = RestAssured.given()
						.header("Content-Type", "application/json")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(payload)
						.put("/api/users/2");
		// then--> Validation
		String statusLine = res.getStatusLine();
		int statusCode = res.getStatusCode();
		String resBody = res.getBody().asString();
		System.out.println("Status Line: " + statusLine);
		System.out.println("Status Code: " + statusCode);
		System.out.println("Response Body: " + resBody);
		res.then().statusCode(200);
		// or
		// Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void tc7_deleteUser() {		
		RestAssured.baseURI = "https://reqres.in/";
		Response res = RestAssured.given()
						.header("Content-Type", "application/json")
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.delete("/api/users/2");
		// then--> Validation
		String statusLine = res.getStatusLine();
		int statusCode = res.getStatusCode();
		String resBody = res.getBody().asString();
		System.out.println("Status Line: " + statusLine);
		System.out.println("Status Code: " + statusCode);
		System.out.println("Response Body: " + resBody);
		res.then().statusCode(204);
		// or
		// Assert.assertEquals(statusCode, 204);
	}
}
