package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = "src/test/resources/features/HomePage.feature",
    glue = "stepdefs",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class HomePageTest extends AbstractTestNGCucumberTests {
}
