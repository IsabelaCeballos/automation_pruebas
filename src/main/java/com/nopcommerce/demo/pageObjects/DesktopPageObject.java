package com.nopcommerce.demo.pageObjects;

import com.nopcommerce.demo.utils.ScrollDown;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.Assert.assertEquals;

public class DesktopPageObject extends PageObject {
    //declaración objeto tipo ScrollDown
    ScrollDown scrollDown = new ScrollDown(this.getDriver());
    //mapeo de los elementos
    By buttonAdd = By.xpath("(//button[@class=\"button-2 product-box-add-to-cart-button\"])[1]");
    By getButtonAddTwo = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]");
    By advice = By.xpath("//a[@href=\"/cart\"][1]");
    By nameSecondProduct = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a");
    By priceSecondProduct = By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[1]/span");
    By lnkShoppingcart = By.xpath("//a[@class=\"ico-cart\"]");

    //métodos donde se describen las acciones de los elementos
    public void ButtonAdd() throws InterruptedException {
        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/desktops", "//img[@alt=\"Picture of Build your own computer\"][1]");
        Thread.sleep(2000);
        getDriver().findElement(buttonAdd).click();
    }
    public void ButtonAddTwo() throws InterruptedException {
        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/desktops", "//img[@alt=\"Picture of Build your own computer\"][1]");
        Thread.sleep(2000);
        getDriver().findElement(getButtonAddTwo).click();
        Thread.sleep(6000);
    }
    public void handleAdvice() throws InterruptedException {
        String textPrompt = getDriver().findElement(advice).getText();
        assertEquals(textPrompt,"Shopping cart (2)");
        Thread.sleep(6000);
    }
    public void saveNamePrice(){
        //ingreso el nombre al local Storage
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        String nameS = getDriver().findElement(nameSecondProduct).getText();
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","secondname", nameS);

        //ingreso el precio al local Storage
        String priceS = getDriver().findElement(priceSecondProduct).getText();
        js.executeScript("localStorage.setItem(arguments[0],arguments[1])","secondprice", priceS);

        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/desktops", "//li[@id=\"topcartlink\"]");

        getDriver().findElement(lnkShoppingcart).click();
    }
}
