package api.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.Map;

public class ApiClient {

    public Response post(
            String baseUrl,
            String endpoint,
            Map<String, String> headers,
            Object body) {

        return given()
                .headers(headers)
                .body(body)
                .when()
                .post(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }

    public Response get(
            String baseUrl,
            String endpoint,
            Map<String, String> headers,
            Map<String, Object> queryParams,
            Map<String, Object> pathParams) {

        return given()
                .headers(headers)
                .queryParams(queryParams)
                .pathParams(pathParams)
                .when()
                .get(baseUrl + endpoint)
                .then()
                .extract()
                .response();
    }
}