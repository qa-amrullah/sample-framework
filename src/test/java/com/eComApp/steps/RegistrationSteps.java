package com.eComApp.steps;

import com.eComApp.pages.RegisterPage;
import com.eComApp.utilities.BrowserUtils;
import com.eComApp.utilities.ConfigurationReader;
import com.eComApp.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class RegistrationSteps {



    @Given("the user is on the login sign up page")
    public void the_user_is_on_the_login_sign_up_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    RegisterPage registerPage = new RegisterPage();


    @When("I click Signup - Login link")
    public void iClickSignupLoginLink() {
        registerPage.signUpLoginLink.click();
    }

    @Then("I click {string} button")
    public void i_click_button(String buttonName) {
        registerPage.clickButton(buttonName);
    }

    @Then("I verify {string} message is visible")
    public void i_verify_is_message_visible(String elementText) {
        Assert.assertTrue(BrowserUtils.isVisible(elementText));
    }
    Faker faker = new Faker();
    String email;
    String name;
    String firstName;
    String lastName;
    @Then("I enter name and email address and click {string}")
    public void i_enter_name_and_email_address_and_click(String text) {
        firstName=faker.name().firstName();
        lastName=faker.name().lastName();
        email=firstName+"."+lastName+"@xyz.com";
        name=firstName+" "+lastName;

        registerPage.signUpName.sendKeys(name);
        registerPage.signUpEmail.sendKeys(email);
        registerPage.clickButton(text);

    }
    @When("I fill in account details and personal details")
    public void i_fill_in_account_details_and_personal_details() {
        BrowserUtils.clickRadioButton(registerPage.titleRadioButtons,"Mr");
        registerPage.signUpPassword.sendKeys(firstName+lastName);

        //Entering date of birth
        BrowserUtils.clickDropDown(registerPage.dayDropDown, Integer.valueOf(faker.number().numberBetween(1,31)));
        BrowserUtils.clickDropDown(registerPage.monthDropDown, Integer.valueOf(faker.number().numberBetween(1,12)));
        BrowserUtils.clickDropDown(registerPage.yearDropDown, String.valueOf(faker.number().numberBetween(1900,2021)));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(registerPage.newslettersCheckbox).perform();

        ( (JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", registerPage.newslettersCheckbox);


        //Entering address information
        registerPage.firstNameInput.sendKeys(firstName);
        registerPage.lastNameInput.sendKeys(lastName);
        registerPage.companyInput.sendKeys(faker.company().name());
        registerPage.addressInput.sendKeys(faker.address().streetAddress());

        //selecting country randomly
        int dropDownSize = BrowserUtils.dropdownOptions_As_STRING(registerPage.countryDropDown).size();
        Random rand = new Random();
        int randomIndex = rand.nextInt(dropDownSize);
        BrowserUtils.clickDropDown(registerPage.countryDropDown, randomIndex);

        registerPage.stateInput.sendKeys(faker.address().state());
        registerPage.cityInput.sendKeys(faker.address().city());
        registerPage.zipCodeInput.sendKeys(faker.address().zipCode());
        registerPage.mobileNumberInput.sendKeys(faker.phoneNumber().cellPhone());
        actions.moveToElement(registerPage.mobileNumberInput).perform();


    }
    @When("I select the checkboxes for newsletter and offers")
    public void i_select_the_checkboxes_for_newsletter_and_offers() {
        registerPage.newslettersCheckbox.click();
    }


    @Then("I verify Logged in as username is visible")
    public void iVerifyLoggedInAsUsernameIsVisible() {
       Assert.assertTrue(registerPage.loginAsUserIsVisible(name) );
    }

    @And("I click {string} link")
    public void iClickContinueLink(String text) {
        registerPage.clickLink(text);

    }

    @Then("I verify Account Deleted! text is visible")
    public void iVerifyAccountDeletedTextIsVisible() {
       Assert.assertTrue(registerPage.accountDeletedText.isDisplayed());
    }

    @When("I click Delete Account link")
    public void iClickDeleteAccountLink() {
        registerPage.deleteAccountLink.click();
    }

    @And("I enter {string} and an already registered {string}")
    public void iEnterAndAnAlreadyRegistered(String name, String email) {
        registerPage.signUpName.sendKeys(name);
        registerPage.signUpEmail.sendKeys(email);
    }
}
