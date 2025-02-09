package com.optiomax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InviteUsersPage extends BasePage {

    private By userNameFields = By.xpath("//input[@class='input-feild w-[220px]']");
    private By emailFields = By.xpath("//input[@class='input-feild']");
    private By adminToggleButtons = By.xpath("//input[@type='checkbox' and @name='Admin']");
    private By accountPersonToggleButtons = By.xpath("//input[@type='checkbox' and @name='Account Person']");
    private By addRemoveButtons = By.xpath("//button[contains(@class, 'add-remove-button')]");
    private By submitButton = By.xpath("//button[normalize-space()='Submit']");
    private By backButton = By.xpath("//button[normalize-space()='Back']");
    
    public InviteUsersPage(WebDriver driver) {
        super();
    }

    public void enterUserName(int index, String name) {
        List<WebElement> userNameInputs = driver.findElements(userNameFields);
        userNameInputs.get(index).sendKeys(name);
    }

    public void enterEmail(int index, String email) {
        List<WebElement> emailInputs = driver.findElements(emailFields);
        emailInputs.get(index).sendKeys(email);
    }

    public void toggleAdmin(int index) {
        List<WebElement> adminToggles = driver.findElements(adminToggleButtons);
        adminToggles.get(index).click();
    }

    public void toggleAccountPerson(int index) {
        List<WebElement> accountPersonToggles = driver.findElements(accountPersonToggleButtons);
        accountPersonToggles.get(index).click();
    }

    public void clickAddRemove(int index) {
        List<WebElement> addRemoveBtns = driver.findElements(addRemoveButtons);
        addRemoveBtns.get(index).click();
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void clickBack() {
        driver.findElement(backButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public int getNumberOfRows() {
        return driver.findElements(userNameFields).size();
    }
    
}
