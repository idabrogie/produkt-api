package com.example.produktapi.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CheckoutFormSteps {
//Fatima och Ida

    SeleniumConfig seleniumConfig = new SeleniumConfig();

    @And("there are items in the shopCart")
    public void thereAreItemsInTheShopCart() {
        seleniumConfig.getDriver().get("https://webshop-agil-testautomatiserare.netlify.app/products");

        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to cart')]")));

        // Scroll into view
        ((JavascriptExecutor) seleniumConfig.getDriver()).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);

        // Click using JavaScript executor
        ((JavascriptExecutor) seleniumConfig.getDriver()).executeScript("arguments[0].click();", addToCartButton);
    }

    @When("user clicks the continue to checkout-button without filling out the form")
    public void userClicksTheContinueToCheckoutButtonWithoutFillingOutTheForm() {
        WebDriverWait wait = new WebDriverWait(seleniumConfig.getDriver(), Duration.ofSeconds(10));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Continue to checkout')]")));
        checkoutButton.submit();
    }

    @Then("the user gets validation errors and cant continue")
    public void theUserCannotContinueToCheckout() {
        WebElement formElement = seleniumConfig.getDriver().findElement(By.className("needs-validation"));
        String classesForElement = formElement.getAttribute("class");
        boolean hasValidateClass = classesForElement.contains("was-validated");
        Assertions.assertTrue(hasValidateClass);
    }

    @Then("the user is still on checkout page")
    public void theUserIsStillOnCheckoutPage() {
        String expectedUrl = "https://webshop-agil-testautomatiserare.netlify.app/checkout";
        String actualUrl = seleniumConfig.getDriver().getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @When("the user fill out the form")
    public void theUserFillOutTheForm() {
    Map<String, String> validCustomerData = validCustomer();
    for (Map.Entry<String, String> set : validCustomerData.entrySet()){
        WebElement formElement = seleniumConfig.getDriver().findElement(By.id(set.getKey()));
        new Actions(seleniumConfig.getDriver())
                .sendKeys(formElement, set.getValue())
                .perform();
        System.out.println(set.getKey() + " " + set.getValue());

    }
    }

    public Map<String, String> validCustomer(){
        Map<String, String> validCustomerMap = new HashMap<>();
        validCustomerMap.put("firstName", "Ada");
        validCustomerMap.put("lastName", "Svensen");
        validCustomerMap.put("email", "ada.svensen@epost.com");
        validCustomerMap.put("address", "Bogatan 1");
        validCustomerMap.put("country", "Sverige");
        validCustomerMap.put("city", "Köping");
        validCustomerMap.put("zip", "48700");
        validCustomerMap.put("cc-name", "Ada Svensen");
        validCustomerMap.put("cc-number", "12356");
        validCustomerMap.put("cc-expiration", "24/03");
        validCustomerMap.put("cc-cvv", "123");
        return validCustomerMap;
    }

    @When("clicks on the continue button")
    public void clicks_on_the_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be redirected to https:\\/\\/webshop-agil-testautomatiserare.netlify.app\\/checkout?paymentMethod=on")
    public void the_user_should_be_redirected_to_https_webshop_agil_testautomatiserare_netlify_app_checkout_payment_method_on() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
}
