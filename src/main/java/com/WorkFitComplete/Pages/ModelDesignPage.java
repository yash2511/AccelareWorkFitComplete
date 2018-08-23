package com.WorkFitComplete.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.WorkFitCompelte.core.Testexception;
import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Utilities.ExcelUtils;



public class ModelDesignPage {
	
	@FindBy(xpath = "//td[@colspan='3']")
	private WebElement addprocessFamily;
	
	@FindBy(xpath="//div[@ng-show][1]/div[2]/div[2]")
	private WebElement outsideClickAction;
	
	@FindBy(xpath="//button[@ng-click='hideGetStarted()']")
	private WebElement getStartedButton;
	
	@FindBy(xpath="//span[text()='Delete Processes']")
	private WebElement DeleteProcesses;
	
	@FindBy(xpath="//span[text()='Delete All']")
	private WebElement DeleteAllButton;
	
	public ModelDesignPage() {
		PageFactory.initElements(Testfactory.driver, this);
	}
	
	public void clickOnaddprocessfamily() throws InterruptedException
	{	
		try {
			if(getStartedButton.isDisplayed())
			{
				Testfactory.clickAction(getStartedButton);
				Testfactory.clickAction(addprocessFamily);
			}else
			{
			Testfactory.clickAction(DeleteProcesses);	
			Testfactory.clickAction(DeleteAllButton);
			Thread.sleep(2000);
			Testfactory.clickAction(getStartedButton);
			
			Testfactory.clickAction(addprocessFamily);
			}
		} catch (Testexception e) {
			
			e.printStackTrace();
		}
	}
	public void enterTheValue()
	{
		try{
		Testfactory.Actions(ExcelUtils.getSheetData(1, 0));
		Thread.sleep(1000);
		Testfactory.clickAction(outsideClickAction);
		Thread.sleep(1000);

		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void verify_added_process_family()
	{
		boolean b;
		b = Testfactory.driver.findElement(By.xpath("//span[@class and contains(text(),'" + ExcelUtils.getSheetData(1, 0) + "')]")).isDisplayed();
		Assert.assertTrue(b); 
	}
	
}