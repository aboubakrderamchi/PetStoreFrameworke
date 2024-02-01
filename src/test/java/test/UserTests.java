package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import endpoints.UserEndPoint;
import io.restassured.response.Response;
import payload.User;

public class UserTests {
	Faker faker;
	User userPayload;
	
	
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test (priority =1)
	public void testPostUser() {
		Response response = UserEndPoint.createUser(userPayload);
		response.then().log().body(); 
		//Validating the status code:
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test (priority =2)
	public void getUserByUsername() {
		
		Response response = UserEndPoint.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test (priority=3)
	public void updateUser() {
		//Update payload data:
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response response = UserEndPoint.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		//Get the update
		Response responseUpdate = UserEndPoint.getUser(this.userPayload.getUsername());
		responseUpdate.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	
	@Test(priority= 4)
	public void deleteUser() {
		
		Response response = UserEndPoint.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
	}

}
