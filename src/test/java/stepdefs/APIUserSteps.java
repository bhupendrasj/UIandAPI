package stepdefs;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import methods.ApiMethods;

public class APIUserSteps {

    ApiMethods apiMethods = new ApiMethods();

    @Given("the user uses the URL {string}")
    public void the_user_uses_the_url(String url) {
        apiMethods.setBaseUrl(url);
    }

    @And("the user updates the header {string} with value {string}")
    public void the_user_updates_the_header_with_value(
            String headerKey,
            String headerValue) {

        apiMethods.addHeader(headerKey, headerValue);
    }

    @When("the user triggers the GET API")
    public void the_user_triggers_the_get_api() {
        apiMethods.executeGetRequest();
    }

    @Then("the status code should be {int} OK")
    public void the_status_code_should_be_ok(Integer expectedStatusCode) {
        apiMethods.validateStatusCode(expectedStatusCode);
    }

    @And("the user prints the response")
    public void the_user_prints_the_response() {
        apiMethods.printResponse();
    }

    @And("the user updates the header")
    public void theUserUpdatesTheHeader() {
        apiMethods.addHeaders();
    }

    @Given("the user sets URL")
    public void theUserSetsURL() {
        apiMethods.setBaseUrl();
    }
}