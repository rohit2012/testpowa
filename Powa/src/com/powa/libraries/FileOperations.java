package com.powa.libraries;

import java.io.FileInputStream;
import java.util.Properties;

public class FileOperations {

	public static String getValueFromConfig(String key) throws Exception
	{
		Properties prob = new Properties();
		prob.load(new FileInputStream(ElementRepositary.getPath()+"\\src\\com\\powa\\configurations\\config.properties"));
		String val = prob.getProperty(key);
		return val;
	}
	
	public static String getValueFromElement(String key) throws Exception
	{
		Properties prob = new Properties();
		prob.load(new FileInputStream(ElementRepositary.getPath()+"\\src\\com\\powa\\elementrepositaries\\elementreposirary.properties"));
		String elementName = prob.getProperty(key);
		return elementName;
	}
}
