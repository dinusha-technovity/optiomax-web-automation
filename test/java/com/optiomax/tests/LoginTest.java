package com.optiomax.tests;

import org.testng.annotations.Test;

import com.optiomax.pages.BasePage;
import com.optiomax.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest extends BasePage {
	
	private BasePage basePage;
    private LoginPage loginPage;
    
    @BeforeMethod
    public void setUp() {
    	basePage.openUrl(""); 
        loginPage = new LoginPage(driver);
    }
    
    @Test(priority = 1)
    public void testValidLogin() {
        loginPage.enterEmail("ruvinyafernando@gmail.com");
        loginPage.enterPassword("Ruvinya@123");
        loginPage.clickSignIn();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed!");
    }
    
    @Test(priority = 2)
    public void testInvalidLogin() {
        loginPage.enterEmail("invalid@gmail.com");
        loginPage.enterPassword("wrongPassword");
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"), "Error message not displayed!");
    }
    
    @Test(priority = 3)
    public void testEmptyFields() {
        loginPage.clickSignIn();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Email and Password are required"), "Validation message missing!");
    }
    
    @Test(priority = 4)
    public void testKeepMeLoggedIn() {
        loginPage.enterEmail("ruvinyafernando@gmail.com");
        loginPage.enterPassword("Ruvinya@123");
        loginPage.clickKeepMeLoggedIn();
        loginPage.clickSignIn();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Keep me logged in failed!");
    }
    
    @Test(priority = 5)
    public void testForgotPasswordLink() {
        loginPage.clickForgotPassword();
        Assert.assertTrue(driver.getCurrentUrl().contains("forgot-password"), "Forgot password link not working!");
    }
    
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
    
}