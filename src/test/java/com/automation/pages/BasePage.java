package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Signup / Login")
    public WebElement signUpLoginLink;


    public void clickButton(String text) {
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[normalize-space(.)='" + text + "']"));

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", button);
    }

    public void clickLink(String text) {
        WebElement link = Driver.getDriver().findElement(By.xpath("//a[normalize-space(text())='"+text+"']"));

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", link);
    }
}
