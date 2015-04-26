package com.powa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.powa.libraries.Asserations;
import com.powa.libraries.BussinessMethod;
import com.powa.libraries.ElementRepositary;

public class MenuTab extends ElementRepositary{

	@BeforeMethod
	public static void login() throws Exception
	{
		Login.login();	
	}

	@Test(priority=3)
	public static void verifySubTab() throws Exception
	{
		//Verify the sub-menus for sales menu
		BussinessMethod.mouseHover("home_main_sales_menu_id");
		Asserations.isElementPresent("home_sales_submenu_ManageOrders_xpath");
		Asserations.isElementPresent("home_sales_submenu_FormatInvoice_xpath");
		Asserations.isElementPresent("home_sales_submenu_DownloadCustomers_xpath");
		Asserations.isElementPresent("home_sales_submenu_CustomiseEmailNotifications_xpath");
		Asserations.isElementPresent("home_sales_submenu_EditOrderStatusUpdateSettings_xpath");
		Asserations.isElementPresent("home_sales_submenu_EditOrderNumberSettings_xpath");

		//Verify the sub-menus for Catalogue menu
		BussinessMethod.mouseHover("home_main_catalogue_menu_id");
		Asserations.isElementPresent("home_catalogue_submenu_ManageProduct_xpath");
		Asserations.isElementPresent("home_catalogue_submenu_ManageBrands_xpath");
		Asserations.isElementPresent("home_catalogue_submenu_ExportPublishedProducts_xpath");
		Asserations.isElementPresent("home_catalogue_submenu_ManagePromotions_xpath");
		Asserations.isElementPresent("home_catalogue_submenu_EditGoogleMerchantCenterSettings_xpath");
		Asserations.isElementPresent("home_catalogue_submenu_EditCurrencySettings_xpath");
		Asserations.isElementPresent("home_catalogue_submenu_EditStockControlSettings_xpath");

		// Verify the sub-menus for Website menu
		BussinessMethod.mouseHover("home_main_website_menu_id");
		Asserations.isElementPresent("home_website_submenu_EditWebsite_xpath");
		Asserations.isElementPresent("home_website_submenu_ChangeWebsiteTemplate_xpath");
		Asserations.isElementPresent("home_website_submenu_EditSEOSettings_xpath");
		Asserations.isElementPresent("home_website_submenu_EditGoogleAnalyticsSettings_xpath");
		Asserations.isElementPresent("home_website_submenu_EditWebmasterVerification_xpath");

		// Verify the sub-menus for Settings menu
		BussinessMethod.mouseHover("home_main_settings_menu_id");
		Asserations.isElementPresent("home_settings_submenu_ManageShippingMethods_xpath");
		Asserations.isElementPresent("home_settings_submenu_ManageTaxes_xpath");
		Asserations.isElementPresent("home_settings_submenu_ManageRegions_xpath");
		Asserations.isElementPresent("home_settings_submenu_ManagePaymentMethods_xpath");
		Asserations.isElementPresent("home_settings_submenu_EditShoppingCartSettings_xpath");
		Asserations.isElementPresent("home_settings_submenu_EditEmailNotificationSettings_xpath");
		Asserations.isElementPresent("home_settings_submenu_ManageWebsiteDomains_xpath");
		Asserations.isElementPresent("home_settings_submenu_ManageEmailAddresses_xpath");

		// Verify the sub-menus for Powa App menu
		BussinessMethod.mouseHover("home_main_powa_menu_id");
		Asserations.isElementPresent("home_powa_submenu_VisitPowaAppStore_xpath");
		Asserations.isElementPresent("home_powa_submenu_GetCustomDesign_xpath");
		Asserations.isElementPresent("home_powa_submenu_AuthoriseIntegration_xpath");
		Asserations.isElementPresent("home_powa_submenu_ManageIntegrations_xpath");
	}

	@AfterMethod
	public static void logout() throws Exception
	{
		ElementRepositary.click("home_logout_link_id");
	}
}
