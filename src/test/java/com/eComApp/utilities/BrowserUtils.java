package com.eComApp.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    /*
This Method will accept int (seconds)
and execute Thread.sleep method for given duration
Arg: int second
*/
    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }



    /*
    When this method is called it switch window and verify title.
        Method info:
        • Name: switchWindowAndVerify
        • Return type: void
        • Arg1: WebDriver
        • Arg2: String expectedInUrl
        • Arg3: String expectedTitle
    */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {
        for (String eachHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(eachHandle);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
            Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

        }

    }

    public static boolean isVisible(String text){
        return Driver.getDriver().findElement(By.xpath("//*[normalize-space(text())='"+text+"']")).isDisplayed();
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }
    public static void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void verifyTitleContains(String expectedInTitle) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    public static void waitForInvisibilityOf(WebElement target) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitForTitleIs(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static List<String> dropdownOptions_As_STRING(WebElement dropdown) {
        Select productDropDown = new Select(dropdown);
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement eachOption : productDropDown.getOptions()) {
            actualOptionsAsString.add(eachOption.getText());
        }

        return actualOptionsAsString;
    }

    public static void clickDropDown(WebElement dropdown, String visibleTextValue) {
        Select productDropDown = new Select(dropdown);
        productDropDown.selectByVisibleText(visibleTextValue);
    }

    public static void clickDropDown(WebElement dropdown, int index) {
        Select productDropDown = new Select(dropdown);
        productDropDown.selectByIndex(index);
    }


    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement eachRadioButton : radioButtons) {
            if (eachRadioButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                eachRadioButton.click();
            }
        }
    }


}
