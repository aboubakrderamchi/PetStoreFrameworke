package endpoints;


public class Routes {
//In this class, we have to mentionen only the URLs
	//Swagger url: https://petstore.swagger.io
	//Create user (post): https://petstore.swagger.io/v2/user
	//Get user (get): https://petstore.swagger.io/v2/user/{username}
	//Update user (put): https://petstore.swagger.io/v2/user/{username}
	//Delete user (delete): https://petstore.swagger.io/v2/user/{username}
	
	//User module.
public static String baseUrl = "https://petstore.swagger.io/v2";
public static String get_url = baseUrl+"/user/{username}";
public static String post_url = baseUrl+"/user" ;
public static String update_url = baseUrl+"/user/{username}";
public static String delete_url = baseUrl+"/user/{username}";
}
