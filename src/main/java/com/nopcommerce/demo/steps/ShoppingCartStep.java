package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pageObjects.ShoppingCartPageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingCartStep extends PageObject {
  //evidencias para generar un reporte
  ShoppingCartPageObject shoppingCartPageObject = new ShoppingCartPageObject();
  @Step
  public void verificationRAM(){ shoppingCartPageObject.verificationRAM();}
  @Step
  public  void verificationHDD(){ shoppingCartPageObject.verificationHDD();}
  @Step
  public  void verificationSoftwareOne(){ shoppingCartPageObject.verificationSoftwareOne();}
  @Step
  public  void verificationSoftwareTwo(){ shoppingCartPageObject.verificationSoftwareTwo();}
  @Step
  public  void verificationPrice(){ shoppingCartPageObject.verificationPrice();}
  @Step
  public  void verificationTotal(){ shoppingCartPageObject.verificationTotal();}
  @Step
  public void verificationNameSecond(){
    shoppingCartPageObject.verificationNameSecond();
  }
  @Step
  public void  verificationPriceSecond(){
    shoppingCartPageObject.verificationPriceSecond();
  }
  @Step
  public void verificationTotalSecond(){
    shoppingCartPageObject.verificationTotalSecond();
  }
}
