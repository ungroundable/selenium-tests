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
public class Test9 extends TestBase {


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
        driver.findElement(By.name("fa-sign-out")).click();
    }//end of Task9a

    //Task 9b checking regions sorting
    @Test
    public void CountryRegionSortTest(){

        driver.navigate().to("http://localhost/litecart/admin/");

        WebElement SubElement = wait.until(presenceOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        //temp array
        ArrayList<String> countries = new ArrayList();
        //all rows list

        SubElement = wait.until(presenceOfElementLocated(By.cssSelector(".row")));
        List<WebElement> countryRows = driver.findElements(By.cssSelector(".row"));
        for (int currentPosition = 2; currentPosition <= countryRows.size(); currentPosition++) {
            Integer numberOfRegions = 0;
            String locator = ".dataTable tr.row:nth-child(" + currentPosition + ")";

            //check number of regions for current row
            WebElement currentRow = driver.findElement(By.cssSelector(locator));
            numberOfRegions = Integer.parseInt(currentRow.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("textContent"));
            String curregionName = currentRow.findElement(By.cssSelector("a")).getAttribute("textContent");
            //if number of regions is greater than zero, go to this country page
            if (numberOfRegions > 0) {
                currentRow.findElement(By.cssSelector("a")).click();

                //on this country page check regions sorting
                //temp array
                ArrayList<String> regions = new ArrayList();
                //all rows list
                SubElement = wait.until(presenceOfElementLocated(By.cssSelector("#table-zones  tr:nth-child(1)")));
                List<WebElement> regionsRows = driver.findElements(By.cssSelector("#table-zones input[type=hidden][name*=name]"));

                for (WebElement regionRow : regionsRows) {
                    //add values Property to the temp array
                    String regionName = regionRow.getAttribute("value");
                    regions.add(regionName);
                }

                //creating arrays to check sorting
                String[] regionsBeforeSort = regions.toArray(new String[regions.size()]);
                String[] regionsAfterSort = regions.toArray(new String[regions.size()]);
                Arrays.sort(regionsAfterSort);

                assertArrayEquals(regionsBeforeSort, regionsAfterSort);
                driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
                //end of main loop for regions for current country
            }

            //end of main loop for all countries
        }

        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("fa-sign-out")).click();
    }//end of Task9b


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
            String locator = "tr.row a:nth-child(" + currentGeoZone + ")";
            driver.findElement(By.cssSelector(locator)).click();



        }

        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("fa-sign-out")).click();
    }//end of Task 9c

}
