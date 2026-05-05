package methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ApiMethods {

    private String baseUrl;

    private Response response;

    private Map<String, String> headers = new HashMap<>();


    // SET URL
    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }


    // ADD HEADER
    public void addHeader(String key, String value) {
        headers.put(key, value);
    }


    // EXECUTE GET API
    public void executeGetRequest() {
        response = RestAssured
                .given()
                .headers(headers)
                .when()
                .get(baseUrl);
    }


    // VALIDATE STATUS CODE
    public void validateStatusCode(int expectedStatusCode) {

        assertEquals(
                response.getStatusCode(),
                expectedStatusCode,
                "Status code validation failed");
    }


    // PRINT RESPONSE
    public void printResponse() {

        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
    }
}