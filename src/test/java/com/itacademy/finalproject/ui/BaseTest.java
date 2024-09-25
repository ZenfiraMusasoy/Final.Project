package com.itacademy.finalproject.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    protected String CHROME_DRIVER = "C:\\Users\\Admin\\IdeaProjects\\hw-selenium\\src\\test\\resources\\chromedriver.exe";

    @Ignore
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Ignore
    @AfterMethod
    public void quit() {
        driver.quit();
    }
}

