package com.optiomax.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    public WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}


