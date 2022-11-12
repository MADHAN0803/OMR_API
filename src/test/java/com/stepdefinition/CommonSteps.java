package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class CommonSteps extends BaseClass {

	/**
	 * @author  MADHANKUMAR
	 * @Date 05/08/2022
	 * @description Add Headers
	 */
	
	
	@Given("User Should add Headers")
	public void user_should_add_headers() {

		// 1. Headers

		List<Header> h = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");

		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginSteps.logtoken);

		Header h3 = new Header("Content-Type", " application/json");

		h.add(h1);
		h.add(h2);
		h.add(h3);

		Headers headers = new Headers(h);

		addheaders(headers);

	}
	
	/**
	 * @description verify status code
	 * @param int1
	 * Description Verify the status code
	 */

	@Then("User Should verify the status code {int}")
	public void user_should_verify_the_status_code(Integer int1) {

		int responseCode = getResponseCode(response);
		System.out.println(responseCode);

		Assert.assertEquals(responseCode, 200);

	}

}
