package com.optiomax.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LandingPage extends BasePage {
    
    private By headingText = By.xpath("//h1[contains(text(),'Integrate. Automate. Streamline.')]");
    private By getStartedButton = By.xpath("//button[contains(text(),'Get Started for Free')]");
    private By companyLogo = By.xpath("//img[@alt='Logo']");

    public void verifyHeadingText() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(headingText));
        Assert.assertTrue(heading.isDisplayed(), "Heading text is not displayed!");
    }

    public void verifyButtonDisplayed() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedButton));
        Assert.assertTrue(button.isDisplayed(), "Get Started button is not displayed!");
    }

    public void clickGetStarted() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getStartedButton));
        button.click();
    }

    public void verifyLogoClickable() {
        WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(companyLogo));
        Assert.assertTrue(logo.isDisplayed(), "Company logo is not clickable!");
    }

    public void verifyButtonRedirect(String expectedUrl) {
        clickGetStarted();
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl), "Redirection URL is incorrect!");
    }

    public void simulateSlowNetwork() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    
}





