package com.itacademy.finalproject.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SignInTests extends BaseTest {

    @Ignore
    @Test
    void signIn() {
        driver.get("https://iticket.az/ru/");

        WebElement authButton = driver.findElement(By.cssSelector(".profile.ico-btn"));
        authButton.click();

        WebElement emailInput = driver.findElement(By.id("login-email"));
        emailInput.sendKeys("zenfira.musasoy@aist.group");

        WebElement passwordInput = driver.findElement(By.cssSelector("#login-modal input[name='password']"));
        passwordInput.sendKeys("12345678");

        WebElement submitButton = driver.findElement(By.className("btn"));
        submitButton.submit();
    }
}