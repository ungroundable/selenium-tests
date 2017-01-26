package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Андрей on 26.01.2017.
 */
public class Test15{


    @Test
    public void remoteDriver() throws MalformedURLException {
        WebDriver rdriver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), DesiredCapabilities.firefox());
        rdriver.get("http://www.google.com");
        rdriver.quit();
    }

}
