package test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;



public class PutPatchDelete {
	
	
	@Test
	public void put_test() {
	
		
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
		when().put("/users/2")
		.then().statusCode(200).log().all();
		
	}
	@Test
public void patch_test() {
	
		
		JSONObject request=new JSONObject();
		request.put("name","jaya");
		request.put("job","teacher");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		given().
		header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).
		when().patch("/api/users/2")
		.then().statusCode(200).log().all();
		
	}
	@Test
	public void delete_test() {
		
			
		/*
		 * JSONObject request=new JSONObject(); request.put("name","jaya");
		 * request.put("job","teacher"); System.out.println(request.toJSONString());
		 */
			
			baseURI="https://reqres.in";
			/*
			 * given(). header("Content-Type","application/json")
			 * .contentType(ContentType.JSON) .accept(ContentType.JSON)
			 * .body(request.toJSONString()).
			 */
			when()
			.delete("/api/users/2")
			.then().statusCode(204).log().all();
			
		}

}