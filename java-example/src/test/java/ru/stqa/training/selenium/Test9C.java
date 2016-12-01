package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Андрей on 29.11.2016.
 */
public class Test9C extends TestBase {


    // beginning of Task 9c
    @Test
    public void GeoZoneSortTest() {

        driver.navigate().to("http://localhost/litecart/admin/");
        WebElement SubElement = wait.until(presenceOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        //temp array
        ArrayList<String> geoZone = new ArrayList();
        //all rows list

        SubElement = wait.until(presenceOfElementLocated(By.cssSelector(".row")));
        List<WebElement> geoZonesRows = driver.findElements(By.cssSelector(".row"));

        //main loop for geoZones
        for(int currentGeoZone=2; currentGeoZone <= geoZonesRows.size()+1; currentGeoZone++){
            String locator = ".dataTable tr.row:nth-child(" + currentGeoZone + ")";
            driver.findElement(By.cssSelector(locator)).click();



        }

        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector(".fa-sign-out")).click();
    }//end of Task 9c

}
