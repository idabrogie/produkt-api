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

    @And("User search for product on webpage")
    public void userSearchForProductOnWebpage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement searchTxtField =  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));


        searchTxtField.clear();
        searchTxtField.click();

        //wait(5000);

       // searchTxtField.sendKeys("WD");
        new Actions(seleniumConfig.getDriver())
                .sendKeys(searchTxtField,"WD")
                .perform();
    }
    @Then("User can see the search product")
    public void userCanSeeTheSearchProduct() {
    }
}
