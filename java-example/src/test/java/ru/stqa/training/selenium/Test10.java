package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Андрей on 05.12.2016.
 */
public class Test10 extends TestBase {


    @Test
    public void CompainDuckChecker() {

        driver.navigate().to("http://localhost/litecart/");

        //find first commodity in Campaigns and save its parameters to compare later
        WebElement product = driver.findElement(By.cssSelector("#box-campaigns .product"));

        //save product name and prices
        String originalName = product.findElement(By.cssSelector(".name")).getAttribute("textContent");
        String originalOldPrice = product.findElement(By.cssSelector(".regular-price")).getAttribute("textContent");
        String originalNewPrice = product.findElement(By.cssSelector(".campaign-price")).getAttribute("textContent");

        //save product price appearance
        String originalOldPriceColor = product.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String originalOldPriceStrikeout = product.findElement(By.cssSelector(".regular-price")).getCssValue("line-through");
        String originalOldPriceSize = product.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");



    }
}
