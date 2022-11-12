package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;



/**
 * 
 * @author MADHANKUMAR
 *@Date 05/08/2022
 *@Description Run all methods and classes in test runner package also generating the report 
 */
@RunWith(Cucumber.class)

@CucumberOptions(snippets = SnippetType.CAMELCASE,
dryRun = true, 
plugin = { "pretty",
		"json:target/API.json" },
monochrome = true, 
features = "src\\test\\resources",
glue = { "com.stepdefinition" })

public class TestRunner {

	@AfterClass

	public static void afterClass() {

		Reporting.generateJVMReport("C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\APIAutomation\\target\\API.json");

	}

}
