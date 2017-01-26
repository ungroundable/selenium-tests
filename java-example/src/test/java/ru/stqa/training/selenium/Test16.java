package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Created by Андрей on 26.01.2017.
 */
public class Test16 {
        public static final String USERNAME = "andreydmitriev2";
        public static final String AUTOMATE_KEY = "1RaSTjYyuTRZKeuKjDXZ";
        public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

        public static void main(String[] args) throws Exception {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "chrome");
            caps.setCapability("browserstack.debug", "true");
            caps.setCapability("build", "First build");

            WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
            driver.get("http://www.google.com");
            WebElement element = driver.findElement(By.name("q"));

            element.sendKeys("BrowserStack");
            element.submit();

            System.out.println(driver.getTitle());
            driver.quit();

        }
}