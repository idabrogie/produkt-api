package com.example.produktapi.stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    @After
    public void tearDown() {
        if (getDriver() != null) {
            System.out.println("Quitting the driver...");
            getDriver().quit();
            driver = null; // Reset the driver to ensure it can be re-initialized if needed
        }
    }
}
