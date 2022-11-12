package com.stepdefinition;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddAddress_Input_Pojo;
import com.pojo.AddAddress_Output_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_Output_pojo;
import com.pojo.GetAddress_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * 
 * @author  MADHANKUMAR
 * @Date 05/08/2022
 * @description Address Steps in API Automation and also extends Base Class
 *
 */
public class TC2_AddressSteps extends BaseClass {

	public static Response response;

	public static String address_id1;
	
	/**
	 * 
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 * @Description User add request body for adding address
	 */

	@Given("User Should add request body for Adding Address using {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_add_request_body_for_adding_address_using_and(String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		int state1 = Integer.parseInt(state);
		int city1 = Integer.parseInt(city);
		int country1 = Integer.parseInt(country);

		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo(first_name, last_name, mobile,
				apartment, state1, city1, country1, zipcode, address, address_type);

		addBody(addAddress_Input_Pojo);

	}
	
	/**
	 * @description User Should send POST request for Address end Point
	 */

	@When("User Should send POST request for AddAddress endpoint")
	public void user_should_send_post_request_for_add_address_endpoint() {

		response = requestType("POST", Endpoints.ADDADDRESS);

	}
	
	/**
	 * @description User should verify add Address the response body saved the address id
	 * @param string
	 */

	@Then("user Should verify the AddAddress response body message {string} and the address_id should be saved")
	public void user_should_verify_the_add_address_response_body_message_and_the_address_id_should_be_saved(
			String string) {

		AddAddress_Output_Pojo address_Output_Pojo = response.as(AddAddress_Output_Pojo.class);

		String message = address_Output_Pojo.getMessage();
		Assert.assertEquals(message, string);

		int address_id = address_Output_Pojo.getAddress_id();

		address_id1 = String.valueOf(address_id);

	}
	
	/**
	 * @Description User should pass pay
	 * @param first_name
	 * @param last_name
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */

	@Given("User Should pass payload to UpdateUserAddress {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_pass_payload_to_update_user_address_and(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		int state1 = Integer.parseInt(state);

		int city1 = Integer.parseInt(city);

		int country1 = Integer.parseInt(country);

		UpdateAddress_Input_Pojo address_Input_Pojo = new UpdateAddress_Input_Pojo(address_id1, first_name, last_name,
				mobile, apartment, state1, city1, country1, zipcode, address, address_type);

		addBody(address_Input_Pojo);

	}
	
	/**
	 * Description user send put request for update address
	 */

	@When("User  Should send PUT request for UpdateUserAddress endpoint")
	public void user_should_send_put_request_for_update_user_address_endpoint() {

		response = requestType("PUT", Endpoints.UPDATEADDRESS);

	}
	
	/**
	 * Description Verify update address response body message
	 * @param string
	 */

	@Then("User Should Verify the UpdateUserAddress response body message  {string}")
	public void user_should_verify_the_update_user_address_response_body_message(String string) {

		UpdateAddress_Output_Pojo output_Pojo = response.as(UpdateAddress_Output_Pojo.class);

		String message = output_Pojo.getMessage();

		Assert.assertEquals(message, string);

		System.out.println(message);

	}
	
	/**
	 * Description user passes pay load to Delete Address
	 */

	@Given("User passess payload to DeleteAddress")
	public void user_passess_payload_to_delete_address() {

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id1);

		addBody(deleteAddress_Input_Pojo);

	}
	/**
	 * Description User send Delete request for delete Address End point
	 */

	@When("User send DELETE request for deleteAddress endpoint")
	public void user_send_delete_request_for_delete_address_endpoint() {

		response = requestType("DELETE", Endpoints.DELETEADDRESS);

	}
	/**
	 * User verify delete Address Response body message
	 * @param string
	 */

	@Then("User Should verify the deleteAddress response body message  {string}")
	public void user_should_verify_the_delete_address_response_body_message(String string) {

		DeleteAddress_Output_pojo deleteAddress_Output_pojo = response.as(DeleteAddress_Output_pojo.class);

		String message = deleteAddress_Output_pojo.getMessage();

		Assert.assertEquals(message, string);

	}
	
	/**
	 * Description send GET request for get address End point
	 */

	@Given("user send GET request for getAddress endpoint")
	public void user_send_get_request_for_get_address_endpoint() {

		response = requestType("GET", Endpoints.GETADDRESS);

	}
	
	/**
	 * Description User verify get address response body message
	 * @param string
	 */

	@Then("User Should verify the getAddress response body message {string}")
	public void user_should_verify_the_get_address_response_body_message(String string) {

		GetAddress_Output_Pojo address_Output_Pojo = response.as(GetAddress_Output_Pojo.class);

		String message = address_Output_Pojo.getMessage();

		Assert.assertEquals(message, string);

		System.out.println(message);

	}

}
