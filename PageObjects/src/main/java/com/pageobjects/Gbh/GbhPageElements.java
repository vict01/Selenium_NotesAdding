package com.pageobjects.Gbh;

import com.testFramework.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GbhPageElements extends BasePage{

    public GbhPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "note-app")
    public WebElement sighInWithGoogleLink;

    @FindBy(how = How.XPATH, using = "//firebase-app")
    public WebElement firebaseApp;


}
