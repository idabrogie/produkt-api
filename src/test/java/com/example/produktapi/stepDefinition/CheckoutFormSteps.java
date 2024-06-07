package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutFormSteps {
//Fatima och Ida

    SeleniumConfig seleniumConfig = new SeleniumConfig();

    @Given("there are items in the shopCart")
    public void thereAreItemsInTheShopCart() {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to cart')]")));

        // Scroll into view
        ((JavascriptExecutor) seleniumConfig.getDriver()).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        // Click using JavaScript executor
        ((JavascriptExecutor) seleniumConfig.getDriver()).executeScript("arguments[0].click();", addToCartButton);
    }

    @And("the user is on CheckoutPage")
    public void theUserIsOnCheckoutPage() {
        seleniumConfig.getDriver().get(("https://webshop-agil-testautomatiserare.netlify.app/checkout"));
    }

    @When("user does not fill in the form")
    public void userDoesNotFillInTheForm() {

    }

    @And("user clicks the continue to checkout-button")
    public void userClicksTheContinueToCheckoutButton() {
       WebElement button = seleniumConfig.getDriver().findElement(By.className("btn-lg"));
        button.click();
    }

    @Then("the user cannot continue to checkout")
    public void theUserCannotContinueToCheckout() {
        /*WebElement missingData = seleniumConfig.getDriver().findElement(By.className("needs-validation"));
        String className = missingData.getAttribute("class");
        System.out.println(className);*/
    }
}
