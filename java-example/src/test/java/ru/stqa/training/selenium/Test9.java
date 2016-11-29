package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Андрей on 29.11.2016.
 */
public class Test9 extends TestBase {


    @Test
    public void CountrySortTest() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        String [] ArrayBeforeSort = new String[]{};
        String [] ArrayAfterSort = new String[]{};
        //all rows list
        List<WebElement> rows = driver.findElements(By.cssSelector(".row"));


        for(WebElement row:rows){
            ArrayBeforeSort;
        }


    }

}
