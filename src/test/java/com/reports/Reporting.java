package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJVMReport(String jsonfile) {

		File file = new File("C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\APIAutomation\\target");

		Configuration configuration = new Configuration(file, "API VELSBUSINNESSS");

		configuration.addClassifications("BrowserName", "Chrome");
		configuration.addClassifications("Version", "103");
		configuration.addClassifications("OS", "WIN10");

		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonfile);

		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);

		builder.generateReports();

	}

}
