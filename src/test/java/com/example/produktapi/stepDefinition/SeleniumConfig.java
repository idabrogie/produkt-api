package com.example.produktapi.stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumConfig {
    private static WebDriver driver;
    public  WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    @Given("User visiting webshop")
    public void userVisitingWebshop() {
        getDriver().get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    @Given("user clicks on Menu item shop")
    public void user_clicks_on_menu_item_shop() {
        getDriver().get("https://webshop-agil-testautomatiserare.netlify.app/products#");

    }
    @When("User clicks on Meny item {string}")
    public void userClicksOnMenyItem(String menyItem) {
        getDriver().findElement(By.linkText(menyItem)).click();
    }

    @And("User has clicked on checkoutButton")
    public void userHasClickedOnCheckoutButton() {
        System.out.println("Nu kör vi den här metoden.");
        driver.navigate().refresh();
        WebElement button = driver.findElement(By.xpath("//a[@href='/checkout']"));
        System.out.println(button);
        button.click();
    }

    @When("user clicks on add productButton")
    public void user_clicks_on_add_productButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to cart')]")));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        // Click using JavaScript executor
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    public void addProductToCart(String product, String quantity){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpathExpression = String.format("//button[contains(@onclick, \"%s\")]", product);
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        int quantityInt = Integer.parseInt(quantity);
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        for (int i=0; i<quantityInt; i++){
            // Click using JavaScript executor
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
        }
    }

    @After
    public void tearDown() {
        if (getDriver() != null) {
            System.out.println("Quitting the driver...");
            getDriver().quit();
            driver = null; // Reset the driver to ensure it can be re-initialized if needed
        }
    }
}
