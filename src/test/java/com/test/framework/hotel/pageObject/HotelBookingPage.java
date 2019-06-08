package com.test.framework.hotel.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HotelBookingPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"firstname\"]")
    public  WebElement userFirstName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"lastname\"]")
    public  WebElement userLastName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"totalprice\"]")
    public  WebElement price;

    @FindBy(how = How.XPATH, using = "//*[@id=\"depositpaid\"]")
    public  WebElement depositPaidDropDown;

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkin\"]")
    public  WebElement checkinDatePicker;

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout\"]")
    public  WebElement checkoutDatePicker;

    @FindBy(how = How.XPATH, using = "//*[@id=\"form\"]/div/div[7]/input")
    public  WebElement saveButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"bookings\"]")
    public  WebElement bookingTable;


}
