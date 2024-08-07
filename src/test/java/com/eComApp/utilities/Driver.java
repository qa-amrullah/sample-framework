package com.eComApp.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //Create a private constructor to remove the access to creating object outside class

    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    //The WebDriver object is also private because we want to remove access from outside class
    //It's static because we want to use it in static method and it will have only one copy

    public static WebDriver getDriver() {

        //check if the browser type is passed through command line or Jenkins then assign the same otherwise take it from Configuration file

        String browser = "";
        if (System.getProperty("browser") != null) {
            browser = System.getProperty("browser");
        } else {
            browser = ConfigurationReader.getProperty("browser");
        }

        //if driver object does not exist it creates an object of the specific browser and returns it at the end

        if (driverPool.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-notifications");
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                default:
                    throw new IllegalArgumentException("Browser type not supported");
            }
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        /**
         If driver is not null, close the driver and reassign the value to null.
         */
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }

}
