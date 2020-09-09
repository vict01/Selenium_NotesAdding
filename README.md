# Log in to the GBH QA Onboarding Test Web Page using Google Account and Perform Notes Adding in this page.
## This is the test automation framework designed with the purpose of allowing other QA Engineers to be able to create test cases efficiently and easier.


## Components and tools used:
In this framework we used different components, which we break them down below with its respective descriptions:
```
1. Java: The programing language to coding and build the test logic.
2. Selenium web-Driver: Selenium is the framework used to automate the actions in the browser and locate elements.
   In this case, we use Chrome as browser and Chrome-Driver as driver.
3. JUnit: Is the framework to create, organize and execute test.
4. Maven: Is the software applications that allows packaging and manage the dependencies.
```

## Requirements:
* JDK 14
* Having installed chrome browser version 85 
  - If you have other than version 85 of chrome browser, you can download the corresponding Chrome Driver here:
    https://chromedriver.chromium.org/downloads
  - Then place it in: ""..\\TestFramework\\src\\" replacing the existing version there.
* The rest of the requirements will be set automatically by Maven when you load the project,
  so please wait for a few of minutes while Maven loads and sets dependencies.
  - You can see the loading progress in the status bar of you IDE in the bottom. 

## Framework Structure
The framework is based on Page Object model. There are three modules:
* TestFramework: Contains the base for the framework in terms of components used by other classes such as pages to be automated and tests to be ran.
* PageObjects:Contains the packages and classes corresponding to each page to be automated or used during the tests.
  This module in turn contains a package for each group of classes of the pages to be automated. Whose distribution consists of:
  - Data: All data to be used in general terms for its corresponding page.
  - Elements: All web elements to be used in general terms for its corresponding page.
  - Methods:  All methods to be used in general terms for its corresponding page.

* RegressionTests: Contains the tests to be ran, and the test suite to run all tests together at once.

##### There are four POM.xml, one for each module and one for the entire project, this latter works as father of each modules in terms of inheritance.  


## Test Scope:
#### Explanation:
Within the module RegressionTests there are three java classes: LoginAndLogoutTest, NotesMaintenance and TestSuiteRunner.
* Within LoginAndLogoutTest class there are 2 tests or scenarios: Log in and Log out
* Within NotesMaintenance class there re 4 tests o scenario: the happy path and different ways to add a note.
* TestSuiteRunner class contains the set of both testing. That is, it allows us to run both previous classes together at once.


## Instructions to run the tests:
####First of all:
```
1. In this framework Go to: PageObjects/src/main/java/com.pageobjects/Google 
2. Open the class "GooglePageData.java "
3. In the variables "googleEmail" and "googlePassword" place the credentials with which you want to run the tests.
4. Save changes
5. As not to delete your browser cookies in order to avoid authentication issues, 
   please log out your google account in your browser if you're already logged in.

```

### To run all tests together at once:
1. Go to RegressionTests module
2. Open TestSuiteRunner classes
3. Run this class by the 'Execute option/button' provided either by Junit or your IDE.
   - If you're using IntelliJ IDE, next to the left of the statement "public class {Class Name}" you can locate the run symbol which works as a button.
4. Pay attention while test runs in the browser.
5. Once test finish to running, in the panel and dashboard of Junit in the IDE, you can see the testing summary report.

### To run a specific class with all its tests inside:
1. Go to RegressionTests module
2. Open any class other than TestSuiteRunner
3. Run this class by the 'Execute option/button' provided either by Junit or your IDE.
   - If you're using IntelliJ IDE, next to the left of the statement "public class {Class Name}" you can locate the run symbol which works as a button.
4. Pay attention while test runs in the browser.
5. Once test finish to running, in the panel and dashboard of Junit in the IDE, you can see the testing summary report.

### To run a specific test of any class:
1. Go to RegressionTests module
2. Open any class other than TestSuiteRunner
3. Run ant test of the class by the 'Execute option/button' provided either by Junit or your IDE.
   - If you're using IntelliJ IDE, next to the left of the statement "public void {Test Method Name}" you can locate the run symbol which works as a button.
4. Pay attention while test runs in the browser.
5. Once test finish to running, in the panel and dashboard of Junit in the IDE, you can see the testing summary report.

### To omit a specific test while running a set of test as the two first way mentioned above:
1. Go to the test you want to skip.
2. Replace the tag "@Test()" by "@Ignore"
3. Run your set of tests as explained before.

### To prevent from the browser closes after the test finishes running
1. Go to: TestFramework/src/main/java/com.testFramework.core
2. Open the class "BaseTest.java"
3. In the method "afterSuite" comment the line "closeBrowser();"
4. Save changes
3. Run your test how it suits you best as explained before.
