package com.optiomax.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.optiomax.pages.BusinessInformationPage;

public class BusinessInformationTest {

    private WebDriver driver;
    private BusinessInformationPage businessInfoPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/breadscrums/eclipse-workspace/OptiomaxWebAutomation/Resource Files/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        businessInfoPage = new BusinessInformationPage(driver);
    }
    
    @Test(priority = 1)
    public void testValidBusinessInformation() {
        businessInfoPage.selectCompanyAccountType();
        businessInfoPage.enterCompanyName("Tech Innovators Inc.");
        businessInfoPage.enterCompanyEmail("contact@techinnovators.com");
        businessInfoPage.enterContactPerson("John Doe");
        businessInfoPage.enterContactNumber("1234567890");
        businessInfoPage.enterCompanyAddress("123 Tech Street");
        businessInfoPage.enterCompanyWebsite("https://techinnovators.com");
        businessInfoPage.clickContinue();
    }

    @Test(priority = 2)
    public void testInvalidEmailFormat() {
        businessInfoPage.selectCompanyAccountType();
        businessInfoPage.enterCompanyName("Tech Innovators Inc.");
        businessInfoPage.enterCompanyEmail("invalid-email");
        businessInfoPage.enterContactPerson("John Doe");
        businessInfoPage.enterContactNumber("1234567890");
        businessInfoPage.enterCompanyAddress("123 Tech Street");
        businessInfoPage.enterCompanyWebsite("https://techinnovators.com");
        businessInfoPage.clickContinue();
    }

    @Test(priority = 3)
    public void testEmptyMandatoryFields() {
        businessInfoPage.selectCompanyAccountType();
        businessInfoPage.enterCompanyName("");
        businessInfoPage.enterCompanyEmail("");
        businessInfoPage.enterContactPerson("");
        businessInfoPage.enterContactNumber("");
        businessInfoPage.enterCompanyAddress("");
        businessInfoPage.enterCompanyWebsite("");
        businessInfoPage.clickContinue();
        
    }

    @Test(priority = 4)
    public void testInvalidContactNumber() {
        businessInfoPage.selectCompanyAccountType();
        businessInfoPage.enterCompanyName("Tech Innovators Inc.");
        businessInfoPage.enterCompanyEmail("contact@techinnovators.com");
        businessInfoPage.enterContactPerson("John Doe");
        businessInfoPage.enterContactNumber("ABC123");
        businessInfoPage.enterCompanyAddress("123 Tech Street");
        businessInfoPage.enterCompanyWebsite("https://techinnovators.com");
        businessInfoPage.clickContinue();
    }

    @Test(priority = 5)
    public void testSpecialCharactersInCompanyName() {
        businessInfoPage.selectCompanyAccountType();
        businessInfoPage.enterCompanyName("Tech@Innovators!");
        businessInfoPage.enterCompanyEmail("contact@techinnovators.com");
        businessInfoPage.enterContactPerson("John Doe");
        businessInfoPage.enterContactNumber("1234567890");
        businessInfoPage.enterCompanyAddress("123 Tech Street");
        businessInfoPage.enterCompanyWebsite("https://techinnovators.com");
        businessInfoPage.clickContinue();
    }

    @Test(priority = 6)
    public void testMissingCompanyWebsite() {
        businessInfoPage.selectCompanyAccountType();
        businessInfoPage.enterCompanyName("Tech Innovators Inc.");
        businessInfoPage.enterCompanyEmail("contact@techinnovators.com");
        businessInfoPage.enterContactPerson("John Doe");
        businessInfoPage.enterContactNumber("1234567890");
        businessInfoPage.enterCompanyAddress("123 Tech Street");
        businessInfoPage.enterCompanyWebsite("");
        businessInfoPage.clickContinue();
    }

    @Test(priority = 7)
    public void testIndividualAccountTypeFlow() {
        businessInfoPage.selectIndividualAccountType();
        businessInfoPage.enterCompanyName("John Doe");
        businessInfoPage.enterCompanyEmail("john.doe@example.com");
        businessInfoPage.enterContactPerson("John Doe");
        businessInfoPage.enterContactNumber("1234567890");
        businessInfoPage.enterCompanyAddress("123 Elm Street");
        businessInfoPage.enterCompanyWebsite("https://johndoe.com");
        businessInfoPage.clickContinue();
    }
    
    @Test(priority = 7)
    public void testCompanyAccountFlow() {
        businessInfoPage.selectIndividualAccountType();
        businessInfoPage.enterCompanyName("John Doe");
        businessInfoPage.enterCompanyEmail("john.doe@example.com");
        businessInfoPage.enterContactPerson("John Doe");
        businessInfoPage.enterContactNumber("1234567890");
        businessInfoPage.enterCompanyAddress("123 Elm Street");
        businessInfoPage.enterCompanyWebsite("https://johndoe.com");
        businessInfoPage.clickContinue();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
            
}
