package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pageObjects.ShoppingCartPageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingCartStep extends PageObject {
  ShoppingCartPageObject shoppingCartPageObject = new ShoppingCartPageObject();
  @Step
    public void getDetails(){
      shoppingCartPageObject.getDetails();
  }


}
