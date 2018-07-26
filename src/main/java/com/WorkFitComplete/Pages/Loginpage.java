package com.WorkFitComplete.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.WorkFitCompelte.core.Testcapture;
import com.WorkFitCompelte.core.Testexception;
import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Utilities.TestConfig;
import com.cucumber.listener.Reporter;

	public class Loginpage {
		
		@FindBy(xpath ="//*[@id='otherTile']/div/div[2]")
		private WebElement UseAnotherAccount;
		
		@FindBy(xpath="//*[@id='i0116']")
		private WebElement SignIn;
		
		@FindBy(xpath="//input[@id='idSIButton9']")
		private WebElement YesButton;
		
		@FindBy(xpath="//*[@id='idSIButton9']")
		private WebElement NextButton;
		
		@FindBy(xpath="//*[@id='aadTile']")
		private WebElement SelectAccount;
		
		@FindBy(xpath="//*[@id='i0118']")
		private WebElement Password;
		
		@FindBy(xpath="//*[@id='idSIButton9']")
		private WebElement SignInButton;
		
		@FindBy(xpath="//*[@id='DeltaPlaceHolderPageTitleInTitleArea']")
		private WebElement AppTesting;
		
		
		public Loginpage()
		{
			PageFactory.initElements(Testfactory.driver, this);
		}

				
		public void clickLoginbutton(String userName, String passWord)
		{
			try{
				
				Testfactory.editTextBox(SignIn, userName);
				//Reporter.addStepLog("Enetr the Username");
				Testfactory.clickAction(NextButton);
				//Reporter.addStepLog("Click on the Next Button");
				Testfactory.clickAction(SelectAccount);
				//Reporter.addStepLog("Select the account");
				Testfactory.clickAction(YesButton);
				//Reporter.addStepLog("Click on Yes Button");
				Testfactory.editTextBox(Password, passWord);
				//Reporter.addStepLog("Enter the Password");
				Testfactory.clickAction(SignInButton);
				//Reporter.addStepLog("Click on SignIn Button");
				Testfactory.clickAction(YesButton);
				//Reporter.addStepLog("Click on Yes button");
				Testcapture.capturescreenshot(Testfactory.driver, "Login Functionality");
			}catch(Testexception e){
				
			}
			
		}
		public void IsAppTestingPageOpen(String pageName) throws Testexception
		{
			
			String text = AppTesting.getText();
			Assert.assertEquals(pageName, text);
			Reporter.addStepLog("Verify the use is able to login");
		}
	}

