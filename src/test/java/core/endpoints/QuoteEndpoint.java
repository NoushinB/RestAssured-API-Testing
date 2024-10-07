package core.endpoints;

import core.library.JsonHelper;
import core.library.PropertyLoader;
import core.library.RequestType;
import core.model.quote.body.QuoteBodyDTO;
import core.model.quote.response.QuoteCreateResponseDTO;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.StepsDataHolder;

public class QuoteEndpoint extends BaseEndpoint {

    private final String QUOTE_BASE_URL = PropertyLoader.getInstance().getBaseUrl() + "api/Quotes/";

    public Response getIsAlive(RequestSpecification request) {
        String url = QUOTE_BASE_URL + "isalive";
        return callEndpoint(request, RequestType.GET, url, null);
    }

    public void createQuote(StepsDataHolder dataHolder) {
        dataHolder.setRequest(getRequestWithJSONHeaders());
        dataHolder.setResponse(postCreateQuote(dataHolder.getRequest(), dataHolder.getQuote()));
    }

    public Response postCreateQuote(RequestSpecification request, QuoteBodyDTO quote) {
        String url = QUOTE_BASE_URL + "create";
        return callEndpoint(request, RequestType.POST, url, quote);
    }

    public QuoteCreateResponseDTO parseCreateQuoteResponseModel(String json) {
        return JsonHelper.fromJson(json, QuoteCreateResponseDTO.class);
    }
}
