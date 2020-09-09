package com.test.automationpractice;

import com.pageobjects.Gbh.GbhPageMethods;
import com.pageobjects.Google.GooglePageData;
import com.pageobjects.Google.GooglePageMethods;
import com.testFramework.core.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class LoginAndLogoutTest extends BaseTest {

    GbhPageMethods gbhMethods;
    GooglePageMethods googleMethods;
    GooglePageData googleData;

    @Before
    public void prepare() {
        gbhMethods = new GbhPageMethods(getDriver());
        googleMethods = new GooglePageMethods(getDriver());
        googleData = new GooglePageData();
    }

    @Test()
    public void loginUsingGoogleAccount()  {
        gbhMethods.openGbhPage();
        gbhMethods.isGbhPagePresent();
        gbhMethods.clickOnSignInWithGoogle();
        googleMethods.isGooglePagePresent();
        googleMethods.setEmailAddress(googleData.getGoogleEmail());
        googleMethods.verifyEmailAddress(googleData.getGoogleEmail());
        googleMethods.pressNextEmail();
        googleMethods.setPassword(googleData.getGooglePassword());
        googleMethods.verifyPassword(googleData.getGooglePassword());
        googleMethods.pressNextPassword();
        gbhMethods.areWeLoggedIn();
    }

    @Test()
    public void logOutOfGbhPage()  {
        gbhMethods.areWeLoggedIn();
        gbhMethods.logout();
        gbhMethods.areWeLoggedOut();
    }


}