package com.nopcommerce.demo.pageObjects;

import com.nopcommerce.demo.utils.ScrollDown;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCartPageObject  extends PageObject {
    ProductOnePageObject productOnePageObject = new ProductOnePageObject();
    By product = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/div[1]");
    By price = By.xpath("//span[@class=\"product-unit-price\"]");
    By quanta = By.xpath("//input[@class=\"qty-input\"]");
    By total = By.xpath("//span[@class=\"product-subtotal\"]");
    By buttonContinue = By.xpath("//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/button[2]");
    By txtNameSecond = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[3]/a");
    By txtPriceSecond = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[4]/span");
    By inputCantidad = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[1]/table/tbody/tr[2]/td[5]/input");
    By txtTotalSecond = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[2]/td[6]/span");

    ScrollDown scrollDown = new ScrollDown(this.getDriver());

    //WebElement buttonContinue = this.getDriver().findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/button[2]"));
    private String getItemFromLocalStorage(String key) {
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        return (String) js.executeScript(String.format(
                "return window.localStorage.getItem('%s');", key));
    }
    public void verificationRAM(){
        String contentDiv = getDriver().findElement(product).getText();
        String localRAM = getItemFromLocalStorage("RAM");
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
        String priceNumbers = priceSpan.replace("$","").replace(",","");
        String quantityInput = getDriver().findElement(quanta).getAttribute("value");
        Double totalSpan = Double.parseDouble(getDriver().findElement(total).getText().replace("$","").replace(",",""));


        //operacion para calcular el total
        Double sumTotal = Double.parseDouble(priceNumbers)*Double.parseDouble(quantityInput);
        assertEquals(sumTotal,totalSpan);

        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/cart", "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/div[1]");
        getDriver().findElement(buttonContinue).click();
    }
    public void verificationNameSecond(){
        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/cart", "//input[@class=\"qty-input\"]");
        String nameSec = getDriver().findElement(txtNameSecond).getText();
        String localNameSec = getItemFromLocalStorage("secondname");
        assertEquals(nameSec,localNameSec);
    }
    public void verificationPriceSecond(){
        String priceSec = getDriver().findElement(txtPriceSecond).getText();
        String localPriceSec = getItemFromLocalStorage("secondprice");
        assertEquals(priceSec,localPriceSec);
    }
    public void verificationTotalSecond(){
        String priceSec = getDriver().findElement(txtPriceSecond).getText();
        String priceNumbers = priceSec.replace("$","").replace(",","");
        String quantityInput = getDriver().findElement(inputCantidad).getAttribute("value");
        Double totalSpan = Double.parseDouble(getDriver().findElement(txtTotalSecond).getText().replace("$","").replace(",",""));

        //operacion para calcular el total
        Double sumTotal = Double.parseDouble(priceNumbers)*Double.parseDouble(quantityInput);
        assertEquals(sumTotal,totalSpan);
        System.out.println("Fin del test");
    }

}
