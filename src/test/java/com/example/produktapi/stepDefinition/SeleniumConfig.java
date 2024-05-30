package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.Given;
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
    @Given("User visitning webshop")
    public void userVisitningWebshop() {
        getDriver().get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

}
