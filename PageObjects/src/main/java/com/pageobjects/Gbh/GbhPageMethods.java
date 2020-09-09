package com.pageobjects.Gbh;

import com.testFramework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GbhPageMethods extends BasePage {

    GbhPageData data = new GbhPageData();
    GbhPageElements elements = new GbhPageElements(myDriver);

    public GbhPageMethods(WebDriver driver) {
        super(driver);
    }

    public void openGbhPage() {
        myDriver.get(data.getUrl());
    }

    public void isGbhPagePresent() {
        waitForElementToBePresent(elements.sighInWithGoogleLink);
        String browserTitle = myDriver.getTitle();
        assert browserTitle.contains(data.getGbhTittleUrl());
    }

    public void clickOnSignInWithGoogle() {
        waitForElementToBePresent(elements.sighInWithGoogleLink);
        elements.sighInWithGoogleLink.click();
    }

    public void areWeLoggedIn() {
        waitForElementToBePresent(elements.firebaseApp);
        waitForElementToDisappear(elements.sighInWithGoogleLink);
        assert !elements.sighInWithGoogleLink.isDisplayed();
    }

    public void areWeLoggedOut() {
        waitForElementToBePresent(elements.firebaseApp);
        waitForElementToBePresent(elements.sighInWithGoogleLink);
        assert elements.sighInWithGoogleLink.isDisplayed();
    }

    public void logout() {
        waitUntilPageIsLoaded();
        pressTab();
        pressEnter();
    }

    public void clickAddNote() {
        waitUntilPageIsLoaded();
        pressTab();
        pressTab();
        pressTab();
        pressEnter();
    }

    public void setTitleNote(String tittleNote) {
        WebElement currentElement = myDriver.switchTo().activeElement();
        pressTab();
        currentElement.sendKeys(tittleNote);
    }

    public void setTextNote(String textNote) {
        WebElement currentElement = myDriver.switchTo().activeElement();
        currentElement.sendKeys(textNote);
    }

    public void verifyContentInNote(String text) {
        WebElement currentElement = myDriver.switchTo().activeElement();
        String noteText = currentElement.getText().substring(37);
        assert text.contains(noteText);
    }

    public void loginGbhPage() {
        openGbhPage();
        isGbhPagePresent();
        clickOnSignInWithGoogle();
    }

}
