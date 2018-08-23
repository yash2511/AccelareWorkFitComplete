package com.WorkFitComplete.Pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.WorkFitCompelte.core.Testexception;
import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Utilities.ExcelUtils;

public class CreateNewModelFunctionality {

	@FindBy(xpath = "//div[@class='dropdown inline-block']")
	private WebElement ModelDropdown;

	@FindBy(xpath = "//td[@class='wf-row-content wf-row-link']")
	private WebElement NewModel;

	@FindBy(xpath = "//*[@id='modelInfoPanel']/div/div/div[1]/div[3]/div/div/div[1]/div/div[1]/div[1]/input")
	private WebElement TitleText;

	@FindBy(xpath = "//*[@id='pplPick_0_TopSpan']")
	private WebElement OwnerText;

	@FindBy(xpath = "//div[@id='pplPick_0_TopSpan_AutoFillDiv']//following::li")
	private WebElement li;

	@FindBy(xpath = "//*[@id='modelInfoPanel']/div/div/div[1]/div[3]/div/div/div[3]/div/div[1]/div[1]/textarea")
	private WebElement Description;

	@FindBy(xpath = "//*[starts-with(@id,'dp')]")
	private WebElement date;

	@FindBy(xpath = "//*[@id='pplPick_1_TopSpan']")
	private WebElement user;

	@FindBy(xpath = "//input[@class='ms-TextField-field wf-validation-ctrl ng-pristine ng-untouched ng-valid ng-empty']")
	private WebElement link;

	@FindBy(xpath = "//*[@id='modelInfoPanel']/div/div/div[1]/div[2]/div/div[2]/button/span")
	private WebElement saveButton;

	@FindBy(xpath = "//*[contains(text(),'Get Started')]")
	private WebElement getStartedButton;

	@FindBy(xpath = "//td[@class='wf-row-content']")
	private List<WebElement> modelDropdownlist;

	public CreateNewModelFunctionality() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void ClickOnModel() {
		try {
			Testfactory.clickAction(ModelDropdown);
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}

	public void ClickOnNewModelLink() {
		try {
			Testfactory.clickAction(NewModel);
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}

	public void NewModelForm() throws InterruptedException, AWTException {
		try {

			Testfactory.editTextBox(TitleText, ExcelUtils.getSheetData(1, 0));
			Testfactory.Actions(OwnerText, "tes");
			Testfactory.driver.findElement(By.xpath("//div[text()='" + ExcelUtils.getSheetData(1, 1) + "']")).click();
			Testfactory.editTextBox(Description, ExcelUtils.getSheetData(1, 2));
			Testfactory.Actions(user, "tes");
			Testfactory.driver.findElement(By.xpath("//div[text()='" + ExcelUtils.getSheetData(1, 4) + "']")).click();
			Testfactory.editTextBox(link, ExcelUtils.getSheetData(1, 5));
			Testfactory.editTextBox(date, ExcelUtils.getSheetData(1, 3));
			Testfactory.clickAction(date);
			Testfactory.clickAction(saveButton);
			Thread.sleep(10000);
			Testfactory.driver.navigate().back();
			Testfactory.clickAction(ModelDropdown);
			// Testcapture.capturescreenshot(Testfactory.driver, "New Model
			// Functionality");
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}

	public void IsModelCreated() {
		boolean b = true;
		boolean getstarted = ExcelUtils.getSheetData(1, 0)
				.equals(Testfactory.modeldropdownlist(modelDropdownlist, ExcelUtils.getSheetData(1, 0)));
		Assert.assertTrue(getstarted);

	}
}
