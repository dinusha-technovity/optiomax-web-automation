package com.optiomax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By errorMessage = By.className("text-red-500 text-sm mt-1");
    private By keepMeLoggedInCheckbox = By.name("remember");
    private By forgotPasswordLink = By.linkText("Forgot Password");
    
    public LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public void clickKeepMeLoggedIn() {
        driver.findElement(keepMeLoggedInCheckbox).click();
    }
    
    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }
    
}
