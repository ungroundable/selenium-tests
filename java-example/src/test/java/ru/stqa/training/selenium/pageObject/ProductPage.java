package ru.stqa.training.selenium.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Андрей on 09.02.2017.
 */
public class ProductPage extends Page {

    public ProductPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void selectSize(Integer SelectSize) {
        Select productSizeSelect = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
        productSizeSelect.selectByIndex(SelectSize);
    }


    @FindBy(css = "span.quantity")
    private WebElement quantityElement;


    public Integer getProductQuantity(){
        return Integer.parseInt(quantityElement.getAttribute("textContent"));
    }


    @FindBy(css = "[name='add_cart_product']")
    public WebElement addButton;

    @FindBy(css = "#cart .link")
    public WebElement checkout;


}
