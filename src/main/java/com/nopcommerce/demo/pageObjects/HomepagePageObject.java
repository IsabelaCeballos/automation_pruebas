package com.nopcommerce.demo.pageObjects;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

@DefaultUrl("https://demo.nopcommerce.com/")
public class HomepagePageObject extends PageObject {
    //método donde se describe la acción de los elementos
    public void hoverLnkComputers(){
        //System.out.println(this.getDriver().toString());
        Actions action = new Actions(this.getDriver());
        WebElement computers = this.getDriver().findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
        action.moveToElement(computers).perform();
        WebElement desktops = this.getDriver().findElement(By.xpath("//a[@href=\"/desktops\"]"));
        action.moveToElement(desktops).click().build().perform();
    }
}
