package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Андрей on 09.01.2017.
 */
public class Test13 extends TestBase {

void addProduct(){
    Integer counterBefore, counterAfter = 0;
    driver.navigate().to("http://localhost/litecart/en/");

    driver.findElement(By.cssSelector(".product")).click();

    wait.until(presenceOfElementLocated(By.cssSelector("[name='add_cart_product']")));

    if(isOneElementPresent(driver.findElement(By.cssSelector(".information")),By.cssSelector("[name='options[Size]']"))){
        Select productSizeSelect = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
        productSizeSelect.selectByIndex(1);
    }

    WebElement productsCounter = driver.findElement(By.cssSelector("span.quantity"));
    counterBefore = Integer.parseInt(productsCounter.getAttribute("textContent"));;
    counterAfter = counterBefore;

    driver.findElement(By.cssSelector("[name='add_cart_product']")).click();
    wait.until(textToBePresentInElementLocated(By.cssSelector("span.quantity"), (++counterAfter).toString() ));
//    wait.until(visibilityOf(productsCounter));

    productsCounter = driver.findElement(By.cssSelector("span.quantity"));
    counterAfter = Integer.parseInt(productsCounter.getAttribute("textContent"));

    //assert error if quantity was not changed
    assertTrue("counter was not changed", counterBefore != counterAfter);
    driver.navigate().to("http://localhost/litecart/en/");
};


    @Test
    public void addNewProductTest(){
        for(int i=0; i<3; i++){
            addProduct();
        }

        driver.findElement(By.linkText("Checkout »")).click();

        wait.until(presenceOfElementLocated(By.cssSelector(".shortcut a")));
        driver.findElement(By.cssSelector(".shortcut a")).click();

        while(areElementsPresent(driver,By.cssSelector("li.item"))){
            driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();
            wait.until(stalenessOf(driver.findElement(By.cssSelector("#box-checkout-summary"))));
        }



    }





}
