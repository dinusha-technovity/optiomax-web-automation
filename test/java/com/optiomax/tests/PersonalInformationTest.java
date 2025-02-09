package com.optiomax.tests;

import com.optiomax.pages.BasePage;
import com.optiomax.pages.PersonalInformationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PersonalInformationTest {

    private BasePage basePage;
    private WebDriver driver;
    private PersonalInformationPage personalInformationPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        basePage = new BasePage();
        driver = basePage.driver;
        personalInformationPage = new PersonalInformationPage(driver);
        basePage.openUrl("http://optiomax.com/"); 
        personalInformationPage.selectPackage();
    }

    @Test(priority = 1)
    public void testValidPersonalInformation() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "john.doe@example.com", "john.doe@example.com",
                "Password123!", "Password123!", "johndoe", "1234567890", "123 Main St"
        );
        personalInformationPage.clickContinue();
        Assert.assertTrue(driver.getCurrentUrl().contains("businessInformation"),
                "Failed to navigate to the Business Information step.");
    }

    @Test(priority = 2)
    public void testInvalidEmail() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "invalid-email", "invalid-email",
                "Password123!", "Password123!", "johndoe", "1234567890", "123 Main St"
        );
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "Invalid email address",
                "Error message for invalid email did not match.");
    }

    @Test(priority = 3)
    public void testMismatchedPasswords() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "john.doe@example.com", "john.doe@example.com",
                "Password123!", "Password456!", "johndoe", "1234567890", "123 Main St"
        );
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "Passwords do not match",
                "Error message for mismatched passwords did not match.");
    }

    @Test(priority = 4)
    public void testEmptyFields() {
        personalInformationPage.fillPersonalInformation("", "", "", "",
                "", "", "", "", "");
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "All fields are required",
                "Error message for empty fields did not match.");
    }

    @Test(priority = 5)
    public void testShortPassword() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "john.doe@example.com", "john.doe@example.com",
                "123", "123", "johndoe", "1234567890", "123 Main St"
        );
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "Password must be at least 8 characters long",
                "Error message for short password did not match.");
    }

    @Test(priority = 6)
    public void testMissingReEnterEmail() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "john.doe@example.com", "",
                "Password123!", "Password123!", "johndoe", "1234567890", "123 Main St"
        );
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "Please re-enter your email",
                "Error message for missing re-enter email did not match.");
    }

    @Test(priority = 7)
    public void testMissingAddress() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "john.doe@example.com", "john.doe@example.com",
                "Password123!", "Password123!", "johndoe", "1234567890", ""
        );
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "Address is required",
                "Error message for missing address did not match.");
    }

    @Test(priority = 8)
    public void testMissingContactNumber() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "john.doe@example.com", "john.doe@example.com",
                "Password123!", "Password123!", "johndoe", "", "123 Main St"
        );
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "Contact number is required",
                "Error message for missing contact number did not match.");
    }

    @Test(priority = 9)
    public void testInvalidContactNumber() {
        personalInformationPage.fillPersonalInformation(
                "John", "Doe", "john.doe@example.com", "john.doe@example.com",
                "Password123!", "Password123!", "johndoe", "123", "123 Main St"
        );
        personalInformationPage.clickContinue();
        Assert.assertEquals(personalInformationPage.getErrorMessage(), "Invalid contact number",
                "Error message for invalid contact number did not match.");
    }

    @AfterClass
    public void tearDown() {
        basePage.closeBrowser();
    }
    
}
