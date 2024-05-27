package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addproduct_Steps {

    WebDriver driver = new ChromeDriver();

    @Given("User enters website")
    public void user_enters_website() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    @Then("User should see the title {string}")
    public void user_should_see_the_title(String expectedHeader) {
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText();
        Assertions.assertEquals(expectedHeader, actualHeader);
    }
}
