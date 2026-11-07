package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import methods.DriverManager;
import methods.HomePageMethods;
import methods.utilMethods;

import java.net.MalformedURLException;

import static org.testng.AssertJUnit.assertEquals;

public class HomePageSteps {
    String response;

    @After
    public void tearDownBrowser() {
        DriverManager.quitDriver();
    }

    @Given("the user launches the browser")
    public void theUserLaunchesTheBrowser() throws MalformedURLException {
        System.out.println("Launching the browser");
        HomePageMethods.initializeDriver();
    }

    @And("navigates to url {string}")
    public void navigatesToUrl(String url) {
        System.out.println("Navigating to " + url);
        HomePageMethods.openUrl(url);
    }

    @Then("the page title should be {string}")
    public void checkPageTitle(String expectedTitle) {
        System.out.println("Checking page title");
        utilMethods.verifyPageTitle(expectedTitle);
    }

    @When("the user clicks on {string} button")
    public void theUserClicksOnButton(String buttonName) {
        System.out.println("Clicking on button " + buttonName);
        utilMethods.clickOnTheButton(buttonName);
    }

    @Then("verify {string} is visible")
    public void verifyIsVisible(String text) {
        System.out.println("Verifying " + text);
        if ("Logged in as nameKrishna".equals(text)) {
            utilMethods.dismissBlockingAdvertisement();
        }
        utilMethods.verifyTextOnPage(text);
    }

    @And("the user enters {string} name and {string} email address")
    public void theUserEntersNameAndEmailAddress(String name, String email) throws InterruptedException {
        System.out.println("Entering " + name + " " + email);
        HomePageMethods.enterNameAndEmail(name, email);
    }

    @And("the user fills details: {string} Title, {string} Name, {string} Password, {string} Date of birth")
    public void theUserFillsDetailsTitleNameEmailPasswordDateOfBirth(String title, String name, String password, String dob) throws InterruptedException {
        System.out.println("Entering " + title + " " + name + " " + password + " " + dob);
        HomePageMethods.enterUserDetails(title, name, password, dob);
    }

    @And("selects checkbox {string}")
    public void selectsCheckbox(String checkboxName) {
        System.out.println("Selecting " + checkboxName);
        HomePageMethods.selectCheckbox(checkboxName);
    }

    @And("fills details: {string} First name, {string} Last name, {string} Company, {string} Address, {string} Address2, {string} Country, {string} State, {string} City, {string} Zipcode, {string} Mobile Number")
    public void fillsDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber(String FirstName, String LastName, String Company, String Address, String Address2, String Country, String State, String City, String Zipcode, String MobileNumber) {
        System.out.println("Entering " + FirstName + " " + LastName + " " + Company + " " + Address);
        HomePageMethods.enterAddressInfo(FirstName, LastName, Company, Address, Address2, Country, State, City, Zipcode, MobileNumber);
    }
}
