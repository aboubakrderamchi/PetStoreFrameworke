package endpoints;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

public class UserEndPoint {
//In this class we will perform methods: Create, Read, Update, Delete the user API
	public static Response createUser(User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);
		return response;
	}

	public static Response getUser(String userName) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).when().get(Routes.get_url);
		Assert.assertEquals(response.statusCode(), 200);
		return response;
	}

	public static Response updateUser(String userName, User payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(Routes.update_url);
		Assert.assertEquals(response.statusCode(), 200);
		return response;
		
	}

	public static Response deleteUser(String userName) {

		Response response = given().pathParam("username", userName).when().delete(Routes.delete_url);
		return response;

	}

}
