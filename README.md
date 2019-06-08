# Java, Cucumber, and Selenium Automation Test Framework with some tests to test the website http://hotel-test.equalexperts.io/


Salient Features:

 - Tests are using the Page object Model
 - Tests can be run on the Chrome browser and the firefox browser
 - Cucumber is used to define the flow of the tests
 - Hamcrest is used to verify and assert different pages
 - Incase of a failure of scenario, a screenshot is taken and stored on the resources directory: src/test/resources/error
 - The drivers for chrome and firefox are included as part of the repository, so that tests can be run without any setup issues on linux

Operating System:

  These tests will only run on linux environment

Browser Drivers:
  Once the repository is downloaded the test will not run as the drivers will not be downloadeda s executable. In order to make the drivers executable run the following command,
  if the repository is in the home folder
        chmod +x ~/sample-ui-test-framework/src/test/resources/drivers/chromedriver



Running tests:

 - Test can be run on command line using mvn clean install, the default browser option is chrome
 - To run the tests using firefox use mvn clean test -Dtest.properties=firefox.properties



