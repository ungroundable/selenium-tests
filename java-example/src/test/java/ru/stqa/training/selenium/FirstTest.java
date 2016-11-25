package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by Андрей on 23.11.2016.
 */
public class FirstTest {

    private WebDriver driver;
    private WebDriver driver1;
    private WebDriver driver2;

    private WebDriverWait wait;
    private WebDriverWait wait1;
    private WebDriverWait wait2;


    @Before
    public void start(){
        //Chrome
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);

        //IEplorer
        driver1 = new InternetExplorerDriver();
        wait1 = new WebDriverWait(driver1,10);

        //FireFox
        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver2 = new FirefoxDriver(new FirefoxBinary(new File("C://Program Files//Nightly//firefox.exe"))
                ,new FirefoxProfile(),caps);
        System.out.println(((HasCapabilities)driver2).getCapabilities());
        wait2 = new WebDriverWait(driver2,10);

    }


    @Test
    public void FirstTest(){
        driver.navigate().to("https://www.google.ru/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));

        driver1.navigate().to("https://www.google.ru/");
        driver1.findElement(By.name("q")).sendKeys("webdriver");
        driver1.findElement(By.name("btnG")).click();
        wait1.until(titleIs("webdriver - Поиск в Google"));

        driver2.navigate().to("https://www.google.ru/");
        driver2.findElement(By.name("q")).sendKeys("webdriver");
        driver2.findElement(By.name("btnG")).click();
        wait2.until(titleIs("webdriver - Поиск в Google"));
    }


    @After
    public void stop(){
        driver.quit();
        driver = null;

        driver1.quit();
        driver1 = null;

        driver2.quit();
        driver2 = null;
    }
}
