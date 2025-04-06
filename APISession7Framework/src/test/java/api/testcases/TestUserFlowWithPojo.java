package api.testcases;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class TestUserFlowWithPojo {

	UserPayload getUserPayload;
	Faker faker;
	
	@BeforeClass
	public void setUp() {
		faker=new Faker();
		getUserPayload =new UserPayload();
		getUserPayload.setId(faker.idNumber().hashCode());
		getUserPayload.setUsername(faker.name().username());
		getUserPayload.setFirstName(faker.name().firstName());
		getUserPayload.setLastName(faker.name().lastName());
		getUserPayload.setEmail(faker.internet().safeEmailAddress());
		getUserPayload.setPassword(faker.internet().password(5, 10));
		getUserPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void testUserCreation() {
		Response res=UserEndPoints.createUser(getUserPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void testCreatedUser() {
		Response res=UserEndPoints.getUser(getUserPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=3)
	public void testUserUpdate() {
		//to update user details prepare data
		getUserPayload.setFirstName(faker.name().firstName());
		getUserPayload.setLastName(faker.name().lastName());
		getUserPayload.setEmail(faker.internet().safeEmailAddress());
		//update user details
		Response res=UserEndPoints.updateUser(getUserPayload.getUsername(), getUserPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		//validate user details are updated or not
		Response resAfterUpdate=UserEndPoints.getUser(getUserPayload.getUsername());
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
		//TODO: additional validation: validate with update username/firstname & LastName
		
	}
	@Test(priority=5)
	public void testUserDeletion() {
		Response res=UserEndPoints.deleteUser(getUserPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	//@Test(priority=4)
	public void testUserUpdate2() {
		//to update user details prepare data
		String fistName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String emailId=faker.internet().safeEmailAddress();
		getUserPayload.setFirstName(fistName);
		getUserPayload.setLastName(lastName);
		getUserPayload.setEmail(emailId);
		//update user details
		Response res=UserEndPoints.updateUser(getUserPayload.getUsername(), getUserPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		//validate user details are updated or not
		Response resAfterUpdate=UserEndPoints.getUser(getUserPayload.getUsername());
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
		String responseMsg=resAfterUpdate.asString();
		JSONObject obj=(JSONObject)JSONValue.parse(responseMsg);
		boolean res1=(boolean)obj.get("firstName").equals(fistName);
		boolean res2=(boolean)obj.get("lastName").equals(lastName);
		boolean res3=(boolean)obj.get("email").equals(emailId);
		Assert.assertTrue(res1,"First Name is not updated");
		Assert.assertTrue(res2,"Last Name is not updated");
		Assert.assertTrue(res3,"EmailId is not updated");
	}
}
