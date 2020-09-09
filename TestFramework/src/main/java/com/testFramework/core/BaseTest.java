package com.testFramework.core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public static void beforeSuite() {
        try {
            String driverPath = "..\\TestFramework\\src\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert driver != null;
    }

    @AfterClass
    public static void afterSuite() {
        closeBrowser();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }

}
