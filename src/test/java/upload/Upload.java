package upload;
import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Upload {
	
	@Test
	public void uploadFile() {
		try {
			File f = new File("C:\\Users\\gopiv\\Desktop\\Test.txt");
			if(f.exists()) {
				Response res= RestAssured
						.given()
						.multiPart("file", f, "multipart/form-data")
						.post("https://the-internet.herokuapp.com/upload")
						.thenReturn();
				System.out.println(res.asPrettyString());
				System.out.println("Content Type: "+ res.getContentType());
			}
		}catch(Exception oExp) {
			oExp.printStackTrace();
		}
	}
	
	

}


/*

 Software testing professional with overall experience of 10+ years in all Software Testing Life Cycle (STLC), proficient in Web based applications testing, strong experience in Automation testing and Good experience in Performance testing 
 Having 5+ years of Strong Experience in Automating Web Applications testing using Selenium WebDriver with TestNG framework, Cucumber framework (BDD) and Page Object Model (POM) 
 Strong experience in REST API Automation testing using Rest Assured Java API and TestNG framework
 Good experience in performance testing of web application using JMeter tool and concepts like Controllers, Listeners, Timers, Processor, correlation, Assertions and Thread group
 Good experience in Core Java, python, Object Oriented Programming (OOPs) concepts 
 Experience in the development of Data driven, Keyword driven and Hybrid Automation frameworks in Selenium 
 Having 2 Years of onshore working experience at client location (London, UK)
 Having Good Knowledge of Maven, GIT and Jenkins Tools used for Continuous Integration testing
 Good knowledge of Selenium grid, log4j for logging and database testing using JDBC API
 Experience in Cross browser testing, Parallel Test execution, Extent Reporting using Selenium WebDriver and TestNG
 Have experience and good understanding of latest Selenium 4 Alpha versions and upcoming Selenium 4 features
 Working experience in Microsoft Azure Cloud Service
 Strong Experience in Mobile Apps Testing and well versed with Native apps, Web apps, Hybrid apps Testing on Mobile and Tablet devices.
 Having good understanding of mobile automation testing with Appium
 Excellent knowledge of SDLC, STLC and defect life cycle
 Hands on experience in REST API testing using Postman tool 
 Experience in Cross Browser Testing using BrowserStack cloud-based platform
 Experience in Waterfall and Agile development delivery model and possess sound knowledge in Test Management tools like HP ALM/QC and JIRA
 Strong experience in developing all test documentation which includes Test plan, Test closure report, Test strategy, Test Scenario, Test Case, Defect Report, and Test Metrics
 Professional expertise in Smoke Testing, backed end Testing, Black-Box Testing, User Acceptance Testing (UAT), Functional Testing, Positive/ Negative Testing, System Testing, Regression Testing, GUI Software Testing, Ad-hoc Testing, Cross Browser/ Cross Platform Testing, UI Validation, Webservices, Boundary Value Testing.
 Experience in Test Management activities starting from Study till warranty
*/