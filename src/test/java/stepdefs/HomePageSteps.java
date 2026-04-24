package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

public class HomePageSteps {
    private WebDriver driver;

    @Given("the user navigates to the home page URL")
    public void navigateToHomePage() {
        WebDriverManager.chromedriver().setup(); // Manage ChromeDriver binary
        driver = new ChromeDriver();
        driver.get("https://example.com"); // Update URL
    }

    @When("the page loads completely")
    public void pageLoadsCompletely() {
        // Wait for page to load, e.g., wait for title
    }

    @Then("the page title should be {string}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("the main header should be visible")
    public void checkMainHeaderVisible() {
        WebElement header = driver.findElement(By.id("main-header")); // Update selector
        assertTrue(header.isDisplayed());
    }

    @Then("the footer should be displayed")
    public void checkFooterDisplayed() {
        WebElement footer = driver.findElement(By.id("footer")); // Update selector
        assertTrue(footer.isDisplayed());
    }
}
