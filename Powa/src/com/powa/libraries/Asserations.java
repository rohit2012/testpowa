package com.powa.libraries;

import org.testng.Assert;
import org.testng.Reporter;

public class Asserations extends ElementRepositary{

	public static boolean isElementPresent(String elementName) throws Exception
	{
		boolean elementPresent = false;
		try{
			elementPresent = getElement(elementName).isDisplayed();
		}catch(Exception e)
		{
			ElementRepositary.getscreenShot(elementName);
			Assert.fail(elementName+" is not present");
		}
		return elementPresent;
	}
	
	public static boolean isElementNotPresent(String elementName) throws Exception
	{
		boolean elementPresent = false;
		try{
			elementPresent = getElement(elementName).isDisplayed();
			Assert.fail(elementName+" is present");
			ElementRepositary.getscreenShot(elementName);
		}catch(Exception e)
		{
			System.out.println("Exception of isElementNotPresent " +e);
			
		}
		return elementPresent;
	}
	
	public static void isTextPresent(String elementName, String expectedText) throws Exception
	{
		Reporter.log("Entering in isTextPresent method of "+elementName);
		Assert.assertTrue(isElementPresent(elementName), elementName+"is not present");
		String text = getElement(elementName).getText();
		String actualText = text.trim();
//		if(actualText==expectedText)
//		{
//			
//		}
//		else
//		{
//			ElementRepositary.getscreenShot(elementName);
//			Assert.fail("ACTUAL:"+"["+actualText+"]"+" does not match with EXPECTED: "+"["+expectedText+"]");
//		}
		Assert.assertEquals(actualText, expectedText);
		Reporter.log("Exiting from isTextPresent method of " +elementName);
	}
	
	public static void isEnabled(String elementName) throws Exception
	{
		boolean flag = false;
		Reporter.log("Entering in isEnabled method of "+elementName );
		flag = getElement(elementName).isEnabled();
		if(flag==true)
		{
			
		}
		else
		{
			ElementRepositary.getscreenShot(elementName);
			Assert.fail(elementName+" is not enabled");
		}
		//Assert.assertTrue(flag, elementName+" is notenabled");
		Reporter.log("Exiting from isEnabled method of " +elementName);
	}
	
	public static void isNotEnabled(String elementName) throws Exception
	{
		boolean flag = false;
		Reporter.log("Entering in isNotEnabled method of " +elementName);
		flag = getElement(elementName).isEnabled();
		if(flag==false)
		{
			
		}
		else
		{
			ElementRepositary.getscreenShot(elementName);
			Assert.fail(elementName+" is enabled");
		}
		//Assert.assertFalse(flag, elementName+" is enabled");
		Reporter.log("Exiting from isNotEnabled method of " +elementName);
	}
	
	public static boolean isElementDisplay(String elementName)
	{
		boolean flag = false;
		try{
			flag = getElement(elementName).isDisplayed();
		}catch(Exception e)
		{
			System.out.println("isElementDisplay "+ e);
		}
		return flag;
	}
	
	public static void waitForElementNotPresent(String elementName, int timeOut) throws Exception
	{
		int i =0;
		while(i<timeOut)
		{
			if(isElementDisplay(elementName)==false)
			{
				break;
			}
			else
			{
				BussinessMethod.sleep(1000);
			}
		}
	}
	
	public static void waitForElementPresent(String elementName, int timeOut) throws Exception
	{
		int i =0;
		while(i<timeOut)
		{
			if(isElementDisplay(elementName)==true)
			{
				break;
			}
			else
			{
				BussinessMethod.sleep(1000);
			}
		}
	}
	
	public static void isSelected(String elementName) throws Exception
	{
		boolean flag = false;
		Reporter.log("Entering in isSelected method of "+elementName );
		flag = getElement(elementName).isSelected();
		BussinessMethod.sleep(5000);
		System.out.println(flag);
		if(flag==true)
		{
			
		}
		else
		{
			ElementRepositary.getscreenShot(elementName);
			Assert.fail(elementName+" is not selected");
		}
		//Assert.assertTrue(flag, elementName+" is notselected");
		Reporter.log("Exiting from isSelected method of " +elementName);
	}
	
}
