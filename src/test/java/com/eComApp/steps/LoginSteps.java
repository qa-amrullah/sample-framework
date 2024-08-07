package com.eComApp.steps;

import com.eComApp.pages.RegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    RegisterPage registerPage = new RegisterPage();
    @When("I enter the correct {string}  and {string}")
    public void i_enter_the_correct_and(String email, String password) {
        registerPage.loginEmail.sendKeys(email);
        registerPage.loginPassword.sendKeys(password);

    }
    @Then("I verify Logged in as {string} is visible")
    public void i_verify_logged_in_as_is_visible(String username) {
        Assert.assertTrue(registerPage.loginAsUserIsVisible(username) );
    }

    @When("I enter the wrong email address and password")
    public void iEnterTheWrongEmailAddressAndPassword() {
        registerPage.loginEmail.sendKeys("incorrect@example.com");
        registerPage.loginPassword.sendKeys("test123");
    }
}
