package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Add_product_Steps {

    WebDriver driver;

    public Add_product_Steps() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }

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

    @Given("user is on webpage")
    public void user_is_on_webpage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user clicks on add productButton")
    public void user_clicks_on_add_productButton() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("a product")
    public void a_product() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
