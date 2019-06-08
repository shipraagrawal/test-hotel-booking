Feature: To test the hotel booking functionality
#  This scenario tests the hotel booking functionality for http://hotel-test.equalexperts.io/
#  It is a basic test to create a booking with valid data and can be extended to check for invalid data cases



  Scenario Outline:
    Given user is on the hotel booking page
    When user inputs the firstName "<FirstName>", surname "<Surname>", price "<Price>", deposit "<Deposit>", checkin date "<Check-in Date>" and checkout date "<Check-out Date>"
    Then user can save the booking details
    And verifies the booking firstName "<FirstName>", surname "<Surname>", price "<Price>", deposit "<Deposit>", checkin date "<Check-in Date>" and checkout date "<Check-out Date>" and deletes it

    Examples:
      | FirstName | Surname       | Price   | Deposit | Check-in Date | Check-out Date |
      | Tester1   | AlwaysTesting | 2000    | true    | 2019-06-17    | 2019-06-17     |
      | Tester2   | Slacking      | 4700000 | true    | 2019-06-29    | 2019-07-29     |
      | Tester3   | HavingFun     | 20      | false   | 2020-06-17    | 2020-07-17     |





