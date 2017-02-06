package ru.stqa.training.selenium;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


/**
 * Created by Андрей on 06.02.2017.
 */
public class Test18 {


    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;
    public BrowserMobProxy proxy;

    public ExpectedCondition<String> thereIsWindowOtherThen(Set<String> oldWindows){
        return new ExpectedCondition<String>(){
            public String apply(WebDriver driver){
                Set<String> handels = driver.getWindowHandles();
                handels.removeAll(oldWindows);
                return handels.size()>0? handels.iterator().next() : null;
            }
        };
    }

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }


        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);





        driver = new ChromeDriver(capabilities);
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


    @Test
    public void ProxyTest(){
        proxy.newHar();
        driver.get("http://www.google.com");
        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + " : " + l.getRequest().getUrl()));


    }

}
