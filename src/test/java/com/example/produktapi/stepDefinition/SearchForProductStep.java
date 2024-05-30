package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.time.Instant;

public class SearchForProductStep {

    SeleniumConfig seleniumConfig = new SeleniumConfig();
    @When("User clicks on Meny item {string}")
    public void userClicksOnMenyItem(String menyItem) {
        seleniumConfig.getDriver().findElement(By.linkText("Shop")).click();
    }
    @And("User search for product on webpage")
    public void userSearchForProductOnWebpage(){
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(20));
        WebElement searchTxtField =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        searchTxtField.sendKeys("Mens");
    }
    @Then("User can see the search product")
    public void userCanSeeTheSearchProduct() {
    }
}
