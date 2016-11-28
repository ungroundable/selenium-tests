package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;
/**
 * Created by Андрей on 28.11.2016.
 */
public class Test8 extends TestBase{


    @Test
    public void CheckSticker() {
        driver.navigate().to("http://localhost/litecart/");

        //chapters Most Popular, Campaigns, Latest Products
        List<WebElement> products = driver.findElements(By.cssSelector(".content .box .product"));

        for(WebElement element:products){
            assertTrue(isOneElementPresent(element, By.cssSelector(".sticker new")));
        }

    }

}
