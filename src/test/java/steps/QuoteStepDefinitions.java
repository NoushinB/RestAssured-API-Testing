package steps;

import core.endpoints.QuoteEndpoint;
import core.library.Constants;
import core.model.quote.body.QuoteBodyDTO;
import core.model.quote.body.QuoteBodyItemDTO;
import core.model.quote.response.QuoteCreateResponseDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;

public class QuoteStepDefinitions {

    private final QuoteEndpoint quoteEndpoint = new QuoteEndpoint();
    private final StepsDataHolder dataHolder;

    public QuoteStepDefinitions(StepsDataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @Given("the quote api service is running")
    public void quoteServiceIsRunning() {
        RequestSpecification request = quoteEndpoint.getRequestWithJSONHeaders();

        quoteEndpoint.getIsAlive(request).then().statusCode(Constants.HttpCodes.SUCCESS_STATUS_CODE);
    }

    @Given("a customer {string}")
    public void a_customer(String customerName) {
        dataHolder.setQuote(new QuoteBodyDTO(customerName));
    }

    @Given("one item {string} with the quantity {int}, the unitary price {double}, and a percentage of {double}")
    public void one_item_with_the_quantity_and_the_price(String itemName, int qty, double price, double discount) {
        QuoteBodyDTO quote = dataHolder.getQuote();
        QuoteBodyItemDTO item = new QuoteBodyItemDTO(itemName, qty, price, discount);
        quote.addItem(item);
        dataHolder.setQuote(quote);
    }

    @When("I create a quote for that customer with that items")
    public void i_create_a_quote_for_that_customer_with_that_items() {
        quoteEndpoint.createQuote(dataHolder);
    }

    @Then("it returns the quote with the correct details, including the total line price calculated as {double},")
    public void it_returns_the_quote_with_the_correct_details_including_the_total_line_price_calculated_as(double totalPrice) {
        Response response = dataHolder.getResponse();

        QuoteCreateResponseDTO responseModel = quoteEndpoint.parseCreateQuoteResponseModel(response.body().asPrettyString());

        assertEquals(totalPrice, responseModel.getQuote().getTotalPrice(), 0);
    }

    @Then("it returns the quote with the correct details, including the discount amount {double} and the total lineprice {double}")
    public void it_returns_the_quote_with_the_correct_details_including_the_discount_amount_and_the_total_lineprice(double discount, double totalPrice) {
        Response response = dataHolder.getResponse();

        QuoteCreateResponseDTO responseModel = quoteEndpoint.parseCreateQuoteResponseModel(response.body().asPrettyString());

        assertEquals(discount, responseModel.getQuote().getLines().get(0).getDiscountAmount(), 0);
        assertEquals(totalPrice, responseModel.getQuote().getTotalPrice(), 0);
    }

    @Then("a confirmation message {string}")
    public void a_confirmation_message(String confirmationMessage) {
        Response response = dataHolder.getResponse();

        QuoteCreateResponseDTO responseModel = quoteEndpoint.parseCreateQuoteResponseModel(response.body().asPrettyString());

        assertEquals(confirmationMessage, responseModel.getConfirmation().getMessage());
    }

    @Then("it returns the quote with the correct details, including two lines and the total quote price calculated as {double}")
    public void itReturnsTheQuoteWithTheCorrectDetailsIncludingTwoLinesAndTheTotalQuotePriceCalculatedAsTotal_quote_price(double totalQuotePrice) {
        Response response = dataHolder.getResponse();

        QuoteCreateResponseDTO responseModel = quoteEndpoint.parseCreateQuoteResponseModel(response.body().asPrettyString());

        assertEquals(2, responseModel.getQuote().getLines().size());
        assertEquals(totalQuotePrice, responseModel.getQuote().getTotalPrice(), 0);
    }

    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int statusCode) {
        Response response = dataHolder.getResponse();

        response.then().statusCode(statusCode);
    }

    @And("the error message {string}")
    public void theErrorMessage(String errorMessage) {
        Response response = dataHolder.getResponse();

        assertEquals(errorMessage, response.body().asPrettyString());
    }
}
