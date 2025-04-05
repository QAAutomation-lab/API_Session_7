package api.endpoints;

import api.payload.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(UserPayload payload) {
		Response res=RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when().post(BaseURLs.CREATE_USER_URL);
		return res;
	}
	
	public static Response getUser(String username) {
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.when().get(BaseURLs.GET_USER_URL);
		return res;
	}
	
	public static Response updateUser(String username, UserPayload payload) {
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when().put(BaseURLs.UPDATE_USER_URL);
		return res;
	}
	
	public static Response deleteUser(String username) {
		Response res=RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.when().delete(BaseURLs.DETELE_USER_URL);
		return res;
	}
}
