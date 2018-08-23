package com.WorkFitComplete.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.WorkFitComplete.Utilities.ExcelUtils;

public class AssessmentPage {

	

	@FindBy(xpath = "//td[@class='wf-actionRow-cell']")
	private WebElement addProcessFamilybutton;

	@FindBy(xpath = "//h1[contains(text(),'Model Designer')]")
	private WebElement modelDesigner;

	@FindBy(xpath = "//div[@class='wf-treeRowMenu']")
	private WebElement menuButton;

	@FindBy(xpath = "//*[@id='aadTile']")
	private WebElement SelectAccount;

	@FindBy(xpath = "//*[@id='i0118']")
	private WebElement Password;
}
