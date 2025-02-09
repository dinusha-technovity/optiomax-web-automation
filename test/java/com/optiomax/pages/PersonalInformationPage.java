package com.optiomax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalInformationPage extends BasePage {

    private WebDriver driver;

    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By emailField = By.name("email");
    private By reEnterEmailField = By.name("reenteremail");
    private By passwordField = By.name("password");
    private By reEnterPasswordField = By.name("reenterpassword");
    private By userNameField = By.name("username");
    private By contactNumberField = By.name("contactnumber");
    private By addressField = By.name("address");
    private By continueButton = By.xpath("//button[normalize-space='Continue']"); 
    private By backButton = By.xpath("/button[normalize-space()='Back']"); 
    private By errorMessage = By.className("error-message");
    private By getStartedButton = By.xpath("//button[contains(text(),'Get Started for Free')]");
    private By packageSelection = By.xpath("//div[contains(text(),'Scale')]");

    public PersonalInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPersonalInformation(String firstName, String lastName, String email, String reEnterEmail,
                                        String password, String reEnterPassword, String userName, 
                                        String contactNumber, String address) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(reEnterEmailField).sendKeys(reEnterEmail);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(reEnterPasswordField).sendKeys(reEnterPassword);
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(contactNumberField).sendKeys(contactNumber);
        driver.findElement(addressField).sendKeys(address); 
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
    
    public void clickBack() {
    	driver.findElement(backButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public void selectPackage() throws InterruptedException {
    	driver.findElement(getStartedButton).click();
    	Thread.sleep(3000);
    	driver.findElement(packageSelection).click();
    }
    
}
