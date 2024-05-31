package com.example.produktapi.stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumConfig {
    private static WebDriver driver;
    public  WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
    @Given("User visiting webshop")
    public void userVisitingWebshop() {
        getDriver().get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    @When("User clicks on Meny item {string}")
    public void userClicksOnMenyItem(String menyItem) {
        getDriver().findElement(By.linkText(menyItem)).click();
    }



    @AfterEach
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
