package com.nopcommerce.demo.pageObjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.page.Page;

import static org.junit.Assert.assertEquals;

public class ProductOnePage extends PageObject {
    By txtOne = By.xpath("//*[@id=\"product-details-form\"]/div[2]/div[1]/div[2]/div[1]/h1");

    public void verificationTitleOne(){
        String texto = getDriver().findElement(txtOne).getText();
        assertEquals(texto,"Hangouts");
    }
}
