package com.itacademy.finalproject.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test
    void search() {

        driver.get("https://iticket.az/ru/");

        WebElement searchButton = driver.findElement(By.cssSelector(".search.ico-btn"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.id("desktop-search"));
        searchInput.sendKeys("TeamGym");

        if (!searchInput.isDisplayed()) {
            System.out.println("Search input field is not present");
        }
    }
}