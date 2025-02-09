package com.optiomax.tests;

import org.testng.annotations.Test;

import com.optiomax.pages.InviteUsersPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InviteUsersTest {

    private WebDriver driver;
    private InviteUsersPage inviteUsersPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        inviteUsersPage = new InviteUsersPage(driver);
    }

    @Test(priority = 1)
    public void testAddValidUser() {
        inviteUsersPage.enterEmail(0, "johndoe@example.com");
        inviteUsersPage.toggleAdmin(0);
        inviteUsersPage.clickSubmit();
        Assert.assertEquals(inviteUsersPage.getPageTitle(), "Success Page");
    }

    @Test(priority = 2)
    public void testAddInvalidEmail() {
        inviteUsersPage.enterUserName(0, "Jane Doe");
        inviteUsersPage.enterEmail(0, "jane.doe@invalid");
        inviteUsersPage.clickSubmit();
        Assert.assertNotEquals(inviteUsersPage.getPageTitle(), "Success Page");
    }

    @Test(priority = 3)
    public void testAddMultipleUsers() {
        inviteUsersPage.enterUserName(0, "User1");
        inviteUsersPage.enterEmail(0, "user1@example.com");
        inviteUsersPage.toggleAdmin(0);

        inviteUsersPage.clickAddRemove(1);
        inviteUsersPage.enterUserName(1, "User2");
        inviteUsersPage.enterEmail(1, "user2@example.com");
        inviteUsersPage.toggleAccountPerson(1);

        inviteUsersPage.clickSubmit();
        Assert.assertEquals(inviteUsersPage.getPageTitle(), "Success Page");
    }

    @Test(priority = 4)
    public void testRemoveUserRow() {
        int initialRows = inviteUsersPage.getNumberOfRows();
        inviteUsersPage.clickAddRemove(0); 
        int finalRows = inviteUsersPage.getNumberOfRows();
        Assert.assertEquals(finalRows, initialRows - 1);
    }

    @Test(priority = 5)
    public void testEmptyFieldsValidation() {
        inviteUsersPage.clickSubmit();
    }

    @Test(priority = 6)
    public void testNavigateBack() {
        inviteUsersPage.clickBack();
        Assert.assertNotEquals(inviteUsersPage.getPageTitle(), "Invite Users");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    
}

