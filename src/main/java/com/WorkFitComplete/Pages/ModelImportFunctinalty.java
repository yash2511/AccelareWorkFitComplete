package com.WorkFitComplete.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WorkFitCompelte.core.Testcapture;
import com.WorkFitCompelte.core.Testexception;
import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Utilities.ExcelUtils;

public class ModelImportFunctinalty {

	@FindBy(xpath = "//*[@id='defaultPageContent']/div[2]/div[1]/div[2]/div[1]/div[2]/h1")
	private WebElement ModelDropdown;

	@FindBy(xpath = "//*[@id='defaultPageContent']/div[2]/div[1]/div[2]/div[1]/div[2]/div/table/tbody/tr[1]/td[2]")
	private WebElement SelectModel;

	@FindBy(xpath = "//div[@class='ms-CommandButton ng-scope']")
	private WebElement DesignButton;

	@FindBy(xpath = "//*[@id='importInput']")
	private WebElement ChooseFile;

	@FindBy(xpath = "//span[contains(text(),'Import')]")
	private WebElement ImportButton;

	@FindBy(xpath = "//div[contains(text(),'Import was successful')]")
	private WebElement ImportMessage;

	@FindBy(xpath = "//button[@ng-click = 'deleteModel()']")
	private WebElement Deletemodel;

	@FindBy(xpath = "//button[@class= 'ms-Button ms-Button--primary btn-ok']")
	private WebElement ConfirmDeleteAction;

	public ModelImportFunctinalty() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void modeldropdown() throws InterruptedException {
		try {
			Testfactory.clickAction(ModelDropdown);
			Testfactory.driver.findElement(By.xpath("//h3[text()='" + ExcelUtils.getSheetData(1, 0) + "']")).click();
			Thread.sleep(20000);
			
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}
	public void clickOnDesignButton()
	{
		try {
			Testfactory.clickAction(DesignButton);
		} catch (Testexception e) {
			
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	
	
	public void importModel() throws InterruptedException {
		try {
			if (Deletemodel.isDisplayed()) {
				Testfactory.clickAction(Deletemodel);
				Testfactory.clickAction(ConfirmDeleteAction);
				Testfactory.clickAction(ModelDropdown);
				Testfactory.driver.findElement(By.xpath("//h3[text()='" + ExcelUtils.getSheetData(1, 0) + "']"))
						.click();
				Thread.sleep(20000);
				Testfactory.clickAction(DesignButton);
				Testfactory.editTextBox(ChooseFile, "C:\\Users\\yashodeep.patil\\Downloads\\Model Export (11).xlsx");
				Testfactory.clickAction(ImportButton);
				Testcapture.capturescreenshot(Testfactory.driver, "ImportModelFunctionality");
			} else {
				Testfactory.editTextBox(ChooseFile, "C:\\Users\\yashodeep.patil\\Downloads\\Model Export (11).xlsx");
				Testfactory.clickAction(ImportButton);
				Testcapture.capturescreenshot(Testfactory.driver, "ImportModelFunctionality");
			}
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}

	public boolean validateImport() {
		try {
			return !ImportMessage.isDisplayed();
		} catch (StaleElementReferenceException elementHasDisappeared) {
			return true;
		}

	}

}
