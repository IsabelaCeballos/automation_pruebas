package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pageObjects.HomepagePageObject;
import net.thucydides.core.annotations.Step;

public class HomepageStep {
    HomepagePageObject homepagePageObject = new HomepagePageObject();
    @Step
    public void abrirNavegador(){
        homepagePageObject.open();
    }
    @Step
    public void hoverLnkComputers(){
        homepagePageObject.hoverLnkComputers();
    }

}
