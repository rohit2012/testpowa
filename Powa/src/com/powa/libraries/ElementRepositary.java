package com.powa.libraries;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Utils;

import com.powa.baseclasses.BaseClass;

public class ElementRepositary extends BaseClass{
	static ITestResult result;
	public static SoftAssert softAssert = new SoftAssert();
	
	public static WebElement getElement(String elementName) throws Exception
	{
		WebElement elementValue = null;
		String arg[] = elementName.split("_");
		int len = arg.length;
		String locatorType = arg[len-1];
		if(locatorType.equalsIgnoreCase("className"))
		{
			elementValue = getDriver().findElement(By.className(FileOperations.getValueFromElement(elementName)));
		}else if(locatorType.equalsIgnoreCase("css"))
		{
			elementValue = getDriver().findElement(By.cssSelector(FileOperations.getValueFromElement(elementName)));
		}else if(locatorType.equalsIgnoreCase("id"))
		{
			elementValue = getDriver().findElement(By.id(FileOperations.getValueFromElement(elementName)));
		}else if(locatorType.equalsIgnoreCase("linkText"))
		{
			elementValue = getDriver().findElement(By.linkText(FileOperations.getValueFromElement(elementName)));
		}else if(locatorType.equalsIgnoreCase("name"))
		{
			elementValue = getDriver().findElement(By.name(FileOperations.getValueFromElement(elementName)));
		}else if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			elementValue = getDriver().findElement(By.partialLinkText(FileOperations.getValueFromElement(elementName)));
		}else if(locatorType.equalsIgnoreCase("tagName"))
		{
			elementValue = getDriver().findElement(By.tagName(FileOperations.getValueFromElement(elementName)));
		}else if(locatorType.equalsIgnoreCase("xpath"))
		{
			elementValue = getDriver().findElement(By.xpath(FileOperations.getValueFromElement(elementName)));
		}
		return elementValue;
	}
	
		public static String getPath()
		{
			File file = new File("");
			String path = "";
			path = file.getAbsolutePath();
			return path;
		}
	
		public static void getscreenShot(String elementName)
		{
			Format format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss a");
			Date date = new Date();
			String currentDate = format.format(date);
			File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			Utils.copyFile(screenshot, new File(getPath()+"\\src\\com\\powa\\screenshots\\"+elementName+"_"+currentDate+".png"));
		}
	
		public static void click(String elementName) throws Exception
		{
			Reporter.log("Entering in click method of " + elementName);
			Assert.assertTrue(Asserations.isElementPresent(elementName), elementName+" is not Present");
			getElement(elementName).click();
			Reporter.log("Exiting from click method of " + elementName);
			BussinessMethod.delay();
		}
	
		public static void type(String elementName,String text) throws Exception
		{
			Reporter.log("Entering in type method of " + elementName);
			Assert.assertTrue(Asserations.isElementPresent(elementName), elementName+" is not Present");
			getElement(elementName).clear();
			getElement(elementName).sendKeys(text);
			Reporter.log("Exiting from type method of " +elementName);
			BussinessMethod.delay();
		}
		
		public static String getText(String elementName) throws Exception
		{
			Reporter.log("Entering in getText method of " + elementName);
			Assert.assertTrue(Asserations.isElementPresent(elementName), elementName+" is not Present");
			String text = getElement(elementName).getText();
			Reporter.log("Exiting from getText method of " +elementName);
			return text;
		}
		
		public static void selectDropdownValue(String elementName, String text) throws Exception
		{
			Reporter.log("Entering in selectDropdownValue method of " + elementName);
			Assert.assertTrue(Asserations.isElementPresent(elementName), elementName+" is not Present");
			Select dropDown = new Select(getElement(elementName));
			dropDown.selectByVisibleText(text);
			Reporter.log("Exiting from selectDropdownValue method of " +elementName);
	
		}
}
