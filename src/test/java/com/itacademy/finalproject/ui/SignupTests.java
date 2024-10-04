package com.itacademy.finalproject.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class SignupTests extends BaseTest {


    @Test
    void authPage() throws InterruptedException {
        driver.get("https://iticket.az/ru/");

        WebElement authButton = driver.findElement(By.cssSelector(".profile.ico-btn"));
        authButton.click();

        Thread.sleep(2000L);
        WebElement signupButton = driver.findElement(By.cssSelector(".modal-footer a"));
        signupButton.click();

        WebElement nameInput = driver.findElement(By.name("first_name"));
        if(!nameInput.isDisplayed()){
            System.out.println("Name input field is not present");
        }
        nameInput.sendKeys("Zenfira");

        WebElement lastnameInput = driver.findElement(By.name("last_name"));
        if(!lastnameInput.isDisplayed()){
            System.out.println("Lastname input field is not present");
        }
        lastnameInput.sendKeys("Musasoy");

        WebElement mobileInput = driver.findElement(By.name("mobile"));
        if(!mobileInput.isDisplayed()){
            System.out.println("Mobile input field is not present");
        }
        mobileInput.sendKeys("0552050784");

        WebElement emailInput = driver.findElement(By.name("email"));
        if(!emailInput.isDisplayed()){
            System.out.println("Email input field is not present");
        }
        emailInput.sendKeys("zenfira.musasoy@gmail.com");

        WebElement passwordInput = driver.findElement(By.cssSelector("#register-modal input[name='password']"));
        if(!passwordInput.isDisplayed()){
            System.out.println("Password input field is not present");
        }
        passwordInput.sendKeys("123456");

        WebElement passwordconfirmInput = driver.findElement(By.name("confirm_password"));
        if(!passwordconfirmInput.isDisplayed()){
            System.out.println("Password confirm input field is not present");
        }
        passwordconfirmInput.sendKeys("123456");

        WebElement submitButton = driver.findElement(By.cssSelector("#register-modal .btn"));
        submitButton.submit();

    }


    @Test
    void checkIfPasswordsIsEquals() throws InterruptedException {

        driver.get("https://iticket.az/ru/");
        WebElement authButton = driver.findElement(By.cssSelector(".profile.ico-btn"));
        authButton.click();


        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement signupButton = driver.findElement(By.cssSelector(".modal-footer a"));
        signupButton.click();

        WebElement nameInput = driver.findElement(By.name("first_name"));
        nameInput.sendKeys("Zenfira");

        WebElement lastnameInput = driver.findElement(By.name("last_name"));
        lastnameInput.sendKeys("Musasoy");

        WebElement mobileInput = driver.findElement(By.name("mobile"));
        mobileInput.sendKeys("0552050784");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("zenfira.musasoy@gmail.com");


        WebElement passwordInput = driver.findElement(By.cssSelector("#register-modal input[name='password']"));
        passwordInput.sendKeys("50");

        WebElement passwordconfirmInput = driver.findElement(By.name("confirm_password"));
        passwordconfirmInput.sendKeys("54321");


        WebElement submitButton = driver.findElement(By.cssSelector("#register-modal .btn"));
        submitButton.click();

        List<WebElement> toastifyMessages = driver.findElements(By.className("toastify"));

        Thread.sleep(2000);
        for (WebElement toastifyText : toastifyMessages) {
            Assert.assertEquals(toastifyText.getText(), "Количество символов в поле пароль должно быть не меньше 8.");
        }

    }

}
