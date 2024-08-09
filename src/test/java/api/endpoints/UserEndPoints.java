package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java
//created this class to perform CRUD operations 
//payload=request Body

public class UserEndPoints { 

	public static Response  create_user(User payload){
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		 .post(Routes.post_url);
		return response;
	}
	
	public static Response read_user(String username) {
		
		 
		Response response=given()
				.pathParam("username", username)
		
		.when()
         .get(Routes.get_url);	
         return response;	
	}
	
	public static Response update_user( String username,User payload) {
		  
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				
				.when()
				 .put(Routes.put_url);
				 return response;  
	
	}
	
	public static Response delete_user(String username) {
		Response response =given()
		.pathParam("username", username)
		
		.when()
		  .delete(Routes.delete_url);
		return response;
		
	}
	
	
	
	
}
