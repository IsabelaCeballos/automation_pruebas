package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pageObjects.DesktopPageObject;
import net.thucydides.core.annotations.Step;

public class DesktopStep {
    //evidencias para generar un reporte
    DesktopPageObject desktopPageObject = new DesktopPageObject();
    @Step
    public void buttonAdd() throws InterruptedException {
        desktopPageObject.ButtonAdd();
    }
    @Step
    public void buttonAddTwo() throws InterruptedException {
        desktopPageObject.ButtonAddTwo();
    }
    @Step
    public void handleAdvice() throws InterruptedException {
        desktopPageObject.handleAdvice();
    }
    @Step
    public void saveNamePrice(){
        desktopPageObject.saveNamePrice();
    }

}
