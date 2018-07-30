package com.WorkFitCompelte.core;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.WorkFitComplete.Utilities.TestConfig;

public abstract class Testfactory {

public static WebDriver driver;

	
	public static void launchapplication(String browsername)
	{
		String path = System.getProperty("user.dir");
		
		switch(browsername)
		{
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\resources\\Drivers\\chromedriver.exe");
				
				Testfactory.driver = new ChromeDriver();
				
				break;
				
			case "firefox":
				FirefoxProfile  options = new FirefoxProfile();
				options.setPreference("browser.download.folderList", 2);
				options.setPreference("browser.download.dir", "C:\\Users\\yashodeep.patil\\workspace\\WorkFitComplete\\ExportFile");
				options.setPreference("browser.download.useDownloadDir", true);
				options.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/json");
				
				
				driver = new FirefoxDriver(options);
				
				break;
				
			default:
					System.out.println("Browser name is incorrect");
		}
		
		
		driver.get(TestConfig.getConfigDetails().get("url"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public static void editTextBox(WebElement textBox, String value) throws Testexception, Testexception
	{
		if(!textBox.isEnabled())
		{
			throw new Testexception(textBox.getText()+"editbox is disabled");
		}
		try{
		textBox.clear();
		textBox.sendKeys(value);
		}
		catch(Exception e)
		{
			Testcapture.capturescreenshot(Testfactory.driver, textBox.getText());
		}
	}
	
	public static void clickAction(WebElement element) throws Testexception
	{
		if(!element.isEnabled()){
			throw new Testexception(element.getText()+"click element is disabled");
		}
		try{
		element.click();
	}catch (Exception e)
		{
			Testcapture.capturescreenshot(Testfactory.driver, element.getText());
		}
	}
	
	public void highlightaction(WebElement element)
	{
		try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		}catch (Exception e)
		{
			Testcapture.capturescreenshot(Testfactory.driver, element.getText());
		}
	}
	
		
	public static void dropdownaction(WebElement dropDownList, String leave)
	{
		try{
			
			Select LeaveType = new Select(dropDownList);
	List<WebElement> allElements = LeaveType.getOptions();

    for (int i=0; i<allElements.size();i++) 
    {
    	String drop_down_values=allElements.get(i).getText();
    
    	if(drop_down_values.equals(leave))
    	 {
	        	System.out.println("Trying to select: "+leave);
	        	LeaveType.selectByVisibleText(leave);
	        
    	 }
     }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void selectCheckBox(List<WebElement> radio, String value)
	{
try{
		int iSize = radio.size();
 
	for(int i=0; i < iSize ; i++ )
		{
 
		String sValue = radio.get(i).getText();
 
		if (sValue.equalsIgnoreCase(value)){
 
		 radio.get(i).click();
 
		 break;
 
		}
		}
		//radio.click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	public static void wait(WebElement element)
	{
		try{
		WebDriverWait wait = new WebDriverWait(driver, 100);
	
		element= wait.until(ExpectedConditions.elementToBeClickable(element));
	}catch (Exception e)
		{
		e.printStackTrace();
		}
		}
	
	public static void MouseHover(WebElement element)
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(element).build().perform();
		
	}
	public static String gettext(WebElement string)
	{
		return string.getText();
	}
	public static void Actions(WebElement element) throws AWTException
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().sendKeys(Keys.DOWN).build().perform();
				
	}
	public static void Actions(WebElement element,String str) throws AWTException
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).click().sendKeys(str).build().perform();
				
	}
	public boolean isFileDownloaded(String downloadPath, String fileName) 
	{
		boolean flag = false;
	    File dir = new File(TestConfig.getConfigDetails().get(downloadPath));
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}

	public static List<String> read_element_file(List<WebElement> element)
    {
    	List<String> li = new ArrayList<>();
        for(WebElement el : element)
        {
        	String str = el.getText();
        	if(str.matches("^[0-9].*$"))
        	{
        	String newString = str.replaceAll("[-+]?([0-9]*\\.[0-9]+)","");
        	String space = newString.replaceAll("\\s+","");
        	li.add(space);
        	
        	}else
        	{
        		li.add(str);
        	
        	}        	
        }
        li.remove(0);
        System.out.println(li);
        return li;
    }     
	
	public static List<String> modeldropdownlist(List<WebElement> element)
    {
    	List<String> li = new ArrayList<>();
        for(WebElement el : element)
        {
        	String str = el.getText();
        	if(str.matches("^[0-9].*$"))
        	{
        	String newString = str.replaceAll("[-+]?([0-9]*\\.[0-9]+)","");
        	String space = newString.replaceAll("\\s+","");
        	li.add(space);
        	
        	}else
        	{
        		li.add(str);
        	
        	}        	
        }
        li.remove(0);
        System.out.println(li);
        return li;
    }     
	
	public static String modeldropdownlist(List<WebElement> element, String modelName)
    {
    	List<String> li = new ArrayList<>();
        for(WebElement el : element)
        {
        	String str = el.getText();
        	if(str.equals(modelName))
        	{
        	return str;
        	
        	}	
        }
		return modelName;
    }     
  }

	
 
    


