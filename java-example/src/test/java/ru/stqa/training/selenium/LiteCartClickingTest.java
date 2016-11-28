package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;



import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Андрей on 28.11.2016.
 */


public class LiteCartClickingTest extends TestBase{


//    @Before
//    public void start(){
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver,10);
//    }


    @Test
    public void FirstTest() {
        driver.navigate().to("http://localhost/litecart/admin/");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //check that menu is presented on the page
        if (areElementsPresent(driver, By.id("box-apps-menu"))) {

            //check that there are some menu items
            if (areElementsPresent(driver, By.cssSelector("ul#box-apps-menu > li"))) {
                List<WebElement> elements = driver.findElements(By.cssSelector("ul#box-apps-menu > li"));

                //for each menu item make a click action
                for (int i = 1; i <= elements.size(); i++) {
                    WebElement element = driver.findElement(By.cssSelector("ul#box-apps-menu > li:nth-of-type(" + i + ")"));
                    element.click();

                    //check that there are some subelements for each item
                    if (areElementsPresent(driver, By.cssSelector("li#app-.selected li"))) {
                        List<WebElement> SubElements = driver.findElements(By.cssSelector("li#app-.selected li"));

                        //for each subitem make click action
                        for(int j = 1; j <= SubElements.size(); j++){
                            WebElement SubElement = wait.until(presenceOfElementLocated(By.cssSelector("li#app-.selected li:nth-of-type(" + j + ")")));
                            SubElement.click();
                            Assert.assertNotNull(driver.getTitle());
                        }
                    }
                }
            }
        }

    }

    @After
    public void stop(){
//        driver.quit();
//        driver = null;
    }

}
