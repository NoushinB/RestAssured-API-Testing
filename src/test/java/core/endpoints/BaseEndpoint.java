package core.endpoints;

import core.library.JsonHelper;
import core.library.RequestType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseEndpoint {

    public Response callEndpoint(RequestSpecification request, RequestType requestType, String url, Object pojo) {
        Response response = null;

        if (pojo != null) {
            String jsonBody = JsonHelper.toJson(pojo);
            request.body(jsonBody);
        }

        switch (requestType) {
            case POST -> response = sendPOSTRequest(request, url);
            case GET -> response = sendGETRequest(request, url);
            case DELETE ->  response = sendDeleteRequest(request, url);
            case PUT -> response = sendUpdateRequest(request, url);
        }

        return response;
    }

    private Response sendPOSTRequest(RequestSpecification request, String url) {
        if (request != null) {
            return request.post(url);
        }
        return null;
    }

    private Response sendGETRequest(RequestSpecification request, String url) {
        if (request != null) {
            return request.get(url);
        }
        return null;
    }

    private Response sendDeleteRequest(RequestSpecification request, String url) {
        if (request != null) {
            return request.delete(url);
        }
        return null;
    }

    private Response sendUpdateRequest(RequestSpecification request, String url) {
        if (request != null) {
            return request.put(url);
        }
        return null;
    }

    public RequestSpecification getRequestWithJSONHeaders() {
        RequestSpecification r = RestAssured.given();
        r.header("Content-Type", "application/json");
        return r;
    }
}
