package practice;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Test_Requests {
	
	@Test
	public void test_Get()
	{
		Response res=get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.getTime());
		int statusCode=res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.first_name[0]",equalToCompressingWhiteSpace("Michael"));
	}
		
	@SuppressWarnings("unchecked")
	@Test
	public void test_Post(){
		JSONObject req=new JSONObject();
		req.put("name", "Vicky Bhatia");
		req.put("organization", "QA infotech");
		System.out.println(req);
		given().body(req.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_Put(){
		JSONObject req=new JSONObject();
		req.put("name", "Vicky Bhatia");
		req.put("organization", "QA infotech");
		System.out.println(req);
		given().body(req.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_Patch(){
		JSONObject req=new JSONObject();
		req.put("name", "Vicky Bhatia");
		req.put("organization", "QA infotech");
		System.out.println(req);
		given().body(req.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
	@Test
	public void test_Delete(){
		when().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
	}
}
