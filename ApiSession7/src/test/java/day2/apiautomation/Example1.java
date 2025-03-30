package day2.apiautomation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Example1 {

	@Test
	public void tc1_CreateUser() {
		String payload="{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		//given-->Request
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request=RestAssured.given()
									.header("Content-Type","application/json")
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON).body(payload);
		//when--->Action
		Response res=request.post("api/users");
		//then--> Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String resBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+resBody);
		res.then().statusCode(201);
				//or
		//Assert.assertEquals(statusCode, 201);
	}
	
	@Test
	public void tc2_CreateUser() {
		//String payload="{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		JSONObject obj=new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job", "leader");
		//given-->Request
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request=RestAssured.given()
									.header("Content-Type","application/json")
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON).body(obj.toJSONString());
		//when--->Action
		Response res=request.post("api/users");
		//then--> Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String resBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+resBody);
		res.then().statusCode(201);
				//or
		//Assert.assertEquals(statusCode, 201);
	}

	@Test
	public void tc3_CreateUser() {
		//String payload="{\"name\": \"morpheus\",\"job\": \"leader\"}";
				//or
//		JSONObject obj=new JSONObject();
//		obj.put("name", "morpheus");
//		obj.put("job", "leader");
				//or
		byte[] data=null;
		try {
			data = Files.readAllBytes(Paths.get(".\\src\\test\\resources\\testdata\\CreateUser.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String payload=new String(data);
		
		
		//given-->Request
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification request=RestAssured.given()
									.header("Content-Type","application/json")
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON).body(payload);
		//when--->Action
		Response res=request.post("api/users");
		//then--> Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String resBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+resBody);
		res.then().statusCode(201);
				//or
		//Assert.assertEquals(statusCode, 201);
	}

	@Test
	public void tc4_CreateUser() {
		String payload="{\"name\": \"morpheus\",\"job\": \"leader\"}";
		
		//given-->Request
		RestAssured.baseURI="https://reqres.in/";
		Response res=RestAssured.given()
									.header("Content-Type","application/json")
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON).body(payload).post("api/users");
		//then--> Validation
		String statusLine=res.getStatusLine();
		int statusCode=res.getStatusCode();
		String resBody=res.getBody().asString();
		System.out.println("Status Line: "+statusLine);
		System.out.println("Status Code: "+statusCode);
		System.out.println("Response Body: "+resBody);
		res.then().statusCode(201);
				//or
		//Assert.assertEquals(statusCode, 201);
	}
}
