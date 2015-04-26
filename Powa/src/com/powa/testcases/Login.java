package com.powa.testcases;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.powa.libraries.Asserations;
import com.powa.libraries.ElementRepositary;
import com.powa.libraries.FileOperations;

public class Login extends ElementRepositary{
	public static SoftAssert softAssert = new SoftAssert();
	public static boolean isLogin;
	
	@Test(priority =1,enabled =true)
	public static void login() throws Exception
	{
		
		type("login_username_text_id",FileOperations.getValueFromConfig("UserName"));
		type("login_password_text_id",FileOperations.getValueFromConfig("Password"));
		click("login_login_button_xpath");
		Asserations.isTextPresent("home_user_title_xpath","Welcome, Chirag Singh!");
		Asserations.isTextPresent("home_website_text_xpath","WEBSITE: PREVIEW");
		Asserations.isElementPresent("home_change_password_link_id");
		Asserations.isElementPresent("home_support_link_id");
		Asserations.isElementPresent("home_logout_link_id");
		Asserations.isElementPresent("home_main_home_menu_id");
		Asserations.isElementPresent("home_main_sales_menu_id");
		Asserations.isElementPresent("home_main_catalogue_menu_id");
		Asserations.isElementPresent("home_main_website_menu_id");
		Asserations.isElementPresent("home_main_settings_menu_id");
		Asserations.isElementPresent("home_main_powa_menu_id");
		Asserations.isElementPresent("home_main_preview_website_id");
		Asserations.isElementPresent("home_main_publish_website_id");
		Asserations.isTextPresent("home_dashboard_text_xpath", "WEBSITE DASHBOARD - HOME");
		Asserations.isElementPresent("home_sales_section_xpath");
		Asserations.isElementPresent("home_catalogue_section_xpath");
		Asserations.isElementPresent("home_website_section_xpath");
		isLogin = Asserations.isElementPresent("home_website_statistics_section_xpath");	
		
		
		
//		ElementRepositary.softAssert.assertAll();
	}
}
