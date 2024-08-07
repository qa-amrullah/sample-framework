package com.eComApp.steps;

import com.eComApp.pages.ContactUsPage;
import com.eComApp.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class ContactUsSteps {
    ContactUsPage contactUsPage;

    @When("I enter name, email, subject and message")
    public void i_enter_name_email_subject_and_message() {
        contactUsPage = new ContactUsPage();
        contactUsPage.emailInput.sendKeys("test@example.com");
        contactUsPage.nameInput.sendKeys("John Doe");
        contactUsPage.subjectInput.sendKeys("Test");
        contactUsPage.messageInput.sendKeys("This is a test message");
    }
    @When("I upload a file")
    public void i_upload_a_file() {
        contactUsPage.uploadFileInput.sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/test.txt");
    }
    @Then("I should be on the home page successfully")
    public void i_should_be_on_the_home_page_successfully() {
        Assert.assertEquals(Driver.getDriver().getTitle(),"Automation Exercise");
    }

    @Given("The user is on the Home page")
    public void theUserIsOnTheHomePage() {
        Driver.getDriver().get("http://automationexercise.com");
      //  Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @And("I click Submit button")
    public void iClickSubmitButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", contactUsPage.submitButton);
    }

    @And("I click OK on the alert popup")
    public void iClickOKOnTheAlertPopup() {
        Driver.getDriver().switchTo().alert().accept();
    }
}
