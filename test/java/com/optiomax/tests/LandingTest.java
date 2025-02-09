package com.optiomax.tests;

import org.testng.annotations.*;

import com.optiomax.pages.LandingPage;

public class LandingTest {
    private LandingPage landingPage;

    @BeforeClass
    public void setup() {
    	landingPage = new LandingPage();
    	landingPage.openUrl("http://optiomax.com/");
    }

    @Test(priority = 1, description = "Verify main heading is displayed correctly")
    public void testHeadingText() {
    	landingPage.verifyHeadingText();
    }

    @Test(priority = 2, description = "Verify 'Get Started for Free' button is visible")
    public void testButtonVisibility() {
    	landingPage.verifyButtonDisplayed();
    }

    @Test(priority = 3, description = "Verify 'Get Started' button click redirects correctly")
    public void testButtonRedirect() {
    	landingPage.verifyButtonRedirect("signup");
    }

    @Test(priority = 4, description = "Verify company logo is clickable")
    public void testLogoClick() {
    	landingPage.verifyLogoClickable();
    }

    @Test(priority = 5, description = "Simulate slow network conditions")
    public void testSlowNetwork() {
    	landingPage.simulateSlowNetwork();
    }

    @AfterClass
    public void tearDown() {
    	landingPage.closeBrowser();
    }
}



