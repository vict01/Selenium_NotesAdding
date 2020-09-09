package com.pageobjects.Google;

import com.testFramework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePageElements extends BasePage {

    public GooglePageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "identifierId")
    public WebElement emailTxt;

    @FindBy(how = How.ID, using = "identifierNext")
    public WebElement emailNextBtn;

    @FindBy(how = How.NAME, using = "password")
    public WebElement passwordTxt;

    @FindBy(how = How.ID, using = "passwordNext")
    public WebElement passwordNextBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='PrDSKc']/button")
    public WebElement haveU4gottenYourEmail;


}
