package ru.stqa.training.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Андрей on 09.02.2017.
 */
public class CustomerLoginPage extends Page {

    public CustomerLoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public CustomerLoginPage open(){
        driver.navigate().to("http://localhost/litecart/en/");
        return this;
    }


    @FindBy(css = ".product")
    public List<WebElement> products;
}
