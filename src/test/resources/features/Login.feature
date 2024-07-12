@smoke
Feature: Login with valid and invalid credentials

  Background:
    Given the user is on the login sign up page
  Scenario Outline: As user I can login with valid credentials
    When I click Signup - Login link
    Then I verify 'Login to your account' is visible
    When I enter the correct "<email>"  and "<password>"
    And I click 'Login' button
    Then I verify Logged in as "<username>" is visible
   # When I click Delete Account link
   # Then I verify Account Deleted! text is visible

    Examples:
      | email                  | password | username        |
      | test.automation@xyz.com | test123  | Test Automation |


  Scenario: As user I can't login with invalid credentials
    When I click Signup - Login link
    Then I verify 'Login to your account' is visible
    When I enter the wrong email address and password
    And I click 'Login' button
    Then I verify 'Your email or password is incorrect!' is visible