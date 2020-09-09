package com.test.automationpractice;

import com.pageobjects.Gbh.GbhPageData;
import com.pageobjects.Gbh.GbhPageMethods;
import com.testFramework.core.BaseTest;
import org.junit.*;

public class NotesMaintenance extends BaseTest {

    GbhPageMethods gbhMethods;
    GbhPageData data;
    LoginAndLogoutTest loginAndLogoutTest;

    @Before
    public void prepare() {
        gbhMethods = new GbhPageMethods(getDriver());
        data = new GbhPageData();
        loginAndLogoutTest = new LoginAndLogoutTest();
    }

    @After
    public void closure() {
        gbhMethods.refreshPage();
        gbhMethods.waitUntilPageIsLoaded();
    }

    @Test()
    public void happyPath()  {
        loginAndLogoutTest.prepare();
        loginAndLogoutTest.loginUsingGoogleAccount();
        gbhMethods.clickAddNote();
        gbhMethods.setTitleNote(data.getNoteTitle());
        // Due to the DOM components structure it'll passes only if it's the first note added:
        gbhMethods.verifyContentInNote(data.getNoteTitle());
        gbhMethods.pressTab();
        gbhMethods.setTextNote(data.getNoteText());
        // Due to the DOM components structure it'll passes only if it's the first note added:
        gbhMethods.verifyContentInNote(data.getNoteText());
        gbhMethods.pressTab();
        gbhMethods.pressTab();
        gbhMethods.pressEnter();
    }

    /*  NOTE: If you decide to run separately one of the three following tests below, you'll need to add
        in the first two lines these 2 commands because it's necessary to be logged in the webpage first:
              loginAndLogoutTest.prepare();
              loginAndLogoutTest.loginUsingGoogleAccount();
        The two lines above are not necessary if you run this class completely, that is the four tests together.
    */

    @Test()
    public void testCase_2_notesCreationOnlyWithTitle() {
        gbhMethods.clickAddNote();
        gbhMethods.setTitleNote(data.setNoteTitle("It's necessary to rest"));
        // Due to the DOM components structure, it's only possible to validate the Note Title for the first note added.
        gbhMethods.pressTab();
        gbhMethods.pressTab();
        gbhMethods.pressTab();
        gbhMethods.pressEnter();
    }

    @Test()
    public void testCase_3_notesCreationOnlyWithText() {
        gbhMethods.clickAddNote();
        gbhMethods.pressTab();
        gbhMethods.pressTab();
        gbhMethods.setTextNote(data.setNoteText("If you want to feel well, you must to rest"));
        // Due to the DOM components structure, it's only possible to validate the Note Text for the first note added.
        gbhMethods.pressTab();
        gbhMethods.pressTab();
        gbhMethods.pressEnter();
    }

    @Test()
    public void testCase_4_notesCreationAborted() {
        gbhMethods.clickAddNote();
        gbhMethods.pressTab();
        gbhMethods.pressTab();
        gbhMethods.pressTab();
        gbhMethods.pressEnter();
    }

}
