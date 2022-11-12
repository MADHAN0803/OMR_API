package com.stepdefinition;

import org.testng.Assert;


import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.Login_Output_Pojo_1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;



/**
 *  @author SANTHOSH KUMAR
 * @Date 05/08/2022
 * @description LoginSteps with extends Base class
 * 
 *
 */

public class TC1_LoginSteps extends BaseClass {
	public static String logtoken;
	public static String address_id;
	public static Response response;
	
	/**
	 *@description add headers
	 */

	@Given("User Should add Header")
	public void user_should_add_header() {

		addHeader("accept", "application/json");

	}
	
    /**
     * @description Basic Authentication for login
     */

	@Given("User Should add basic Authentication for login")
	public void user_should_add_basic_authentication_for_login() {

		basicAuth("madhanragu555@gmail.com", "Madhan@123");

	}
	
	/**
	 * @description User send POST request to the End Point
	 */

	@When("User Should send POST request for login EndPoint")
	public void user_should_send_post_request_for_login_end_point() {

		response = requestType("POST", Endpoints.POSTMANBASICAUTHLOGIN);

	}
	
	/**
	 * @description Login verify response body and firstName Should be corrected save the log token
	 * @param Name
	 */

	@Then("User Should verify the login response body first name is {string} and  the logtoken Should be saved")
	public void user_should_verify_the_login_response_body_first_name_is_and_the_logtoken_should_be_saved(String Name) {

		Login_Output_Pojo_1 pojo_1 = response.as(Login_Output_Pojo_1.class);

		String first_name = pojo_1.getData().getFirst_name();
		System.out.println(first_name);
		Assert.assertEquals(first_name, Name, "Verify Succesfully");

		logtoken = pojo_1.getData().getLogtoken();

	}

}
