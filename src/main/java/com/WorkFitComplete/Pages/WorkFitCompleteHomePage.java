package com.WorkFitComplete.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.WorkFitCompelte.core.Testexception;
import com.WorkFitCompelte.core.Testfactory;
import com.WorkFitComplete.Utilities.ExcelUtils;

public class WorkFitCompleteHomePage {

	@FindBy(xpath = "//span[@class='ms-rteFontSize-4' and contains(text(),'WorkFit Complete')]")
	private WebElement WorkFitCompleteLink;

	@FindBy(xpath = "//*[@title='WorkFit Menu']")
	private WebElement WorkFitMenuButton;

	@FindBy(xpath = "//i[@class='ms-Icon ms-Icon--More']")
	private WebElement moreOptions;

	@FindBy(xpath = "//a[contains(text(),'Export')]")
	private WebElement exportlink;

	@FindBy(xpath = "//span[contains(text(),'Export')]")
	private WebElement exportButton;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement exportFieldCheckbox;

	@FindBy(xpath = "//span[@class='ng-binding' or @class='fancytree-title']")
	private List<WebElement> models;

	@FindBy(xpath = "//*[@class='ms-core-suiteLink-a']")
	private WebElement AppTesting;

	public WorkFitCompleteHomePage() {
		PageFactory.initElements(Testfactory.driver, this);
	}

	public void WorkFitCompleteLink() {

		try {
			Testfactory.clickAction(WorkFitCompleteLink);

		} catch (Testexception e) {

		}
	}

	public void clickOnMoreOptionLink() {
		try {

			Testfactory.clickAction(moreOptions);
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}

	public void exportFunctionality() {

		File path = new File("C:\\Users\\yashodeep.patil\\workspace\\WorkFitComplete\\ExportFile");
		try {
			File[] filename = path.listFiles();

			for (File fi : filename) {
				if (fi.toString().contains("Model")) {
					fi.delete();

					System.out.println("file is delted");
				}
			}
			{
				Testfactory.clickAction(exportlink);
				Thread.sleep(1000);
				Testfactory.clickAction(exportButton);
				Thread.sleep(10000);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				robot.keyPress(KeyEvent.VK_ENTER);

				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(20000);

			}

		} catch (Testexception e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void click_on_AppTesting_page() {
		try {
			Testfactory.clickAction(AppTesting);
		} catch (Testexception e) {

			e.printStackTrace();
		}
	}

	public void verify_export_Functionality() throws IOException {

		boolean b = true;
		b = Testfactory.read_element_file(models).equals(ExcelUtils.readdata("Model Export.xlsx"));

		Assert.assertTrue(b);

		System.out.println("Pass");

	}

	public void verifyDashBoard() throws Testexception {
		boolean workfitmenu = WorkFitMenuButton.isDisplayed();
		SoftAssert ass = new SoftAssert();
		ass.assertTrue(workfitmenu);

	}
}
