package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangeProfile_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


/**
 * 
 * @author MADHANKUMAR
 * Date 05/08/2022
 * @description Update Profile using BaseClass
 */
public class TC3_UpdateSteps extends BaseClass {
	
	public static Response response ;
	
/**
 * @Description user Should add form Data for changing profile picture
 */
	@Given("User Should add Form Data for changing profile picture")
	public void user_should_add_form_data_for_changing_profile_picture() {
		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");

		Header h2 = new Header("Authorization", "Bearer " +TC1_LoginSteps.logtoken);

		Header h3 = new Header("Content-Type", " multipart/form-data");

		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);

		addheaders(headers);
		
		formData();
		
		
		

	}
	
	/**
	 * @Description User Should POST request for Change profile Picture End Point
	 */

	@When("User Should Send POST request for changeProfilepic endpoint")
	public void user_should_send_post_request_for_change_profilepic_endpoint() {
		
		response = requestType("POST", Endpoints.CHANGEPROFILEPIC);
		
		

	}
	
	
	/**
	 * @Description User should verify the message after changing picture 
	 * @param string
	 */

	@Then("User Should verify the changing profile picture response body message {string}")
	public void user_should_verify_the_changing_profile_picture_response_body_message(String string) {
		
		ChangeProfile_Output_pojo changeProfile_Output_pojo = response.as(ChangeProfile_Output_pojo.class);
		
		String message = changeProfile_Output_pojo.getMessage();
		
		Assert.assertEquals(message, "Profile updated Successfully");
		

	}

}
