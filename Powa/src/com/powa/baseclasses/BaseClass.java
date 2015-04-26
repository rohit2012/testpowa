package com.powa.baseclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.powa.libraries.ElementRepositary;
import com.powa.libraries.FileOperations;

public class BaseClass {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception
	{
		setDriver(FileOperations.getValueFromConfig("BrowserName"));
		getDriver().get(FileOperations.getValueFromConfig("URL"));
	}
	public static void setDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("FF"))
		{
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", ElementRepositary.getPath()+"\\Driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ElementRepositary.getPath()+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	@AfterClass	
	public static void tearDown()
	{
		getDriver().quit();
	}
}
