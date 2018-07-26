
package com.WorkFitComplete.Testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.WorkFitCompelte.core.Testcapture;
import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Listeners.Report;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags={"@smoke"},
		features =("src/test/resources/Features")
		,glue={"com.AccelareStepDefinations"}
)



public class TestRunner {

	 @AfterClass
	    public static void setup() {
		   // Reporter.setSystemInfo("user", System.getProperty("user.name"));
	       // Reporter.loadXMLConfig(new File("src/test/resources/ExtentReport-config.xml"));
	       
//	        Reporter.setSystemInfo("os", "Windows");
//	        Reporter.setTestRunnerOutput("Sample test runner output message");
     
	 }	
}
