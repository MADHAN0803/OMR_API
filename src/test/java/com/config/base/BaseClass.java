package com.base;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * 
 * @author MADHANKUMAR
 * @Date 05/08/2022
 * @Description use BaseClass for using all methods for reusable 
 */
public class BaseClass {

	public RequestSpecification reqSpec;

	public static Response response;
	
	/**
	 * @Description addHeader method
	 * @param key
	 * @param value
	 */

	public void addHeader(String key, String value) {

		reqSpec = RestAssured.given().header(key, value);

	}
	
	/**
	 * @Description addHeders method
	 * @param headers
	 */

	public void addheaders(Headers headers) {

		reqSpec = RestAssured.given().headers(headers);

	}
	
	/**
	 * @Description form Data method
	 */
	
	public void formData() {

		reqSpec.multiPart("profile_picture",
	new File("C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\APIAutomation\\IMAGES"));

	}
	/**
	 * @Description addBody method
	 * @param body
	 */

	public void addBody(Object body) {

		reqSpec = reqSpec.body(body);

	}
    /**
     * @Description create method for BasicAuth
     * @param UserName
     * @param Password
     */
	public void basicAuth(String UserName, String Password) {

		reqSpec = reqSpec.auth().preemptive().basic(UserName, Password);

	}
	/**
	 * @Description create method for queryParam
	 * @param key
	 * @param value
	 */

	public void queryParam(String key, String value) {

		reqSpec = reqSpec.queryParam(key, value);

	}
	/**
	 * @description create method for PathParam
	 * @param key
	 * @param Value
	 */

	public void pathParam(String key, String Value) {

		reqSpec = reqSpec.pathParam(key, Value);

	}
	
	/**
	 * @Description create method for addBody1
	 * @param body
	 */

	public void addBody1(String body) {

		reqSpec = reqSpec.body(body);

	}
	
	/**
	 * @Description Create method for requestType
	 * @param type
	 * @param endpoint
	 * @return
	 */

	public Response requestType(String type, String endpoint) {

		switch (type) {

		case "GET":
			response = reqSpec.log().all().get(endpoint);

			break;

		case "POST":

			response = reqSpec.log().all().post(endpoint);

			break;

		case "PUT":

			response = reqSpec.log().all().put(endpoint);

			break;
		case "DELETE":

			response = reqSpec.log().all().delete(endpoint);

			break;

		default:
			break;
		}
		return response;

	}

	/**
	 * @Description Create method for responseCode 
	 * @param response
	 * @return
	 */
	public int getResponseCode(Response response) {

		int statusCode = response.getStatusCode();
		return statusCode;

	}
/**
 * @Description create method for pretty Body String 
 * @param response
 * @return
 */
	public String getResBodyAsString(Response response) {

		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}

}
