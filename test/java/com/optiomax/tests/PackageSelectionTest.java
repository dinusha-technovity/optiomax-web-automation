package com.optiomax.tests;

import org.testng.annotations.*;

import com.optiomax.pages.BasePage;
import com.optiomax.pages.PackageSelectionPage;

public class PackageSelectionTest extends BasePage {
    
    PackageSelectionPage packageSelection;

    @BeforeClass
    public void setUp() {
        openUrl("http://optiomax.com/");
        packageSelection = new PackageSelectionPage();
    }

    @Test(priority = 1, description = "Verify package selection page title")
    public void testPageTitle() {
        packageSelection.verifyPageTitle();
    }

    @Test(priority = 2, description = "Verify that 'Continue' button is disabled when no plan is selected")
    public void testContinueButtonDisabled() {
        packageSelection.verifyContinueButtonDisabled();
    }

    @Test(priority = 3, description = "Select Free plan and continue")
    public void testSelectFreePlan() {
        packageSelection.selectPlan("Free");
        packageSelection.clickContinue();
    }

    @Test(priority = 4, description = "Select Starter plan and continue")
    public void testSelectStarterPlan() {
        packageSelection.selectPlan("Starter");
        packageSelection.clickContinue();
    }

    @Test(priority = 5, description = "Select Scale plan and continue")
    public void testSelectScalePlan() {
        packageSelection.selectPlan("Scale");
        packageSelection.clickContinue();
    }

    @Test(priority = 6, description = "Select Pro plan and continue")
    public void testSelectProPlan() {
        packageSelection.selectPlan("Pro");
        packageSelection.clickContinue();
    }

    @Test(priority = 7, description = "Click back button and verify navigation")
    public void testBackButton() {
        packageSelection.clickBack();
        packageSelection.verifyPageTitle();
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}


