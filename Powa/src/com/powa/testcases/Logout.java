package com.powa.testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;



import com.powa.libraries.Asserations;
import com.powa.libraries.ElementRepositary;
import com.powa.libraries.FileOperations;

public class Logout extends ElementRepositary{

	//@Test(priority=2,dependsOnMethods ={"login"})
	@Test(priority=2)
	public static void logout() throws Exception
	{
		if(!Login.isLogin==true)
			throw new SkipException("This is skiped due tp login failed");
		ElementRepositary.type("login_username_text_id",FileOperations.getValueFromConfig("UserName"));
		ElementRepositary.type("login_password_text_id",FileOperations.getValueFromConfig("Password"));
		ElementRepositary.click("login_login_button_xpath");
		Asserations.isTextPresent("home_user_title_xpath","Welcome, Chirag Singh!");
		ElementRepositary.click("home_logout_link_id");
		Asserations.isTextPresent("logout_text_message_xpath","You have been successfully logged out.");
		
	}

}
