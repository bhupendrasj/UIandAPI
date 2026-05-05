package api.services;

import api.client.ApiClient;
import api.endpoints.UserEndpoints;
import api.models.UserRequest;
import io.restassured.response.Response;
import methods.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    ApiClient apiClient = new ApiClient();

    public Response createUser(UserRequest request) {

        Map<String, String> headers = new HashMap<>();

        headers.put("Content-Type", "application/json");
        headers.put("x-api-key", ConfigReader.get("api.key"));

        return apiClient.post(
                ConfigReader.get("base.url"),
                UserEndpoints.CREATE_USER,
                headers,
                request);
    }

    public Response getUser(int userId) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("id", userId);

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("delay", 2);

        return apiClient.get(
                ConfigReader.get("base.url"),
                UserEndpoints.GET_USER,
                headers,
                queryParams,
                pathParams);
    }
}