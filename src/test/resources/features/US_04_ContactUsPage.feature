@wip
Feature: Contact Us form submission

  Scenario: Submit a message through the Contact Us form
    Given The user is on the Home page
    When I click 'Contact us' link
    Then I verify 'Get In Touch' message is visible
    When I enter name, email, subject and message
    And I upload a file
    And I click Submit button
    And I click OK on the alert popup
    Then I verify 'Success! Your details have been submitted successfully.' message is visible
    When I click 'Home' link
    Then I should be on the home page successfully