package com.example.produktapi.stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
            if (Boolean.parseBoolean(System.getenv("RUN_HEADLESS"))) {
                options.addArguments("--headless=new");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
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

    @After
    public void tearDown() {
        if (getDriver() != null) {
            System.out.println("Quitting the driver...");
            getDriver().quit();
            driver = null; // Reset the driver to ensure it can be re-initialized if needed
        }
    }

    public void addProductToCart(String product){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpathExpression = "//h3[contains(text(), '" + product + "')]/../button";
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        //"//div[@class='canvas- graph']//a[@href='/accounting.html'][i[@class='icon-usd']]/following-sibling::h4"
        ////*[@id="main"]/div[1]/div/div

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        // Click using JavaScript executor
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }
}
