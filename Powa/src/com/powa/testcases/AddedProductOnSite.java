package com.powa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.powa.baseclasses.BaseClass;
import com.powa.libraries.Asserations;
import com.powa.libraries.BussinessMethod;
import com.powa.libraries.ElementRepositary;


public class AddedProductOnSite extends BaseClass{

	@BeforeMethod
	public static void login() throws Exception
	{
		Login.login();	
	}
	
	@Test(priority=5)
	public static void verifyAddedProduct() throws Exception
	{
		ElementRepositary.click("home_main_website_menu_id");
		ElementRepositary.click("Website_Edit_Website_id");
		ElementRepositary.click("EditWebsite_Menu_Edit_Page_id");
		ElementRepositary.click("EditWebsite_Page_Sections_featured_products_edit_xpath");
		ElementRepositary.type("EditWebsite_Page_Sections_featured_products_search_field_id", "iPhone 6");
		ElementRepositary.click("EditWebsite_Page_Sections_featured_products_search_button_id");
		BussinessMethod.doubleClick("EditWebsite_Page_Sections_featured_products_searched_product_xpath");
		ElementRepositary.click("EditWebsite_Page_Sections_featured_SINGLE_RIGHT_BUTTON_id");
		ElementRepositary.click("Common_Done_button_xpath");
		ElementRepositary.click("EditWebsite_SaveChanges_xpath");
		ElementRepositary.click("home_main_preview_website_id");
		BussinessMethod.switchWindow(1);
		Asserations.isTextPresent("PreviewWebsite_Added_Product_name_xpath", "IPHONE 6");
		BussinessMethod.switchWindow(0);
		ElementRepositary.click("home_main_publish_website_id");
		Asserations.waitForElementNotPresent("PublishWebsite_Wait_image_xpath", 5000);
		ElementRepositary.click("Common_Yes_button_xpath");
		Asserations.waitForElementNotPresent("PublishWebsite_Wait_image_xpath", 5000);
		ElementRepositary.click("Common_Ok_button_xpath");
		BussinessMethod.setUpWebSite();
		Asserations.isTextPresent("PreviewWebsite_Added_Product_name_xpath", "IPHONE 6");
		BussinessMethod.keyborad("Ctrl+W");
	}

	@AfterMethod
	public static void logout() throws Exception
	{
		ElementRepositary.click("home_logout_link_id");
	}
}
