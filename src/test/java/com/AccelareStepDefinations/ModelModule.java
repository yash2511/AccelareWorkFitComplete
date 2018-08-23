package com.AccelareStepDefinations;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Listeners.Report;
import com.WorkFitComplete.Pages.CreateNewModelFunctionality;
import com.WorkFitComplete.Pages.Loginpage;
import com.WorkFitComplete.Pages.ModelDesignPage;
import com.WorkFitComplete.Pages.ModelImportFunctinalty;
import com.WorkFitComplete.Pages.WorkFitCompleteHomePage;
import com.WorkFitComplete.Utilities.ExcelUtils;
import com.WorkFitComplete.Utilities.TestConfig;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ModelModule {
	Report reporter = new Report();

	@Before
	public void beforeScenario(Scenario scenario) {
		reporter.startReport();
		reporter.startTest(scenario.getName());
	}

	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("This will run after the Scenario");
		reporter.endTest(scenario.getName());
	}

	@Given("^Accelare url is launched$")
	public void accelare_url_is_launched() {
		try {
			Testfactory.launchapplication(TestConfig.getConfigDetails().get("browser"));
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^User Enters valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_Enters_valid_username_and_password(String username, String password) {
		try {
			Loginpage login = new Loginpage();
			login.clickLoginbutton(username, password);

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^Verify if App Testing Accelare is opened$")
	public void verify_if_App_Testing_Accelare_is_opened() {
		try {
			WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
			link.WorkFitCompleteLink();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));
		}
	}

	@Then("^Click on verify app testing page$")
	public void Click_on_verify_app_testing_page() {
		try {
			WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
			link.click_on_AppTesting_page();
			link.WorkFitCompleteLink();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}

	}

	@Given("^user navigated to new model form$")
	public void user_navigated_to_new_model_form() throws Throwable {
		try {
			CreateNewModelFunctionality model = new CreateNewModelFunctionality();
			model.ClickOnModel();
			model.ClickOnNewModelLink();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^User click on new model link$")
	public void user_click_on_new_model_link() {

		try {
			CreateNewModelFunctionality model = new CreateNewModelFunctionality();
			model.NewModelForm();

			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());

		}

		catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^User is able to see the model in dropdown model$")
	public void user_is_able_to_see_the_model_in_dropdown_model() throws Throwable {
		try {
			CreateNewModelFunctionality model = new CreateNewModelFunctionality();
			model.IsModelCreated();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}

	}

	@Given("^User navigate to the model import window$")
	public void user_navigate_to_the_model_import_window() throws Throwable {
		try {
			ModelImportFunctinalty model = new ModelImportFunctinalty();
			model.modeldropdown();
			
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^user click on design button$")
	public void user_click_on_design_button() throws Throwable {
		try {
			ModelImportFunctinalty model = new ModelImportFunctinalty();
			model.clickOnDesignButton();
			model.importModel();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^user is able to upload the model$")
	public void user_is_able_to_upload_the_model() throws Throwable {
		try {
			ModelImportFunctinalty model = new ModelImportFunctinalty();
			model.validateImport();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Given("^User navigate to the model export window$")
	public void user_navigate_to_the_model_export_window() throws Throwable {
		try {
			WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
			link.clickOnMoreOptionLink();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@When("^user click on Export button$")
	public void user_click_on_Export_button() throws Throwable {
		try {
			WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
			link.exportFunctionality();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^user is able to export the model$")
	public void user_is_able_to_export_the_model() throws Throwable {
		try {
			WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
			link.verify_export_Functionality();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}
	@Given("^user will add the process family$")
	public void user_will_add_the_process_family () throws Throwable {
		try {
			ModelImportFunctinalty model = new ModelImportFunctinalty();
			model.modeldropdown();
			model.clickOnDesignButton();
			
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}
	
	@When("^user click on add process family$")
	public void user_click_on_add_process_family() throws Throwable {
		try {
			ModelDesignPage designPage = new ModelDesignPage();
			designPage.clickOnaddprocessfamily();
			designPage.enterTheValue();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}

	@Then("^user is able to add process family$")
	public void user_is_able_to_add_process_family() throws Throwable {
		try {
			ModelDesignPage designPage = new ModelDesignPage();
			designPage.verify_added_process_family();
			reporter.stepPass(new Object() {
			}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			e.printStackTrace();

			reporter.stepFail(new Object() {
			}.getClass().getEnclosingMethod().getName());
			reporter.exceptionMessage(ExceptionUtils.getStackTrace(e));

		}
	}
	
	
	@Then("^Close the browser$")
	public void Close_the_browser() {

		Testfactory.driver.close();
	}
}
