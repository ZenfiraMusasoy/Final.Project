package com.itacademy.finalproject.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SearchTests extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SearchTests.class);


    @Test
    void search() {

        driver.get("https://iticket.az/ru/");
        log.info("Search started");
        WebElement searchButton = driver.findElement(By.cssSelector(".search.ico-btn"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.id("desktop-search"));
        searchInput.sendKeys("TeamGym");

        if (!searchInput.isDisplayed()) {
            System.out.println("Search input field is not present");
        }
    }
}