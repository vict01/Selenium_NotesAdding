package com.pageobjects.Google;

import com.testFramework.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GooglePageMethods extends BasePage {

    public GooglePageMethods(WebDriver driver) {
        super(driver);
    }

     GooglePageData data = new GooglePageData();
     GooglePageElements elements = new GooglePageElements(myDriver);

    public void isGooglePagePresent() {
        waitForElementToBePresent(elements.emailTxt);
        String browserTitle = myDriver.getTitle() ;
        assert browserTitle.contains(data.getGoogleTittleUrl());
    }

    public void setEmailAddress(String emailAddress) {
        waitForElementToBeLoaded(elements.emailTxt);
        elements.emailTxt.sendKeys(emailAddress);
    }

    public void verifyEmailAddress(String text) {
        String emailValue = elements.emailTxt.getAttribute("value");
        assert emailValue.contains(text);
    }

    public void pressNextEmail() {
        waitForElementToBeLoaded(elements.emailNextBtn);
        elements.emailNextBtn.click();
        waitForElementToBeLoaded(elements.passwordTxt);
    }

    public void setPassword(String password) {
        waitForElementToBeLoaded(elements.passwordTxt);
        elements.passwordTxt.sendKeys(password);
    }

    public void verifyPassword(String text) {
        String passwordValue = elements.passwordTxt.getAttribute("value");
        assert passwordValue.contains(text);
    }

    public void pressNextPassword() {
        waitForElementToBeLoaded(elements.passwordNextBtn);
        elements.passwordNextBtn.click();
    }

    public void clickHaveYouForgottenYourEmail() {
        waitForElementToBePresent(elements.emailTxt);
        elements.emailTxt.sendKeys(Keys.TAB);
        elements.haveU4gottenYourEmail.sendKeys(Keys.ENTER);
    }


}
