package com.automation.stepDefinitions;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * In this class we will be able to creat "pre" and "post" condition for ALL the SCENARIOS and even STEPS
 */
public class Hooks {
    /**
     * @Before will be executed before every scenario in the whole project
     */

    //import the @Before coming from io.cucumber.java
    @Before
    public void setupMethod() {

    }

    /**
     * @After will be executed after every scenario in the whole project
     */
    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {//if scenario fails
            //Take screenshot and store it as an array of bytes
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            //Attach the screenshot to our scenario ( as image.png)
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

    @BeforeStep //will execute before all of the steps in all scenarios
    public void setupStep() {
        BrowserUtils.sleep(1);
    }
    @AfterStep //will execute after all of the steps in all scenarios
    public void teardownStep() {
    }
}
