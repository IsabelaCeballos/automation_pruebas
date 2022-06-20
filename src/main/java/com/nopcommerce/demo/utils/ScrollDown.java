package com.nopcommerce.demo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDown {
    WebDriver driver;
    public ScrollDown(WebDriver driver){
        this.driver = driver;
    }
    public void ByVisibleElement(String url, String mapeo) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application
        driver.get(url);

        //Find element by link text and store in variable "Element"
        WebElement Element = driver.findElement(By.xpath(mapeo));

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }
}
