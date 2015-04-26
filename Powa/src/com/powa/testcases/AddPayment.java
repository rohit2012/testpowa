package com.powa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.powa.baseclasses.BaseClass;
import com.powa.libraries.Asserations;
import com.powa.libraries.BussinessMethod;
import com.powa.libraries.ElementRepositary;

public class AddPayment extends BaseClass{
	
	@BeforeMethod
	public static void login() throws Exception
	{
		Login.login();	
	}
	
	@Test(priority=6)
	public static void addPayment() throws Exception
	{
		ElementRepositary.click("home_main_settings_menu_id");
		ElementRepositary.click("Settings_ShoppingCart_Manage_Payment_Methods_button_id");
		BussinessMethod.deleteAddedPayment();
		ElementRepositary.click("ManagePaymentMethods_Add_Payment_Method_button_id");
		ElementRepositary.click("Common_Cancel_button_xpath");
		ElementRepositary.click("ManagePaymentMethods_Add_Payment_Method_button_id");
		Asserations.isTextPresent("ManagePaymentMethods_Add_Payment_Method_Title_xpath", "Add Payment Method");
		ElementRepositary.click("ManagePaymentMethods_Payment_Type_OFFLINE_PAYMENT_RADIO_id");
		ElementRepositary.click("Common_Next_button_xpath");
		ElementRepositary.type("ManagePaymentMethods_PAYMENT_PAGE_NAME_TEXT_BOX_id", "Add Cash on Delivery");
		ElementRepositary.click("Common_Done_button_xpath");
		Asserations.isTextPresent("ManagePaymentMethods_Added_Payment_xpath", "Add Cash on Delivery");
		
		// Edit the Payment Method
		ElementRepositary.click("ManagePaymentMethods_Added_Payment_xpath");
		ElementRepositary.click("ManagePaymentMethods_Edit_Payment_Method_button_id");
		ElementRepositary.type("ManagePaymentMethods_PAYMENT_PAGE_NAME_TEXT_BOX_id", "Cash on Delivery");
		ElementRepositary.click("ManagePaymentMethods_PAYMENT_PAGE_DISPLAY_TO_CUSTOMER_CHECKBOX_id");
		ElementRepositary.click("Common_Done_button_xpath");
		Asserations.isTextPresent("ManagePaymentMethods_Edited_Payment_xpath", "Cash on Delivery");
	
		// Verify on Preview Website
		ElementRepositary.click("home_main_preview_website_id");
		BussinessMethod.switchWindow(1);
		ElementRepositary.click("PreviewWebsite_Buy_Product_name_xpath");
		ElementRepositary.type("PreviewWebsite_Buy_Product_quantity_xpath", "1");
		//Asserations.isTextPresent("PreviewWebsite_Buy_Product_Min_quantity_message_xpath", "Minimum order quantity for iPhone 6 is 2.");
		ElementRepositary.click("PreviewWebsite_Buy_Product_Buy_Button_id");
		ElementRepositary.type("PreviewWebsite_Buy_Product_quantity_xpath", "2");
		ElementRepositary.click("PreviewWebsite_Buy_Product_Buy_Button_id");
		ElementRepositary.click("PreviewWebsite_Buy_Product_Shipping_Method_xpath");
		ElementRepositary.click("PreviewWebsite_Buy_Product_CheckOut_button_xpath");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_Title_xpath", "Mr");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_firstName_xpath", "John");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_lastName_xpath", "David");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_company_xpath", "TCS LTD Company");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_addressLine1_xpath", "House no: 11/12, Street: 10, new ghandhi road");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_townCity_xpath", "New Delhi");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_countyState_xpath", "New Delhi");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_postcode_xpath", "11025");
		ElementRepositary.selectDropdownValue("PreviewWebsite_Buy_Product_BillingInfo_country_xpath", "INDIA");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_email_xpath", "john_d@gmail.com");
		ElementRepositary.type("PreviewWebsite_Buy_Product_BillingInfo_phone_xpath", "9999639539");
		ElementRepositary.click("PreviewWebsite_Buy_Product_Continue_button_xpath");
		Asserations.isElementPresent("PreviewWebsite_Buy_Product_Payment_Method_xpath");
		BussinessMethod.switchWindow(0);
	}
	
	@AfterMethod
	public static void logout() throws Exception
	{
		ElementRepositary.click("home_logout_link_id");
	}
}
