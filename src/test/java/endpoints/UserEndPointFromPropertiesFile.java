package endpoints;


import io.restassured.http.ContentType;

import io.restassured.response.Response;
import payload.User;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import org.testng.Assert;


public class UserEndPointFromPropertiesFile {
	//Create a method for getting the URLs from the properties file:
	
	
	public static ResourceBundle getUrlFromPropertiesFile() {
		//Use resource bundle, or/ BufferReader, Input Stream, FileReader
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	
	
//In this class we will perform methods: Create, Read, Update, Delete the user API
	public static Response createUser(User payload) {
		String post_url = getUrlFromPropertiesFile().getString("post_url");
		
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);
		return response;
	}

	public static Response getUser(String userName) {
		
		String get_url = getUrlFromPropertiesFile().getString("get_url");

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).when().get(get_url);
		Assert.assertEquals(response.statusCode(), 200);
		return response;
	}

	public static Response updateUser(String userName, User payload) {
		String update_url = getUrlFromPropertiesFile().getString("get_url");

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(payload).when().put(update_url);
		Assert.assertEquals(response.statusCode(), 200);
		return response;
		
	}

	public static Response deleteUser(String userName) {
		String delete_url = getUrlFromPropertiesFile().getString("delete_url");

		Response response = given().pathParam("username", userName).when().delete(delete_url);
		return response;

	}

}
