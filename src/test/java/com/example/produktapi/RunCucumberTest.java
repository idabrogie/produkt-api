package com.example.produktapi;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/example/produktapi/resources/features",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        glue = "com.example.produktapi"
)
public class RunCucumberTest {
}