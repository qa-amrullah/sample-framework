package com.eComApp.pages;

import com.eComApp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends BasePage{
    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@data-qa='signup-name']")
    public WebElement signUpName;
    @FindBy(xpath = "//*[@data-qa='signup-email']")
    public WebElement signUpEmail;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement loginEmail;
    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement loginPassword;
    @FindBy(xpath = "//*[@name='title']")
    public List<WebElement> titleRadioButtons;
    @FindBy(xpath = "//*[@data-qa='password']")
    public WebElement signUpPassword;
    @FindBy(id = "days")
    public WebElement dayDropDown;
    @FindBy(id = "months")
    public WebElement monthDropDown;
    @FindBy(id = "years")
    public WebElement yearDropDown;
    @FindBy(id = "newsletter")
    public WebElement newslettersCheckbox;
    @FindBy(id = "first_name")
    public WebElement firstNameInput;
    @FindBy(id = "last_name")
    public WebElement lastNameInput;
    @FindBy(id = "company")
    public WebElement companyInput;

    @FindBy(id = "address1")
    public WebElement addressInput;
    @FindBy(id = "address2")
    public WebElement address2Input;
    @FindBy(id = "country")
    public WebElement countryDropDown;
    @FindBy(id = "state")
    public WebElement stateInput;

    @FindBy(id = "city")
    public WebElement cityInput;

    @FindBy(id = "zipcode")
    public WebElement zipCodeInput;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberInput;
    @FindBy(id = "newsletter")
    public WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id='form']/div/div/div/h2/b")
    public WebElement accountDeletedText;

    @FindBy(xpath = "//*[@id='dismiss-button']/div/svg")
    public WebElement dismissButton;

    @FindBy(xpath = "//a[.=' Delete Account']")
    public WebElement deleteAccountLink;

    public boolean loginAsUserIsVisible(String username) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//b[text()='" + username + "']"));
        return element.isDisplayed();
    }








}
