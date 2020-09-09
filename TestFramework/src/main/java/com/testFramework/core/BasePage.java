package com.testFramework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private static final int TIMEOUT = 8;
    private static final int PAUSE = 4;
    private static final int POLLING = 100;

    protected WebDriver myDriver;
    private final WebDriverWait wait;
    private final Actions act;

    public BasePage(WebDriver driver) {
        this.myDriver = driver;
        act = new Actions(driver);
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void maximiseWindow() {
        myDriver.manage().window().maximize();
    }

    public void refreshPage() {
        String currentPage = myDriver.getCurrentUrl();
        myDriver.get(currentPage);
    }

    protected void waitForElementToBeLoaded(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToBePresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }

    protected void waitForTextToBePresent(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeLocated(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    public void pressTab() {
        act.sendKeys(Keys.chord(Keys.TAB)).build().perform();
    }

    public void pressEnter() {
        act.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
    }

    public void waitUntilPageIsLoaded() {
        try {
            TimeUnit.SECONDS.sleep(PAUSE);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }


}
