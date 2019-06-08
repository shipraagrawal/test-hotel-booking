package com.test.framework.hotel.appModules;

import com.test.framework.hotel.pageObject.HotelBookingPage;
import com.test.framework.hotel.supportMethods.Storage;
import com.test.framework.hotel.webDriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class HotelBookingActions {

    private static WebDriver driver = Driver.getCurrentDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 10);
    private static Storage storage = Storage.getInstance();
    private static String baseUrl = "http://hotel-test.equalexperts.io/";

    public static void getHomePage() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.titleContains("Hotel booking form"));

        HotelBookingPage hotelBookingPageObject = PageFactory.initElements(driver, HotelBookingPage.class);
        storage.setStorageValue("hotelBookingPageObject", hotelBookingPageObject);
    }

    public static void verifyHomePage() {
        HotelBookingPage hotelBookingPageObject = storage.getStorageValue("hotelBookingPageObject", HotelBookingPage.class);

        assertTrue(hotelBookingPageObject.userFirstName.isEnabled());
        assertTrue(hotelBookingPageObject.userLastName.isEnabled());
        assertTrue(hotelBookingPageObject.checkinDatePicker.isEnabled());
        assertTrue(hotelBookingPageObject.checkoutDatePicker.isEnabled());
        assertTrue(hotelBookingPageObject.price.isEnabled());
        assertTrue(hotelBookingPageObject.depositPaidDropDown.isEnabled());
        assertTrue(hotelBookingPageObject.saveButton.isEnabled());
    }


    private static void selectDropDownOptions(WebElement element, String visibleText) {

        Select selectSourceCityOption = new Select(element);
        selectSourceCityOption.selectByVisibleText(visibleText);

    }


    public static void enterHotelBookingDetails(String firstName, String surname, String price, String deposit, String checkInDate, String checkOutDate) throws InterruptedException {
        HotelBookingPage hotelBookingPageObject = storage.getStorageValue("hotelBookingPageObject", HotelBookingPage.class);

        wait.until(ExpectedConditions.elementToBeClickable(hotelBookingPageObject.userFirstName));
        hotelBookingPageObject.userFirstName.clear();
        hotelBookingPageObject.userFirstName.sendKeys(firstName);

        wait.until(ExpectedConditions.elementToBeClickable(hotelBookingPageObject.userLastName));
        hotelBookingPageObject.userLastName.clear();
        hotelBookingPageObject.userLastName.sendKeys(surname);

        wait.until(ExpectedConditions.elementToBeClickable(hotelBookingPageObject.price));
        hotelBookingPageObject.price.clear();
        hotelBookingPageObject.price.sendKeys(price);

        selectDropDownOptions(hotelBookingPageObject.depositPaidDropDown, deposit);

        wait.until(ExpectedConditions.elementToBeClickable(hotelBookingPageObject.checkinDatePicker));
        hotelBookingPageObject.checkoutDatePicker.clear();
        hotelBookingPageObject.checkinDatePicker.sendKeys(checkInDate);

        wait.until(ExpectedConditions.elementToBeClickable(hotelBookingPageObject.checkoutDatePicker));
        hotelBookingPageObject.checkoutDatePicker.clear();
        hotelBookingPageObject.checkoutDatePicker.sendKeys(checkOutDate);

    }



    public static void saveHotelBookingDetails() {
        HotelBookingPage hotelBookingPageObject = storage.getStorageValue("hotelBookingPageObject", HotelBookingPage.class);
        wait.until(ExpectedConditions.elementToBeClickable(hotelBookingPageObject.saveButton));
        hotelBookingPageObject.saveButton.click();

    }

    public static void verifyBookingDetailsAndDeleteBooking(String firstName, String surname, String price, String deposit, String checkInDate, String checkOutDate) throws InterruptedException {
        HotelBookingPage hotelBookingPageObject = storage.getStorageValue("hotelBookingPageObject", HotelBookingPage.class);
        checkPageIsReady();
        List<WebElement> row = hotelBookingPageObject.bookingTable.findElements(By.xpath(("//*[contains(@class, 'row')]")));

        for (int i = 0; i < row.size(); i++) {
            WebElement webElement = row.get(i);
            String data = webElement.getText();
            data = data.replaceAll("\\n", "");
            if(data.equals(firstName+surname+price+deposit+checkInDate+checkOutDate)) {
                webElement.findElement(By.cssSelector("input")).click();
                break;
            }

        }
        wait.until(ExpectedConditions.titleContains("Hotel booking form"));

    }


    private static void checkPageIsReady() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;


        while (true) {
            if ((Boolean) (js.executeScript("return jQuery.active == 0"))) {
                break;
            }
            Thread.sleep(100);
        }


        //This loop will rotate for 25 times to check If page Is ready after every 1 second.
        //You can replace your value with 25 If you wants to Increase or decrease wait time.
        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

}
