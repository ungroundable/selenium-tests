package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


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

        wait.until(presenceOfElementLocated(By.xpath("//a[contains(text(),'Russian Federation')]/../..")));
        WebElement rowToFind = driver.findElement(By.xpath("//a[contains(text(),'Russian Federation')]/../.."));
        rowToFind.findElement(By.cssSelector(".fa-pencil")).click();

        wait.until(presenceOfElementLocated(By.cssSelector("#content>form")));
        List<WebElement> linksArray = driver.findElements(By.cssSelector(".fa.fa-external-link"));

        int linkNumber = linksArray.size();
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();

        for (WebElement element: linksArray
             ) {
            element.click();
            String newWindow = wait.until(thereIsWindowOtherThen(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }

    }


}
