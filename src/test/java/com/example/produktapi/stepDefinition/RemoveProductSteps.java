package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Amir

public class RemoveProductSteps {

    SeleniumConfig seleniumConfig = new SeleniumConfig();
    WebDriver driver = seleniumConfig.getDriver();

    @When("User remove the product from the shopping cart")
    public void user_remove_the_product_from_the_shopping_cart() {
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-outline-danger') and text()='Remove']"));
        removeButton.click();
    }

    @Then("the product should be removed from shopping cart")
    public void the_product_should_be_removed_from_shopping_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartSizeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartSize")));
        String cartSizeText = cartSizeElement.getText();
        Assertions.assertEquals("0", cartSizeText);
    }

    @When("User removes one product from the shopping cart")
    public void user_removes_one_product_from_the_shopping_cart() {
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(@class, 'btn-outline-danger') and text()='Remove']"));
        removeButton.click();
    }

    @Then("the product should be removed from shopping cart and the other product should still be in the shopping cart")
    public void the_product_should_be_removed_from_shopping_cart_and_the_other_product_should_still_be_in_the_shopping_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartSizeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartSize")));
        String cartSizeText = cartSizeElement.getText();
        Assertions.assertEquals("3", cartSizeText);
    }
}
