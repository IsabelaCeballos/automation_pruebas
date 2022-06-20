package com.nopcommerce.demo.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPageObject  extends PageObject {
    ProductOnePageObject productOnePageObject = new ProductOnePageObject();

      public void getDetails(){
        WebElement details = this.getDriver().findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/div[1]"));
        String productOne = details.getText();

        WebElement price = this.getDriver().findElement(By.xpath("//span[@class=\"product-unit-price\"]"));
        String priceOne = price.getText();

        WebElement quanty = this.getDriver().findElement(By.xpath("//input[@id=\"itemquantity11221\"]"));
        String quantyOne = quanty.getText();

        //operacion para calcular el total
        String sumTotal = String.valueOf(Integer.parseInt(priceOne)*Integer.parseInt(quantyOne));

        WebElement total = this.getDriver().findElement(By.xpath("//span[@class=\"product-subtotal\"]"));
        String totalOne = total.getText();
    }

}
