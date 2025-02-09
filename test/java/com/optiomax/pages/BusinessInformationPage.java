package com.optiomax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusinessInformationPage extends BasePage {

 private By companyTypeIndividual = By.name("individual");
 private By companyTypeCompany = By.name("company");
 private By companyNameField = By.name("ccompanyname");
 private By companyEmailField = By.name("ccompanyemailAddress");
 private By companyContactPersonField = By.name("ccompanycontactNo");
 private By companyContactNumberField = By.name("ccompanycontactpersonnumber");
 private By companyAddressField = By.name("ccompanyAddress");
 private By companyWebsiteField = By.name("ccompanywebsite");
 private By continueButton = By.xpath("//button[normalize-space()='Continue']");
 private By backButton = By.xpath("//button[normalize-space()='Back']");

 public BusinessInformationPage(WebDriver driver) {
     super();
 }

 public void selectIndividualAccountType() {
     driver.findElement(companyTypeIndividual).click();
 }

 public void selectCompanyAccountType() {
     driver.findElement(companyTypeCompany).click();
 }

 public void enterCompanyName(String companyName) {
     driver.findElement(companyNameField).sendKeys(companyName);
 }

 public void enterCompanyEmail(String email) {
     driver.findElement(companyEmailField).sendKeys(email);
 }

 public void enterContactPerson(String contactPerson) {
     driver.findElement(companyContactPersonField).sendKeys(contactPerson);
 }

 public void enterContactNumber(String contactNumber) {
     driver.findElement(companyContactNumberField).sendKeys(contactNumber);
 }

 public void enterCompanyAddress(String address) {
     driver.findElement(companyAddressField).sendKeys(address);
 }

 public void enterCompanyWebsite(String website) {
     driver.findElement(companyWebsiteField).sendKeys(website);
 }

 public void clickContinue() {
     driver.findElement(continueButton).click();
 }
 
 public void clickBack() {
	 driver.findElement(backButton).click();
 }
 
}

