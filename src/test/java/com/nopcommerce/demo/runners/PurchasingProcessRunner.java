package com.nopcommerce.demo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/com.nopcommerce.demo/com.nopcommerce.demo.feature",
                 //ruta donde se encuentra el escenario en lenguaje Gherkin
                 glue = "com.nopcommerce.demo.stepdefinitions",
                 //ruta donde se van a ubicar los métodos definidos con el lenguaje Gherkin
                 snippets = CucumberOptions.SnippetType.CAMELCASE)
                 //indica que los métodos se creen con su inicial en mayúscula

public class PurchasingProcessRunner {
}
