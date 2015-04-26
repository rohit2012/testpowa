package com.powa.libraries;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.*;
//import org.sikuli.script.Screen;
import org.testng.Reporter;

import com.powa.baseclasses.BaseClass;

public class BussinessMethod extends ElementRepositary{

	public static void mouseHover(String elementName) throws Exception
	{
		Reporter.log("Entering in mouseHover method of "+elementName);
		Actions action = new Actions(getDriver());
		action.moveToElement(getElement(elementName)).build().perform();
		delay();
		Reporter.log("Exiting from mouseHover method of " +elementName);
	}

	public static void delay() throws Exception
	{
		String waitTime= FileOperations.getValueFromConfig("WaitSeconds");
		int j = Integer.parseInt(waitTime);
		Thread.sleep(j);
	}

	public static void sleep(int i) throws Exception
	{
		Thread.sleep(i);
	}
	public static void doubleClick(String elementName) throws Exception
	{
		Reporter.log("Entering in doubleClick method of " + elementName);
		Actions action = new Actions(getDriver());
		action.doubleClick(getElement(elementName)).build().perform();
		delay();
		Reporter.log("Existing from doubleClick method of " + elementName);
	}

	public static void switchWindow(int i)
	{
		Object[] win = getDriver().getWindowHandles().toArray();
		int len = win.length;
		getDriver().switchTo().window((String)win[i]);
	}

	public static void switchAlert()
	{
		getDriver().switchTo().alert();
	}

	public static Pattern windowElement(String path)
	{
		Pattern image = new Pattern (getPath()+path);
		return image;
	}

	public static void windowClick(Pattern path) throws Exception
	{
		Screen screen = new Screen();
		screen.wait(path, 10);
		screen.click(path);
	}

	public static void windowType(Pattern path,String text) throws Exception
	{
		String realtext = getPath()+text;
		Screen screen = new Screen();
		screen.wait(path, 2);
		screen.type(path, realtext);
	}

	public static void windowTextType(Pattern path,String text) throws Exception
	{
		String realtext = text;
		Screen screen = new Screen();
		screen.wait(path, 2);
		screen.type(path, realtext);
	}

	public static void keyborad(String key)
	{
		Actions action = new Actions(getDriver());
		switch(key)
		{
		case "Ctrl+A":
			action.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
			action.keyUp(Keys.COMMAND).build().perform();
			break;
		case "Enter":
			action.keyDown(Keys.ENTER).build().perform();
			action.keyUp(Keys.ENTER).build().perform();
			break;
		case "Ctrl+B":
			action.keyDown(Keys.CONTROL).sendKeys("b").build().perform();
			action.keyUp(Keys.CONTROL);
			break;
		case "Ctrl+T":
			action.keyDown(Keys.CONTROL).sendKeys("t").build().perform();
			action.keyUp(Keys.CONTROL).build().perform();
			break;
		case "Ctrl+W":
			action.keyDown(Keys.CONTROL).sendKeys("w").build().perform();
			action.keyUp(Keys.CONTROL).build().perform();
			break;

		}
	}

	public static void switchFrame(String ElementName) throws Exception
	{
		getDriver().switchTo().frame(getElement(ElementName));
	}

	public static void checkProductPresent() throws Exception
	{
		ElementRepositary.type("Catalogue_ManageProducts_Seach_textfield_id", "iPhone 6");
		ElementRepositary.click("Catalogue_ManageProducts_Search_button_id");
		sleep(1000);
		try
		{
			String productName = ElementRepositary.getElement("Catalogue_ManageProducts_Product_Name_xpath").getText();
			System.out.println("Searched productName " + productName);
			if(productName.equals("iPhone 6"))
			{
				ElementRepositary.click("Catalogue_ManageProducts_Product_Name_xpath");
				ElementRepositary.click("Catalogue_ManageProducts_Delete_Product_button_xpath");
				ElementRepositary.click("Catalogue_ManageProducts_Delete_Product_Confirmation_message_xpath");
				Reporter.log("Added product is deleted");
				System.out.println("Added product is deleted");
			}

		}catch(Exception e)
		{
			Reporter.log("No Product is added ");
			System.out.println("No Product is added "+ e);

		}
		//Asserations.isTextPresent("Catalogue_ManageProducts_Product_Name_xpath", "iPhone 6");

	}

	public static void setUpWebSite() throws Exception
	{
		keyborad("Ctrl+T");
		BaseClass.getDriver().get(FileOperations.getValueFromConfig("WebsiteUrl"));
	}

	public static void deleteAddedPayment() throws Exception
	{
		boolean flag = Asserations.isElementDisplay("ManagePaymentMethods_Edited_Payment_xpath");
		boolean flag1 = Asserations.isElementDisplay("ManagePaymentMethods_Added_Payment_xpath");
		System.out.println("Added Product " + flag);
		if(flag==true||flag1==true)
		{
			if(flag==true)
			{
				ElementRepositary.click("ManagePaymentMethods_Edited_Payment_xpath");
			}
			else
			{
				ElementRepositary.click("ManagePaymentMethods_Added_Payment_xpath");
			}
			ElementRepositary.click("ManagePaymentMethods_Edit_Payment_Method_button_id");
			boolean checked = Asserations.isElementDisplay("ManagePaymentMethods_PAYMENT_PAGE_DISPLAY_TO_CUSTOMER_CHECKBOX_isChecked_xpath");
			System.out.println("checked " +checked);
			if(checked==true)
			{
				ElementRepositary.click("ManagePaymentMethods_PAYMENT_PAGE_DISPLAY_TO_CUSTOMER_CHECKBOX_id");
			}
			ElementRepositary.click("Common_Done_button_xpath");
			ElementRepositary.click("ManagePaymentMethods_Delete_Payment_Method_button_id");
			ElementRepositary.click("Common_Yes_button_xpath");
			sleep(2000);
			Asserations.isElementNotPresent("ManagePaymentMethods_Edited_Payment_xpath");
			Reporter.log("Added Payment is deleted");
		}
		else
		{
			Reporter.log("No Payment is avaliable");
		}
	}
	
	public static void checkPaymentMethod() throws Exception
	{
	}
}

