package com.itacademy.finalproject.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CartTests extends BaseTest {

    @Test
    void addToCartTest() throws InterruptedException {
        driver.get("https://iticket.az/ru/products");

        // Уменьшаем зум до 75%
        // https://stackoverflow.com/questions/15024756/selenium-webdriver-zoom-in-out-page-content
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.75'");

        // Выбрать все продукты
        List<WebElement> items = driver.findElements(By.className("product-list-item"));
        for (WebElement item : items) {
            // Кликнуть на каждый из них, пока не найдется товар в стоке
            item.findElement(By.cssSelector(".info .cursor-pointer")).click();
            Thread.sleep(1000L);
            WebElement toastify = driver.findElement(By.className("toastify"));
            // Проверить есть ли продукт и был ли он добавлен в корзину
            if ("Продукт добавлен в корзину".equals(toastify.getText())) {
                // Выполнить тест
                Assert.assertEquals(toastify.getText(), "Продукт добавлен в корзину");
                break;
            }
        }
    }


    @Test
    void cart() throws InterruptedException {

        driver.get("https://iticket.az/ru/products");

        // Уменьшаем зум до 75%
        // https://stackoverflow.com/questions/15024756/selenium-webdriver-zoom-in-out-page-content
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.75'");

        // Выбрать все продукты
        List<WebElement> items = driver.findElements(By.className("product-list-item"));
        for (WebElement item : items) {
            // Кликнуть на каждый из них, пока не найдется товар в стоке
            item.findElement(By.cssSelector(".info .cursor-pointer")).click();
            Thread.sleep(1000L);
            WebElement toastify = driver.findElement(By.className("toastify"));
            // Проверить есть ли продукт и был ли он добавлен в корзину
            if ("Продукт добавлен в корзину".equals(toastify.getText())) {
                break;
            }
        }

        Thread.sleep(1000L);
        WebElement product = driver.findElement(By.cssSelector(".product-name"));
        String productName = product.getText();

        Thread.sleep(2000L);
        WebElement cartButton = driver.findElement(By.cssSelector("button.cart.ico-btn"));
        cartButton.click();

        WebElement productNameInCart = driver.findElement(By.cssSelector(".cart-page .ticket-list-item .event-name"));
        Assert.assertEquals(productName, productNameInCart.getText());
    }

}