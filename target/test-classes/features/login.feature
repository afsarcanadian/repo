Feature: Login Functionality

  @smoke
  Scenario: Login with Valid Credentials
    Given user navigated to HRMS applicaiotn
    When user enters valid user name and password
    And click on Login button
    Then user should be successfully logged in to the application
