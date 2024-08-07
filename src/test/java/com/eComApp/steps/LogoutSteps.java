package com.eComApp.steps;

import com.eComApp.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutSteps {
    @Then("I verify that user is navigated to login page")
    public void iVerifyThatUserIsNavigatedToLoginPage() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Login"));
    }
}
