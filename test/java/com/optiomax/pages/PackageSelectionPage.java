package com.optiomax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PackageSelectionPage extends BasePage {
    
    private By freePlan = By.xpath("//div[contains(text(),'Free')]");
    private By starterPlan = By.xpath("//div[contains(text(),'Starter')]");
    private By scalePlan = By.xpath("//div[contains(text(),'Scale')]");
    private By proPlan = By.xpath("//div[contains(text(),'Pro')]");
    private By continueButton = By.xpath("//button[contains(text(),'Continue')]");
    private By backButton = By.xpath("//button[contains(text(),'Back')]");
    
    public void verifyPageTitle() {
        String expectedTitle = "Choose the package that suits your need";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title does not match");
    }

    public void selectPlan(String planName) {
        By planLocator = switch (planName.toLowerCase()) {
            case "free" -> freePlan;
            case "starter" -> starterPlan;
            case "scale" -> scalePlan;
            case "pro" -> proPlan;
            default -> throw new IllegalArgumentException("Invalid plan name: " + planName);
        }; 

        waitForElementToBeClickable(planLocator);
        driver.findElement(planLocator).click();
    }

    public void clickContinue() {
        waitForElementToBeClickable(continueButton);
        driver.findElement(continueButton).click();
    }

    public void clickBack() {
        waitForElementToBeClickable(backButton);
        driver.findElement(backButton).click();
    }

    public void verifyContinueButtonDisabled() {
        WebElement button = driver.findElement(continueButton);
        Assert.assertFalse(button.isEnabled(), "Continue button should be disabled when no plan is selected");
    }
    
}



