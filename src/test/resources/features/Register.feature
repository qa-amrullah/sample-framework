@smoke
Feature: Register account for the first time

  Background: User is on the sign up page
    Given the user is on the login sign up page

  Scenario: As user I can register for the first time so I can use the website
    When I click Signup - Login link
    Then I verify 'New User Signup!' is visible
    And I enter name and email address and click 'Signup'
    Then I verify 'Enter Account Information' is visible
    When I fill in account details and personal details
    And I select the checkboxes for newsletter and offers
    And I click 'Create Account' button
    Then I verify 'Account Created!' is visible
    And I click 'Continue' link
    Then I verify Logged in as username is visible
    When I click Delete Account link
    Then I verify Account Deleted! text is visible
    And I click 'Continue' link

@wip
  Scenario Outline: As user I can't register with existing email address
    When I click Signup - Login link
    Then I verify 'New User Signup!' is visible
    And I enter "<Name>" and an already registered "<email_address>"
    And I click 'Signup' button
    Then I verify 'Email Address already exist!' is visible

    Examples:
      | email_address           | Name            |
      | test.automation@xyz.com | Test Automation |
