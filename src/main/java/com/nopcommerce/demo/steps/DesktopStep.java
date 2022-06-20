package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pageObjects.DesktopPageObject;
import net.thucydides.core.annotations.Step;

public class DesktopStep {
    DesktopPageObject desktopPageObject = new DesktopPageObject();
    @Step
    public void buttonAdd() throws InterruptedException {
        desktopPageObject.ButtonAdd();
    }

}
