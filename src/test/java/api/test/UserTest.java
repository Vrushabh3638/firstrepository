package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
/*String username;
String firstname;
String lastname;
String email;
String password;
String phone;
int userstatus=0;
int id*/
import io.restassured.response.Response;

public class UserTest {
Faker faker ;
User userpayload; 
Logger logger;
@BeforeClass 
public void setup() {
	faker = new Faker();
	userpayload=new User();
	
	
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstname(faker.name().firstName());
	userpayload.setLastname(faker.name().lastName());
	userpayload.setEmail(faker.internet().emailAddress());
	userpayload.setPassword(faker.internet().password(5,10));
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	
	logger= LogManager.getLogger(this.getClass());
	
	
}
@Test(priority=1)
public void testpostuser() { 
	
	logger.info("interred in 1st test");
	Response response=UserEndPoints.create_user(userpayload);
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("completed");

	
}

@Test(priority=2)
public void testgetuser() {
	logger.info("reading");

	Response response=UserEndPoints.read_user(this.userpayload.getUsername());
	response.then().log().all();
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	 
} 
@Test(priority=3)
public void testupdateuser() {
	logger.info("updating ");

	userpayload.setFirstname(faker.name().firstName());
	userpayload.setLastname(faker.name().lastName());
	Response response=UserEndPoints.update_user(this.userpayload.getUsername(),userpayload);
	
	response.then().log().all();
	
	Assert.assertEquals(response.statusCode(), 200);
	
	
}
@Test(priority=4)
public void testdeleteuser() {
	logger.info("Deleted");

	Response response=UserEndPoints.delete_user(this.userpayload.getUsername());
	response.then().log().all();
	
	Assert.assertEquals(response.statusCode(), 200);
	
	
}

}
