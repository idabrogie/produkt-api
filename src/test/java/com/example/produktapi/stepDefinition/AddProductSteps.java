package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;


public class AddProductSteps {

    SeleniumConfig seleniumConfig = new SeleniumConfig();
    /*@When("user clicks on add productButton")
    public void user_clicks_on_add_productButton() {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to cart')]")));

        // Scroll into view
        ((JavascriptExecutor) seleniumConfig.getDriver()).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        // Click using JavaScript executor
        ((JavascriptExecutor) seleniumConfig.getDriver()).executeScript("arguments[0].click();", addToCartButton);
    }*/



    @Then("a product should be added to the cart")
    public void a_product_should_be_added_to_the_cart() {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));

        // Wait for the cart badge to be updated
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("buttonSize")));

        // Get the text of the cart badge
        String badgeText = cartBadge.getText();

        // Verify that the cart badge text has been updated to reflect the addition of the product
        Assertions.assertEquals(badgeText, "1", "Cart badge has been updated to indicate the addition of the product.");

    }



}
