package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Андрей on 06.02.2017.
 */
public class Test17 extends TestBase {

    @Test
    public void BrowserLog() {
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=2");

        WebElement SubElement = wait.until(presenceOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int DucksCount = driver.findElements(By.xpath("//a[contains(text(),'Duck')]/..//img/..")).size();
        for(int i=5; i<DucksCount +5; i++){
            driver.findElement(By.cssSelector(".dataTable tr:nth-child(" + i +") a")).click();
            wait.until(presenceOfElementLocated(By.xpath("//*[contains(text(),'Cancel')]")));
            driver.findElement(By.xpath("//*[contains(text(),'Cancel')]")).click();
        }




//        for Chrome deep logging
//        driver.manage().logs().get("performance").forEach(l -> System.out.println(l));

        driver.manage().logs().get("browser").forEach(l -> System.out.println(l));






    }

}
