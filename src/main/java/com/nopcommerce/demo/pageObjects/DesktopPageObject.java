package com.nopcommerce.demo.pageObjects;

import com.nopcommerce.demo.utils.ScrollDown;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DesktopPageObject extends PageObject {
    //declaración objeto tipo ScrollDown
    ScrollDown scrollDown = new ScrollDown(this.getDriver());
    //mapeo del botón ADD TO CART
    By buttonAdd = By.xpath("(//button[@class=\"button-2 product-box-add-to-cart-button\"])[1]");
    public void ButtonAdd() throws InterruptedException {
        scrollDown.ByVisibleElement("https://demo.nopcommerce.com/desktops", "//img[@alt=\"Picture of Build your own computer\"][1]");
        Thread.sleep(2000);
        getDriver().findElement(buttonAdd).click();
    }
}
