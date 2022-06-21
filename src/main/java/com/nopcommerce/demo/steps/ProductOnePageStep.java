package com.nopcommerce.demo.steps;


import com.nopcommerce.demo.pageObjects.ProductOnePageObject;
import net.thucydides.core.annotations.Step;

public class ProductOnePageStep {
    //evidencias para generar un reporte
    ProductOnePageObject productOnePageObject = new ProductOnePageObject();

    @Step
    public void verificationTitleOne() {
        productOnePageObject.verificationTitleOne();
    }

    @Step
    public void selectionRAM() {
        productOnePageObject.selectionRAM();
    }

    @Step
    public void selectionHDD() {
        productOnePageObject.selectionHDD();
    }

    @Step
    public void selectSoftware() {
        productOnePageObject.selectSoftware();
    }

    @Step
    public void clickButtonAddCart(){
        productOnePageObject.clickButtonAddCart();
    }

    @Step
    public void handlePrompt() throws InterruptedException {
        productOnePageObject.handlePrompt();
    }
    @Step
    public void clickLnkShoppingCart(){
        productOnePageObject.clickLnkShoppingCart();
    }
    /*@Step
    public void localStorage(){
        productOnePageObject.local();
    }*/
}