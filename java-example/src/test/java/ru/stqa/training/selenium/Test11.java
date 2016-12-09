package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

/**
 * Created by Андрей on 07.12.2016.
 */
public class Test11 extends TestBase {


    @Test
    public void NewUserRegister() {
        long uniqueLong = System.currentTimeMillis() / 1000L;
        String password = "password";
        String newUserEmail = userRegister(uniqueLong, password);
        logoutUser();
        loginUser(newUserEmail,password);
        logoutUser();
    }

    public String userRegister(long uniqueLong, String password){
        driver.navigate().to("http://localhost/litecart/en/");

        WebElement registerNewUserElement = driver.findElement(By.xpath("//*[contains(text(),'New customers click here')]"));
        registerNewUserElement.click();

        //use system time to generate unique values


        //user first name
        String newFirstName ="Name" + uniqueLong;
        WebElement firstNameElement = driver.findElement(By.cssSelector("*[name='firstname']"));
        firstNameElement.sendKeys(newFirstName);

        //user last name
        String newLastName ="LastName" + uniqueLong;
        WebElement lastNameElement = driver.findElement(By.cssSelector("*[name='lastname']"));
        lastNameElement.sendKeys(newLastName);

        //user address1
        String address1 ="address1" + uniqueLong;
        WebElement address1Element = driver.findElement(By.cssSelector("*[name='address1']"));
        address1Element.sendKeys(address1);

        //post code, not necessary to be unique
        String postcode ="90210";
        WebElement postcodeElement = driver.findElement(By.cssSelector("*[name='postcode']"));
        postcodeElement.sendKeys(postcode);

        //City, not necessary to be unique
        String city ="TaganYork";
        WebElement cityElement = driver.findElement(By.cssSelector("*[name='city']"));
        cityElement.sendKeys(city);

        //Country
        String country ="United States";
        WebElement countryElement = driver.findElement(By.cssSelector(".select2-hidden-accessible"));
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(country);

        //Zone
        String zone ="California";
        wait.until(textToBePresentInElementLocated(By.cssSelector("select[name='zone_code']"),"Alabama"));
        WebElement zoneElement = driver.findElement(By.cssSelector("select[name='zone_code']"));
        Select zoneSelect = new Select(zoneElement);
        zoneSelect.selectByVisibleText(zone);

        //user email
        String email ="test" + uniqueLong + "@example.com";
        WebElement emailElement = driver.findElement(By.cssSelector("*[name='email']"));
        emailElement.sendKeys(email);

        //Phone, not necessary to be unique
        String phone ="7609871234";
        WebElement phoneElement = driver.findElement(By.cssSelector("*[name='phone']"));
        phoneElement.sendKeys(phone);

        //Password, not necessary to be unique
//        String password ="password" have one as a parameter;
        WebElement passwordElement = driver.findElement(By.cssSelector("*[name='password']"));
        passwordElement.sendKeys(password);

        //Confirmed Password, not necessary to be unique
        String confirmedPassword ="password";
        WebElement confirmedPasswordElement = driver.findElement(By.cssSelector("*[name='confirmed_password']"));
        confirmedPasswordElement.sendKeys(confirmedPassword);


        //Create account
        WebElement createAccountElement = driver.findElement(By.cssSelector("*[name='create_account']"));
        createAccountElement.click();

        return email;
    }

    public void logoutUser(){
        //wait until new page will load
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account li:last-child")));
        WebElement logoutElement = driver.findElement(By.cssSelector("#box-account li:last-child a"));
        logoutElement.click();

    }

    public void loginUser(String newUserEmail,String password){
        //wait until new page will load
        wait.until(presenceOfElementLocated(By.cssSelector("*[name='email']")));
        WebElement emailElement = driver.findElement(By.cssSelector("*[name='email']"));
        emailElement.sendKeys(newUserEmail);

        WebElement passwordElement = driver.findElement(By.cssSelector("*[name='password']"));
        passwordElement.sendKeys(password);

        WebElement loginElement = driver.findElement(By.cssSelector("*[name='login']"));
        loginElement.click();


    }



}
