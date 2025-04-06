package api.testcases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerClassTest {

	@Test
	public void testFaker() {
		Faker faker=new Faker();
		
		System.out.println("Random ID: "+faker.idNumber().hashCode());
		System.out.println("Random username: "+faker.name().username());
		System.out.println("Random firstName: "+faker.name().firstName());
		System.out.println("Random lastName: "+faker.name().lastName());
		System.out.println("Random emailID: "+faker.internet().safeEmailAddress());
		System.out.println("Random password: "+faker.internet().password(5, 10));
		System.out.println("Random phonenumber: "+faker.phoneNumber().cellPhone());
	}

}
