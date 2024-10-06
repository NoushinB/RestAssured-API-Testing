package steps;

import core.model.quote.body.QuoteBodyDTO;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepsDataHolder {

    private Response response;
    private RequestSpecification request;
    private QuoteBodyDTO quote;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response value) {
        this.response = value;
    }

    public RequestSpecification getRequest() {
        return request;
    }

    public void setRequest(RequestSpecification value) {
        this.request = value;
    }

    public QuoteBodyDTO getQuote() {
        return quote;
    }

    public void setQuote(QuoteBodyDTO value) {
        this.quote = value;
    }
}
