package ru.stqa.training.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Андрей on 09.02.2017.
 */
public class CheckoutPage extends Page {

    public CheckoutPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public CheckoutPage open(){
        driver.navigate().to("http://localhost/litecart/en/checkout");
        return this;
    }


    @FindBy(css = ".shortcut a")
    private WebElement productPicker;


    @FindBy(css = "[name=remove_cart_item]")
    private WebElement removeButton;

}
