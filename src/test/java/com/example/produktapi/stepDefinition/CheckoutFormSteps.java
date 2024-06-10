package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
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

    @And("there are items in the shopCart")
    public void thereAreItemsInTheShopCart() {
        seleniumConfig.getDriver().get("https://webshop-agil-testautomatiserare.netlify.app/products");

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

    @And("user clicks the continue to checkout-button without filling out the form")
    public void userClicksTheContinueToCheckoutButtonWithoutFillingOutTheForm() {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Continue to checkout')]")));
        checkoutButton.submit();
    }

    @Then("the user gets validation errors and cant continue")
    public void theUserCannotContinueToCheckout() {
        WebElement formElement = seleniumConfig.getDriver().findElement(By.className("needs-validation"));
        String classesForElement = formElement.getAttribute("class");
        boolean hasValidateClass = classesForElement.contains("was-validated");
        Assertions.assertTrue(hasValidateClass);
    }

    @Then("the user is still on checkout page")
    public void theUserIsStillOnCheckoutPage() {
        String expectedUrl = "https://webshop-agil-testautomatiserare.netlify.app/checkout";
        String actualUrl = seleniumConfig.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }
}
