package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Андрей on 01.12.2016.
 */
public class Test9A extends  TestBase{


    @Test
    public void CountrySortTest() {
        driver.navigate().to("http://localhost/litecart/admin/");

        WebElement SubElement = wait.until(presenceOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //Task 9a checking countries sorting
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        //temp array
        ArrayList<String> countries = new ArrayList();
        //all rows list
        SubElement = wait.until(presenceOfElementLocated(By.cssSelector(".row")));
        List<WebElement> countryRows = driver.findElements(By.cssSelector(".row"));
        for (WebElement countryRow : countryRows) {
            //add textContent Property to the temp array
            String countryName = countryRow.findElement(By.cssSelector("a")).getAttribute("textContent");
            countries.add(countryName);
        }

        //creating arrays to check sorting
        String[] countriesBeforeSort = countries.toArray(new String[countries.size()]);
        String[] countriesAfterSort = countries.toArray(new String[countries.size()]);
        Arrays.sort(countriesAfterSort);

        assertArrayEquals(countriesBeforeSort, countriesAfterSort);

        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.cssSelector(".fa-sign-out")).click();
    }//end of Task9a
}
