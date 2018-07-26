package com.AccelareStepDefinations;

import java.awt.AWTException;

import com.WorkFitCompelte.core.Testexception;
import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Listeners.Report;
import com.WorkFitComplete.Pages.CreateNewModelFunctionality;
import com.WorkFitComplete.Pages.Loginpage;
import com.WorkFitComplete.Pages.ModelImportFunctinalty;
import com.WorkFitComplete.Pages.WorkFitCompleteHomePage;
import com.WorkFitComplete.Utilities.TestConfig;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ModelModule {
	Report reporter=new Report();	
	
	@Before
	public void beforeScenario(Scenario scenario) {
		reporter.startReport();
		reporter.startTest(scenario.getName());
	}
	
	@After
    public void afterScenario(Scenario scenario){
        System.out.println("This will run after the Scenario");
        reporter.endTest(scenario.getName());
      //  Testfactory.driver.close();
		//Testfactory.driver.quit();
	}
	
	@Given("^Accelare url is launched$")
	public void accelare_url_is_launched() {
	    try{
		Testfactory.launchapplication(TestConfig.getConfigDetails().get("browser"));
	    }catch(Exception e)
	    {
	    	
	    }
	}

	@When("^User Enters valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_Enters_valid_username_and_password(String username, String password) {
		try{
			Loginpage login= new Loginpage();
			login.clickLoginbutton(username, password);
			reporter.stepPass(new Object(){}.getClass().getEnclosingMethod().getName());
		} catch (Exception e) {
			
		} catch (Error e) {
			reporter.stepFail(new Object(){}.getClass().getEnclosingMethod().getName());
		}			

		
	}

	@Then("^Verify if \"([^\"]*)\" Accelare is opened$")
	public void then_Verify_if_Accelare_is_opened(String pagename) {
	
		try {
			Loginpage login= new Loginpage();
			login.IsAppTestingPageOpen(pagename);
		} catch (Testexception e) {
			
			e.printStackTrace();
		}
	}
	
	@Then("^Verify if App Testing Accelare is opened$")
	public void verify_if_App_Testing_Accelare_is_opened() throws Throwable {
		WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
		link.WorkFitCompleteLink();
		
	}
	
	@Then("^Click on verify app testing page$")
	public void Click_on_verify_app_testing_page() throws Throwable {
		WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
		link.click_on_AppTesting_page();
		link.WorkFitCompleteLink();
		
	}

	@Given("^user navigated to new model form$")
	public void user_navigated_to_new_model_form() throws Throwable {
		CreateNewModelFunctionality model = new CreateNewModelFunctionality();
		model.ClickOnModel();
		model.ClickOnNewModelLink();
		
	}

	@When("^User click on new model link$")
	public void user_click_on_new_model_link() throws Throwable {
	    
		try {
			CreateNewModelFunctionality model = new CreateNewModelFunctionality();
			model.NewModelForm();
			
			
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
	}
		
	@Then("^User is able to see the model in dropdown model$")
	public void user_is_able_to_see_the_model_in_dropdown_model() throws Throwable {
		CreateNewModelFunctionality model = new CreateNewModelFunctionality();
		model.IsModelCreated();
		
	}

	@Given("^User navigate to the model import window$")
	public void user_navigate_to_the_model_import_window() throws Throwable {
		ModelImportFunctinalty model = new ModelImportFunctinalty();
		model.modeldropdown();
	}

	@When("^user click on design button$")
	public void user_click_on_design_button() throws Throwable {
		ModelImportFunctinalty model = new ModelImportFunctinalty();
		model.importModel();
	}

	@Then("^user is able to upload the model$")
	public void user_is_able_to_upload_the_model() throws Throwable {
		ModelImportFunctinalty model = new ModelImportFunctinalty();
		model.validateImport();

	}
	
	@Given("^User navigate to the model export window$")
	public void user_navigate_to_the_model_export_window() throws Throwable {
		WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
		link.clickOnMoreOptionLink();
	}

	@When("^user click on Export button$")
	public void user_click_on_Export_button() throws Throwable {
		WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
		link.exportFunctionality();
	}

	@Then("^user is able to export the model$")
	public void user_is_able_to_export_the_model() throws Throwable {
		WorkFitCompleteHomePage link = new WorkFitCompleteHomePage();
		link.verify_export_Functionality();

	}
}
