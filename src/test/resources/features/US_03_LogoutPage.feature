
Feature: Login with valid credentials and Logout
  Background:
    Given the user is on the login sign up page
  Scenario Outline: As user I can login with valid credentials and logout
    When I click Signup - Login link
    Then I verify 'Login to your account' message is visible
    When I enter the correct "<email>"  and "<password>"
    And I click 'Login' button
    Then I verify Logged in as "<username>" is visible
    And I click 'Logout' link
    Then I verify that user is navigated to login page


    Examples:
      | email                  | password | username        |
      | test.automation@xyz.com | test123  | Test Automation |
