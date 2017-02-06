package ru.stqa.training.selenium;

/**
 * Created by Андрей on 28.11.2016.
 */
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.logging.LogType;
import java.util.logging.Level;


import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    public ExpectedCondition<String> thereIsWindowOtherThen(Set<String> oldWindows){
        return new ExpectedCondition<String>(){
            public String apply(WebDriver driver){
                Set<String> handels = driver.getWindowHandles();
                handels.removeAll(oldWindows);
                return handels.size()>0? handels.iterator().next() : null;
            }
        };
    }

    public boolean isElementPresent(By locator){

        try {

            wait.until((WebDriver d)-> d.findElement(locator));
            return true;

        } catch (NoSuchElementException ex){

            return false;

        }

    }

    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    boolean isOneElementPresent(WebElement element, By locator) {
        return element.findElements(locator).size()==1;
    }

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        DesiredCapabilities caps = new DesiredCapabilities();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

//        caps.setCapability(FirefoxDriver.MARIONETTE, false);

//        for Chrome logging
//        driver = new ChromeDriver(cap);


        driver = new ChromeDriver(caps);
        tlDriver.set(driver);
//        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null; }));
    }

    @After
    public void stop() {
        //driver.quit();
        //driver = null;
    }
}
