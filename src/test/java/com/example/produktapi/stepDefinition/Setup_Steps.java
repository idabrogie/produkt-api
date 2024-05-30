package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup_Steps {
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new EdgeDriver();

    @Given("User enters website")
    public void user_enters_website() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

}
