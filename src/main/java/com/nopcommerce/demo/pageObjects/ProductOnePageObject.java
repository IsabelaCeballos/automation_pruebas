package com.nopcommerce.demo.pageObjects;

import com.nopcommerce.demo.utils.ScrollDown;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class ProductOnePageObject extends PageObject {
    By txtOne = By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[1]/h1");
    By selectRAM = By.xpath("//select[@id=\"product_attribute_2\"]");
    By selectHDD = By.xpath("//input[@id=\"product_attribute_3_7\"]");
    By selectSoftware = By.xpath("//input[@id=\"product_attribute_5_11\"]");
    By buttonAddcart = By.xpath("//button[@id=\"add-to-cart-button-1\"]");
    By advicePrompt = By.xpath("//p[@class=\"content\"]");
    By lnkShoppingcart = By.xpath("//a[@class=\"ico-cart\"]");
    //aserciones
    By txtOptionHDD = By.xpath("//label[@for=\"product_attribute_3_7\"]");
    By txtOptionSoftwareOne = By.xpath("//label[@for=\"product_attribute_5_10\"]");
    By txtOptionSoftwareTwo = By.xpath("//label[@for=\"product_attribute_5_11\"]");
    By txtPrice = By.xpath("//span[@id=\"price-value-1\"]");

    ScrollDown scrollDown = new ScrollDown(this.getDriver());

    public void verificationTitleOne(){
        String texto = getDriver().findElement(txtOne).getText();
        assertEquals(texto,"Build your own computer");
        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/build-your-own-computer","//dt[@id=\"product_attribute_label_1\"]");
    }
    public void selectionRAM(){
        //instancia del objeto tipo Select
        Select RAM = new Select(getDriver().findElement(selectRAM));
        RAM.selectByVisibleText("4GB [+$20.00]");

        //ingreso valor de RAM al local Storage
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","RAM","4GB [+$20.00]");
    }
    public void selectionHDD(){
        getDriver().findElement(selectHDD).click();
        String numberHDD = getDriver().findElement(txtOptionHDD).getText();

        //ingreso valor del HDD al local storage
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","HDD",numberHDD);
    }
    public void selectSoftware(){
        getDriver().findElement(selectSoftware).click();
        String softwareOne = getDriver().findElement(txtOptionSoftwareOne).getText();
        String softwareTwo = getDriver().findElement(txtOptionSoftwareTwo).getText();

        //ingreso software al local storage
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","softwareOne",softwareOne);
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","softwareTwo",softwareTwo);
    }
    public void clickButtonAddCart(){
        String price = getDriver().findElement(txtPrice).getText();
        getDriver().findElement(buttonAddcart).click();

        //ingreso del precio al local storage
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","price",price);
    }
    public void handlePrompt() throws InterruptedException {
        String textPrompt = getDriver().findElement(advicePrompt).getText();
        assertEquals(textPrompt,"The product has been added to your shopping cart");
        Thread.sleep(6000);
        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/build-your-own-computer", "//li[@id=\"topcartlink\"]");
    }
    public void clickLnkShoppingCart(){
        getDriver().findElement(lnkShoppingcart).click();
    }

}
