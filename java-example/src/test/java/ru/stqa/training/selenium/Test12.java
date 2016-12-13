package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by Андрей on 13.12.2016.
 */
public class Test12 extends TestBase {


    @Test
    public void addNewProductTest() {

        long uniqueLong = System.currentTimeMillis() / 1000L;

        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        WebElement addNewProductElement = driver.findElement(By.xpath("//*[contains(text(),'Add New Product')]"));
        addNewProductElement.click();

        //wait until new page will be loaded
        wait.until(presenceOfElementLocated(By.cssSelector("[name='name[en]']")));

        //new product name
        String newProductName ="Duck" + uniqueLong;
        WebElement newProductNameElement = driver.findElement(By.cssSelector("[name='name[en]']"));
        newProductNameElement.sendKeys(newProductName);

        //new product code
        String newProductCode ="rd" + uniqueLong;
        WebElement newProductCodeElement = driver.findElement(By.cssSelector("[name='code']"));
        newProductCodeElement.sendKeys(newProductCode);


        //new product categories checkbox
        WebElement newProductCategoryElement = driver.findElement(By.cssSelector("[name='categories[]'][value='1']"));
        newProductCategoryElement.click();

        //new product quantity
        String newProductQuantity = "" + uniqueLong / 10000000L;
        WebElement newProductQuantityElement = driver.findElement(By.cssSelector("[name='quantity']"));
        newProductQuantityElement.sendKeys(newProductQuantity);

        //Sold status
        String SoldStatus ="Temporary sold out";
        WebElement SoldoutElement = driver.findElement(By.cssSelector("[name='sold_out_status_id']"));
        Select SoldSelect = new Select(SoldoutElement);
        SoldSelect.selectByVisibleText(SoldStatus);

        //image
        driver.findElement(By.cssSelector("[type=file]")).sendKeys((new File("./src/test/java/resources/1.jpg").getAbsolutePath()));

        //go to information tab
        WebElement InformationTabElement = driver.findElement(By.cssSelector(".index>li:nth-child(2) a"));
        InformationTabElement.click();



        //wait until new tab will be loaded
        wait.until(presenceOfElementLocated(By.cssSelector("[name='manufacturer_id']")));

        //Manufacturer
        String manufacturer ="ACME Corp.";
        WebElement manufacturerElement = driver.findElement(By.cssSelector("[name='manufacturer_id']"));
        Select manufacturerSelect = new Select(manufacturerElement);
        manufacturerSelect.selectByVisibleText(manufacturer);

        //new product short description
        String newProductShortDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue.";
        WebElement newProductShortDescriptionElement = driver.findElement(By.cssSelector("[name='short_description[en]']"));
        newProductShortDescriptionElement.sendKeys(newProductShortDescription);


        //new product description
        String newProductDescription = "Lorem ipsum dolor sit";
        WebElement newProductDescriptionElement = driver.findElement(By.cssSelector("[name='description[en]']"));
        newProductDescriptionElement.sendKeys(newProductDescription);

        //Save duck
        WebElement saveButtonElement = driver.findElement(By.cssSelector("[name='save']"));
        saveButtonElement.click();

    }



}
