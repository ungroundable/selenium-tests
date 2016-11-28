package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Андрей on 28.11.2016.
 */


public class LiteCartClickingTest extends TestBase{


    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }


//    @Before
//    public void start(){
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver,10);
//    }


    @Test
    public void FirstTest(){
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        if(areElementsPresent(driver,By.id("box-apps-menu") )){
            if(areElementsPresent(driver,By.cssSelector("ul#box-apps-menu > li") )){
                List<WebElement> elements = driver.findElements(By.cssSelector("ul#box-apps-menu > li"));
                for (WebElement element: elements){
                    element.click();
                }
                System.out.println(elements);

            }
        }
//        WebElement element = driver.findElement(By.id("box-apps-menu"));
//        wait.until(titleIs("webdriver - Поиск в Google"));
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
