package com.powa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.powa.baseclasses.BaseClass;
import com.powa.libraries.Asserations;
import com.powa.libraries.BussinessMethod;
import com.powa.libraries.ElementRepositary;

public class AddProduct extends BaseClass{

	@BeforeMethod
	public static void login() throws Exception
	{
		Login.login();	
	}

	@Test(priority=4)
	public static void addProduct() throws Exception
	{
		ElementRepositary.click("home_main_catalogue_menu_id");
		ElementRepositary.click("Catalogue_ManageProducts_button_xpath");
		BussinessMethod.checkProductPresent();
		ElementRepositary.click("Catalogue_ManageProducts__AddProduct_button_xpath");
		ElementRepositary.click("AddProduct_Cancel_Button_xpath");
		ElementRepositary.click("Catalogue_ManageProducts__AddProduct_button_xpath");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_SKU_textfield_xpath", "skuabc");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_Quantity_textfield_id", "20");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_Name_textfield_id", "iPhone 6");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_WEIGHT_textfield_id", "32");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_PRICE_textfield_id", "45000");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_COST_PRICE_textfield_id", "35000");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_BRAND_textfield_id","Apple");
		Asserations.isNotEnabled("AddProduct_ProductDetails_ProductData_MIN_ORDER_textfield_id");
		ElementRepositary.click("AddProduct_ProductDetails_ProductData_FORCE_ORDER_textfield_id");
		ElementRepositary.type("AddProduct_ProductDetails_ProductData_MIN_ORDER_textfield_id", "2");
		ElementRepositary.click("AddProduct_ProductDetails_ProductImages_tab_id");
		ElementRepositary.click("AddProduct_ProductDetails_ProductImages_Add_xpath");
		ElementRepositary.click("AddProduct_ProductDetails_ProductImages_Browser_id");
		BussinessMethod.windowType(BussinessMethod.windowElement("\\sikuli_image\\filename.png"), "\\TestData\\index.jpeg");
		BussinessMethod.windowClick(BussinessMethod.windowElement("\\sikuli_image\\open.png"));
		ElementRepositary.click("AddProduct_ProductDetails_ProductImages_Done_button_id");
		BussinessMethod.doubleClick("AddProduct_ProductDetails_FullDescription_tab_id");
		BussinessMethod.sleep(2000);
		BussinessMethod.doubleClick("AddProduct_ProductDetails_FullDescription_tab_id");
		BussinessMethod.windowTextType(BussinessMethod.windowElement("\\sikuli_image\\product_text.png"), "This is a full Descriptions of the product");
		//BussinessMethod.switchFrame("AddProduct_ProductDetails_FullDescription_iframe_xpath");
		BussinessMethod.keyborad("Ctrl+A");
		BussinessMethod.keyborad("Ctrl+B");
		BussinessMethod.doubleClick("AddProduct_ProductDetails_ShortDescription_tab_id");
		BussinessMethod.sleep(2000);
		ElementRepositary.click("AddProduct_ProductDetails_ShortDescription_tab_id");
		BussinessMethod.windowTextType(BussinessMethod.windowElement("\\sikuli_image\\product_text.png"), "This is a short Descriptions of the product");
		ElementRepositary.click("AddProduct_Custom_Attributes_tab_xpath");
		ElementRepositary.click("AddProduct_Custom_Attributes_Add_button_id");
		BussinessMethod.doubleClick("AddProduct_Custom_Attributes_Name_field_xpath");
		ElementRepositary.type("AddProduct_Custom_Attributes_Name_text_field_xpath", "iPhone Mobile");
		BussinessMethod.doubleClick("AddProduct_Custom_Attributes_Value_field_xpath");
		ElementRepositary.type("AddProduct_Custom_Attributes_Value_text_field_xpath", "45,000");
		ElementRepositary.click("AddProduct_Custom_Attributes_Display_on_Website_checkbox_xpath");
		ElementRepositary.click("AddProduct_Product_Options_tab_xpath");
		ElementRepositary.click("AddProduct_Product_Options_Add_button_id");
		ElementRepositary.click("AddProduct_Product_Options_Display_Option_Information_box_id");
		ElementRepositary.click("AddProduct_Product_Options_Display_Option_Check_box_id");
		ElementRepositary.click("AddProduct_Product_Options_Display_Option_Choice_List_id");
		ElementRepositary.click("AddProduct_Product_Options_Display_Option_Check_box_id");
		ElementRepositary.click("AddProduct_Product_Next_id");
		ElementRepositary.type("AddProduct_Product_Add_Option_Name_xpath", "iPhone 6 series");
		ElementRepositary.type("AddProduct_Product_Add_Option_Price_xpath", "45000");
		BussinessMethod.doubleClick("AddProduct_Product_Add_Option_Done_button_xpath");
		ElementRepositary.click("AddProduct_Stock_Control_tab_id");
		Asserations.isNotEnabled("AddProduct_Stock_Control_Stock_Level_Alert_id");
		ElementRepositary.click("AddProduct_Stock_Control_Stock_Check_box_id");
		Asserations.isEnabled("AddProduct_Stock_Control_Stock_Level_Alert_id");
		ElementRepositary.click("AddProduct_Stock_Control_Disable_Stock_Control_id");
		Asserations.isNotEnabled("AddProduct_Stock_Control_Stock_Level_Alert_id");
		ElementRepositary.click("AddProduct_SEO_Information_tab_id");
		ElementRepositary.click("AddProduct_SEO_Information_SEO_Information_check_box_xpath");
		ElementRepositary.type("AddProduct_SEO_Information_SEO_Information_name_xpath", "Apple iPhone");
		ElementRepositary.type("AddProduct_SEO_Information_SEO_Information_description_xpath", "Description of SEO");
		ElementRepositary.type("AddProduct_SEO_Information_SEO_Information_keyword_xpath", "iPhone mobiles");
		ElementRepositary.click("AddProduct_Recommended_Products_tab_id");
		ElementRepositary.click("AddProduct_Recommended_Products_Product_Name_xpath");
		ElementRepositary.click("AddProduct_Recommended_Products_ALL_RIGHT_BUTTON_id");
		ElementRepositary.click("AddProduct_Recommended_Products_ALL_LEFT_BUTTON_id");
		BussinessMethod.doubleClick("AddProduct_Recommended_Products_Product_Name_xpath");
		ElementRepositary.click("AddProduct_Recommended_Products_SINGLE_RIGHT_BUTTON_id");
		ElementRepositary.click("AddProduct_Applicable_Taxes_tab_id");
		ElementRepositary.click("AddProduct_Applicable_Taxes_ALL_Left_BUTTON_id");
		BussinessMethod.doubleClick("AddProduct_Applicable_Taxes_Tax_name_xpath");
		ElementRepositary.click("AddProduct_Done_Button_xpath");
		BussinessMethod.sleep(2000);
		ElementRepositary.type("Catalogue_ManageProducts_Seach_textfield_id", "iPhone 6");
		ElementRepositary.click("Catalogue_ManageProducts_Search_button_id");
		String productName = ElementRepositary.getText("Catalogue_ManageProducts_Product_Name_xpath");
		System.out.println("Added productName " + productName);
		Asserations.isTextPresent("Catalogue_ManageProducts_Product_Name_xpath", "iPhone 6");
	}
	
	@AfterMethod
	public static void logout() throws Exception
	{
		ElementRepositary.click("home_logout_link_id");
	}
}
