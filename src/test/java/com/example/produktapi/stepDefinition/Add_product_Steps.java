package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_product_Steps {

    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new EdgeDriver();

    @Then("User should see the title {string}")
    public void user_should_see_the_title(String expectedHeader) {
        String header = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/h2")).getText();
        Assertions.assertEquals(expectedHeader, header);
    }

}
