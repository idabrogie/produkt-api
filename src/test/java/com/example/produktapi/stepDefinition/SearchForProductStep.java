package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class SearchForProductStep {
    SeleniumConfig seleniumConfig = new SeleniumConfig();

    @And("User search for product {string}")
    public void userSearchForProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement searchTxtField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

        searchTxtField.clear();
        searchTxtField.click();

        new Actions(seleniumConfig.getDriver())
                .sendKeys(searchTxtField, productName)
                .perform();
    }

    @Then("User can see the search product and expect {int} products")
    public void userCanSeeTheSearchProductAndExpectProducts(int numberOfProduct) {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(20));

        // Wait for the products container to be visible
        WebElement divElementsWithClass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("my-5")));

        // Find all product elements within the container
        List<WebElement> productElements = divElementsWithClass.findElements(By.cssSelector("div.col"));

        // Log the number of products found
        System.out.println("Found " + productElements.size() + " products.");

        // Log the inner HTML content for debugging
        System.out.println("Inner HTML of main element: " + divElementsWithClass.getAttribute("innerHTML"));

        // Capture screenshot on failure
        if (productElements.size() != numberOfProduct) {
            captureScreenshot("search_product_failure");
        }

        // Assert that the number of products matches the expected number
        Assertions.assertEquals(numberOfProduct, productElements.size(),
                "Expected " + numberOfProduct + " products, but found " + productElements.size());
    }

    @Then("Result should be an empty main")
    public void resultShouldBeAnEmptyMain() {
        // Find the main element by class name
        WebElement mainElement = seleniumConfig.getDriver().findElement(By.className("my-5"));
        // Get the inner HTML content of the main element
        String innerHTML = mainElement.getAttribute("innerHTML");
        // Assert that the inner HTML content is empty
        Assertions.assertTrue(innerHTML.trim().isEmpty(), "The inner HTML content is not empty");
    }

    public void captureScreenshot(String screenshotName) {
        File srcFile = ((TakesScreenshot) seleniumConfig.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
