package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckHomePageTitleSteps {

    SeleniumConfig seleniumConfig = new SeleniumConfig();

    @Then("User should see the title {string}")
    public void user_should_see_the_title(String expectedHeader) {
        WebElement header = seleniumConfig.getDriver().findElement(By.tagName("h2"));
        String actualHeader = header.getText();
        Assertions.assertEquals(expectedHeader, actualHeader);
    }
}
