package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Андрей on 13.01.2017.
 */
public class Test14 extends TestBase{


    @Test
    public void newWindow(){

        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        WebElement rowToFind = driver.findElement(By.xpath("//a[contains(text(),'Russian Federation')]/../.."));
        rowToFind.findElement(By.cssSelector(".fa-pencil")).click();

        WebElement contentElement = driver.findElement(By.cssSelector(".content"));
        List<WebElement> linksArray = driver.findElements(By.cssSelector("[target='_blank']"));

    }


}
