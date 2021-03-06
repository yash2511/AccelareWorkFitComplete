package com.WorkFitComplete.Listeners;

import java.io.File;

import com.WorkFitComplete.Utilities.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {

	ExtentReports report;
	ExtentTest logger;
	Exception exe;

	public void startReport() {
		report = new ExtentReports("D:\\AccelareWorkFitComplete\\ExtentsReports\\Automation.html", false);

		report.loadConfig(new File(
				"C:\\Users\\yashodeep.patil\\workspace\\WorkFitComplete\\src\\test\\resources\\ExtentReport-config.xml"));

	}

	public void startTest(String testName) {

		logger = report.startTest(testName);
	}

	public void stepPass(String stepName) {

		logger.log(LogStatus.PASS, stepName);
	}

	public void stepFail(String stepName) {

		logger.log(LogStatus.FAIL, stepName);

	}

	public void exceptionMessage(String exceptionMessage) {

		logger.log(LogStatus.FAIL, exceptionMessage);

	}

	public void attachScreenshot(String stepName, String screeShotPath) {

		logger.log(LogStatus.FAIL, stepName, screeShotPath);
	}

	public void stepSkip(String stepName) {

		logger.log(LogStatus.SKIP, stepName);

	}

	public void endTest(String stepName) {

		report.endTest(logger);
		report.flush();
		report.close();

	}

}