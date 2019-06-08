package com.test.framework.hotel.stepDefinition;

import com.test.framework.hotel.appModules.HotelBookingActions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelBookingSteps {


    @Given("^user is on the hotel booking page$")
    public void userIsOnTheHotelBookingPage() {
        HotelBookingActions.getHomePage();
        HotelBookingActions.verifyHomePage();
    }


    @When("^user inputs the firstName \"([^\"]*)\", surname \"([^\"]*)\", price \"([^\"]*)\", deposit \"([^\"]*)\", checkin date \"([^\"]*)\" and checkout date \"([^\"]*)\"$")
    public void userInputsTheFirstNameSurnamePriceDepositCheckinDateAndCheckoutDate(String firstName, String surname, String price, String deposit, String checkInDate, String checkOutDate) throws InterruptedException {
        HotelBookingActions.enterHotelBookingDetails(firstName, surname, price, deposit, checkInDate, checkOutDate);
    }

    @Then("^user can save the booking details$")
    public void userCanSaveTheBookingDetails() {
        HotelBookingActions.saveHotelBookingDetails();
    }

    @And("^verifies the booking firstName \"([^\"]*)\", surname \"([^\"]*)\", price \"([^\"]*)\", deposit \"([^\"]*)\", checkin date \"([^\"]*)\" and checkout date \"([^\"]*)\" and deletes it$")
    public void verifiesTheFirstNameSurnamePriceDepositCheckinDateAndCheckoutDate(String firstName, String surname, String price, String deposit, String checkInDate, String checkOutDate) throws InterruptedException {
       HotelBookingActions.verifyBookingDetailsAndDeleteBooking(firstName, surname, price, deposit, checkInDate, checkOutDate);
    }

}