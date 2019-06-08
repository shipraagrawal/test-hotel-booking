package com.test.framework.hotel.webDriver;

import org.openqa.selenium.WebDriver;
import com.test.framework.hotel.supportFactory.WebdriverFactory;

import java.util.concurrent.TimeUnit;

public class Driver {

	public static WebDriver webdriver ;
	
	public synchronized static WebDriver getCurrentDriver() {
		
		if (webdriver == null) {
			webdriver = WebdriverFactory.createWebdriver();
			webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return webdriver;
	}

}
