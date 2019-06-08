package com.test.framework.hotel.supportFactory;

import com.test.framework.hotel.enums.Browser;
import com.test.framework.hotel.supportMethods.FileRead;
import com.test.framework.hotel.testRunner.TestRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserFactory {

    private static Browser browser = Browser.valueOf(TestRunner.config.get("browser"));
    private static final Logger LOGGER = LoggerFactory.getLogger(FileRead.class);


    public static WebDriver selectBrowser() {

        setDriverFileProperty(browser);

        switch (browser) {

            case Chrome:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                return new ChromeDriver(chromeOptions);

            case Firefox:
                return new FirefoxDriver();

            default:
                LOGGER.info("browser not defined");
                throw new WebDriverException("No browser specified");
        }
    }

    private static void setDriverFileProperty(Browser browser) {
        switch (browser) {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
                break;
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
                break;
            default:
                throw new WebDriverException("No browser specified");
        }

    }

    public static String getDriverFileBasedOnOS() {

        String os = System.getProperty("os.name").toLowerCase();

        switch (os) {
            case "linux":
                return TestRunner.config.get("browser.linux.driver");
            case "windows":
                return TestRunner.config.get("browser.windows.driver");

            case "mac":
                return TestRunner.config.get("browser.mac.driver");

            default:
                throw new WebDriverException("No browser specified");

        }

    }

}