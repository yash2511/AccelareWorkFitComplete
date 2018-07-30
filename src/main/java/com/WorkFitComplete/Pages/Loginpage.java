package com.WorkFitComplete.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.WorkFitCompelte.core.Testcapture;
import com.WorkFitCompelte.core.Testexception;
import com.WorkFitCompelte.core.Testfactory;

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
				Testfactory.clickAction(NextButton);
				Testfactory.clickAction(SelectAccount);
				Testfactory.clickAction(YesButton);
				Testfactory.editTextBox(Password, passWord);
				Testfactory.clickAction(SignInButton);
				Testfactory.clickAction(YesButton);
				Testcapture.capturescreenshot(Testfactory.driver, "Login Functionality");
			}catch(Testexception e){
				e.printStackTrace();
			}
			
		}
		public void IsAppTestingPageOpen(String pageName)
		{
			
			String text = AppTesting.getText();
			try{
			Assert.assertEquals(pageName, text);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}

