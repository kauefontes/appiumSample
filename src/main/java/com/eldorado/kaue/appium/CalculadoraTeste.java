package com.eldorado.kaue.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {
	
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "NZAA470170");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
//		desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
//	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    
	    TouchAction action = new TouchAction(driver);
	    action.longPress(207, 1120).waitAction().moveTo(569, 3).perform().release();
	    
	    MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("mais");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result");
	    
	    driver.quit();
	}

}
