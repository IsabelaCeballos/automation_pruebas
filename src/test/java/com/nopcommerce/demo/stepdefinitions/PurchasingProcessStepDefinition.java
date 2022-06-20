package com.nopcommerce.demo.stepdefinitions;

import com.nopcommerce.demo.pageObjects.ProductOnePageObject;
import com.nopcommerce.demo.steps.DesktopStep;
import com.nopcommerce.demo.steps.HomepageStep;
import com.nopcommerce.demo.steps.ProductOnePageStep;
import com.nopcommerce.demo.steps.ShoppingCartStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class PurchasingProcessStepDefinition {

    @Steps
    HomepageStep homePageStep;
    @Steps
    DesktopStep desktopStep;
    @Steps
    ProductOnePageStep productOnePageStep;
    @Steps
    ShoppingCartStep shoppingCartStep;
    @Given("user is in the nopCommerce demo page")
    public void userIsInTheNopCommerceDemoPage() {
        homePageStep.abrirNavegador();
        homePageStep.hoverLnkComputers();
    }
    @When("the user add products to shopping cart")
    public void theUserAddProductsToShoppingCart() throws InterruptedException {
        desktopStep.buttonAdd();
        productOnePageStep.verificationTitleOne();
        productOnePageStep.selectionRAM();
        productOnePageStep.selectionHDD();
        productOnePageStep.selectSoftware();
        productOnePageStep.clickButtonAddCart();
        productOnePageStep.handlePrompt();
        productOnePageStep.clickLnkShoppingCart();
        productOnePageStep.localStorage();
        //shoppingCartStep.getDetails();
    }
    @Then("the user can see the detail of the added products")
    public void theUserCanSeeTheDetailOfTheAddedProducts() {
    }
}
