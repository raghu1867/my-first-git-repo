package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
//import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPostExample {
	
	/*
	 * @Test public void test_gettest() { baseURI="https://reqres.in/api";
	 * given().get("/users?page=2") .then().statusCode(200).
	 * body("data[4].first_name",equalTo("George"))
	 * .body("data.first_name",hasItems("George","Tobias"));
	 * 
	 */
		
	@Test
	public void get_test() {
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).
		body("data[4].first_name",equalTo("George")).
		body("data.first_name",hasItems("George","Tobias"));
	
	
	
	}
	@Test
	public void post_test() {
		//Map<String,Object> mp=new HashMap<String,Object>();
		/*
		 * mp.put("name","jaya"); mp.put("job","teacher" ); System.out.println(mp);
		 */
		
		
		JSONObject request=new JSONObject();
		request.put("name","jaya");
		request.put("job","teacher");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given().
		header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).
		when().post("/users")
		.then().statusCode(201).log().all();
		
	}

}
 