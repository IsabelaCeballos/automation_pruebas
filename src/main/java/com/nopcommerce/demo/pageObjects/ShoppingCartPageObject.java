package com.nopcommerce.demo.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartPageObject  extends PageObject {
    ProductOnePageObject productOnePageObject = new ProductOnePageObject();
    By product = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/div[1]");
    By price = By.xpath("//span[@class=\"product-unit-price\"]");
    By quanty = By.xpath("//input[@id=\"itemquantity11221\"]");
    By total = By.xpath("//span[@class=\"product-subtotal\"]");
    By buttonContinue = By.xpath("//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/button[2]");

    //WebElement buttonContinue = this.getDriver().findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/button[2]"));
    private String getItemFromLocalStorage(String key) {
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        return (String) js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", key));
    }
    public void verificationRAM(){
        String contentDiv = getDriver().findElement(product).getText();
        String localRAM = getItemFromLocalStorage("RAM");
        System.out.println(localRAM);
        System.out.println(contentDiv);
        assertTrue(contentDiv.contains(localRAM));
    }
    public void verificationHDD(){
        String contentDiv = getDriver().findElement(product).getText();
        String localHDD = getItemFromLocalStorage("HDD");
        assertTrue(contentDiv.contains(localHDD));
    }
    public void verificationSoftwareOne(){
        String contentDiv = getDriver().findElement(product).getText();
        String localSone = getItemFromLocalStorage("softwareOne");
        assertTrue(contentDiv.contains(localSone));
    }
    public void verificationSoftwareTwo(){
        String contentDiv = getDriver().findElement(product).getText();
        String localStwo = getItemFromLocalStorage("softwareTwo");
        assertTrue(contentDiv.contains(localStwo));
    }
    public void verificationPrice(){
        String priceSpan = getDriver().findElement(price).getText();
        String localPrice = getItemFromLocalStorage("price");
        assertEquals(priceSpan,localPrice);
    }
    public void verificationTotal(){
        String priceSpan = getDriver().findElement(price).getText();
        String quantyInput = getDriver().findElement(quanty).getText();
        String totalSpan = getDriver().findElement(total).getText();

        //operacion para calcular el total
        String sumTotal = String.valueOf(Integer.parseInt(priceSpan)*Integer.parseInt(quantyInput));
        assertEquals(sumTotal,totalSpan);
        getDriver().findElement(buttonContinue).click();
    }

}
