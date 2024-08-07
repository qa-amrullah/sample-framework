package com.eComApp.pages;

import com.eComApp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage  {
    public ContactUsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Page elements and methods for Contact Us page
    @FindBy(xpath = "//input[@data-qa='name']")
    public WebElement nameInput;


    @FindBy(xpath = "//input[@data-qa='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@data-qa='subject']")
    public WebElement subjectInput;

    @FindBy(xpath = "//textarea[@data-qa='message']")
    public WebElement messageInput;

    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement uploadFileInput;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    public WebElement submitButton;


}
