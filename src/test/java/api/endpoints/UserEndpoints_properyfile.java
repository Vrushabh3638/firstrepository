package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndpoints_properyfile {
	
	//UserEndpoints.java
	//created this class to perform CRUD operations 
	//payload=request Body

	
		public static ResourceBundle geturls(){
			//Method created to call url's from property file 
			ResourceBundle routes = ResourceBundle.getBundle("routes");     //this is load all property file
			return routes;
		}

		public static Response  create_user(User payload){
		String posturl=	geturls().getString("post_url");//with passing the key we call the get url's in string data type 
			Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
			.when()
			 .post(posturl);//here we call the string variable 
			return response;
		}
		
		
		public static Response read_user(String username) {
               
			String geturl=geturls().getString("get_url");
			 
			Response response=given()
					.pathParam("username", username)
			
			.when()
	         .get(geturl);	
	         return response;	
		}
		
		public static Response update_user( String username,User payload) {
			
			String puturl=geturls().getString("put_url");
			 
			Response response=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", username)
					.body(payload)
					
					.when()
					 .put(puturl);
					 return response;  
		
		}
		
		public static Response delete_user(String username) {
			
		String deleteurl=	geturls().getString("delete_url");
			Response response =given()
			.pathParam("username", username)
			
			.when()
			  .delete(deleteurl);
			return response;
			
		}
		
		
		
		
	}



