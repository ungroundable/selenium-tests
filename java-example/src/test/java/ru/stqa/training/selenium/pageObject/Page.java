package ru.stqa.training.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Андрей on 09.02.2017.
 */

public class Page {

        protected WebDriver driver;
        protected WebDriverWait wait;

        public Page(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, 10);
        }
}
