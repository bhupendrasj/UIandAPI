package methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiMethods {

    private String baseUrl;

    private Response response;

    private Map<String, String> headers = new HashMap<>();


    // SET URL
    public void setBaseUrl(String url) {
        this.baseUrl = url;
    }

    public void setBaseUrl() {
        this.baseUrl = ConfigReader.get("base.url");
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
                .queryParam("page", 2)
                .when()
                .get(baseUrl + "/api/users");
    }


    // VALIDATE STATUS CODE
    public void validateStatusCode(int expectedStatusCode) {
        assertEquals(
                response.getStatusCode(),
                expectedStatusCode,
                "Status code validation failed");
    }

    public void validatePagination() {
        assertEquals(response.jsonPath().getInt("page"), 2,
                "Response page should be 2");
        assertTrue(response.jsonPath().getInt("total_pages") >= 2,
                "Response should report at least two pages");
        assertTrue(response.jsonPath().getList("data").size() > 0,
                "Page 2 should contain users");
    }


    // PRINT RESPONSE
    public void printResponse() {
        System.out.println("Response Body:");
        System.out.println(response.getBody().asPrettyString());
    }

    public void addHeaders() {
        Properties properties = ConfigReader.getProperties();
        for (String key : properties.stringPropertyNames()) {
            if (key.startsWith("headers.")) {
                String headerName =
                        key.replace("headers.", "");
                String headerValue =
                        properties.getProperty(key);
                System.out.println(headerName + ": " + headerValue);
                headers.put(headerName, headerValue);
            }
        }
    }
}
