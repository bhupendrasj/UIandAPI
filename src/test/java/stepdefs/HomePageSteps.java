package stepdefs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import methods.HomePageMethods;
import methods.utilMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static methods.DriverManager.driver;
import static org.testng.AssertJUnit.assertEquals;

public class HomePageSteps {
    @Given("the user launches the browser")
    public void theUserLaunchesTheBrowser() {
        HomePageMethods.initializeDriver();
    }

    @And("navigates to url {string}")
    public void navigatesToUrl(String url) {
        HomePageMethods.openUrl(url);
    }

    @Then("the page title should be {string}")
    public void checkPageTitle(String expectedTitle) {
        utilMethods.verifyPageTitle(expectedTitle);
    }

    @When("the user clicks on {string} button")
    public void theUserClicksOnButton(String buttonName) {
        utilMethods.clickOnTheButton(buttonName);
    }

    @Then("verify {string} is visible")
    public void verifyIsVisible(String text) {
        utilMethods.verifyTextOnPage(text);
    }

    @And("the user enters {string} name and {string} email address")
    public void theUserEntersNameAndEmailAddress(String name, String email) {
        HomePageMethods.enterNameAndEmail(name, email);
    }

    @And("the user fills details: {string} Title, {string} Name, {string} Email, {string} Password, {string} Date of birth")
    public void theUserFillsDetailsTitleNameEmailPasswordDateOfBirth(String title, String name, String email, String password, String dob) {
        HomePageMethods.enterUserDetails(title, name, email, password, dob);
    }

    @And("selects checkbox {string}")
    public void selectsCheckbox(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("fills details: {string} First name, {string} Last name, {string} Company, {string} Address, {string} Address{int}, {string} Country, {string} State, {string} City, {string} Zipcode, {string} Mobile Number")
    public void fillsDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber(String arg0, String arg1, String arg2, String arg3, String arg4, int arg5, String arg6, String arg7, String arg8, String arg9, String arg10) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}