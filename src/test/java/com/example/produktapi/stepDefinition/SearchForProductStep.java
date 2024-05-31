package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class SearchForProductStep {
    SeleniumConfig seleniumConfig = new SeleniumConfig();


    @And("User search for product {string} on webpage")
    public void userSearchForProductOnWebpage(String productName) {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement searchTxtField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

        searchTxtField.clear();
        searchTxtField.click();

        new Actions(seleniumConfig.getDriver())
                .sendKeys(searchTxtField, productName)
                .perform();
    }
    @Then("User can see the search product and expect {int} products")
    public void userCanSeeTheSearchProductAndExpectProducts(int numberOfProduct) {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        List<WebElement> divElementsWithClass = Collections.singletonList(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("main#main div.product"))));
        // Count the number of div elements with class "col"
        int divCountWithClass = divElementsWithClass.size();

        Assertions.assertEquals(numberOfProduct, divElementsWithClass);
    }

    @Then("Result should be an empty main")
    public void resultShouldBeAnEmptyMain() {

    }
}
