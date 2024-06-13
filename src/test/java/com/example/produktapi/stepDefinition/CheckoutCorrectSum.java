package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class CheckoutCorrectSum {
    SeleniumConfig seleniumConfig = new SeleniumConfig();

    @Given("user have added following products in cart")
    public void userHaveAddedFollowingProductsInCart(DataTable table) {

        List<Map<String, String>> products = table.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String productName = product.get("Product");
            String price = product.get("Price");
            String quantity = product.get("Quantity");

            seleniumConfig.addProductToCart(productName, quantity);
        }

        seleniumConfig.getDriver().navigate().refresh();
    }

    @Then("the amount should be {string}")
    public void theAmountShouldBeSum(String expectedSum) {
       System.out.println(seleniumConfig.getDriver().getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement currentSum = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='cartList']/li[last()]/strong")));
        Assertions.assertEquals(expectedSum, currentSum.getText());
    }
}
