package com.test.framework.hotel.supportFactory;

import com.test.framework.hotel.webDriver.Driver;
import org.openqa.selenium.WebDriver;

public class WebdriverFactory {

    private static class BrowserCleanup implements Runnable {
        public void run() {
            System.out.println("Cleaning up the browser");
            try {
                Driver.webdriver.quit();
            } catch (NullPointerException e) {
                System.out.println("Browser already shut down.");
            }
        }
    }


    public static WebDriver createWebdriver() {
        Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
        return BrowserFactory.selectBrowser();
    }

}
