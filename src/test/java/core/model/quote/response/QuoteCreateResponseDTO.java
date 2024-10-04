package core.model.quote.response;

public class QuoteCreateResponseDTO {
    private QuoteCreateResponseQuoteDTO quote;
    private QuoteCreateResponseConfirmationDTO confirmation;

    public QuoteCreateResponseQuoteDTO getQuote() {
        return quote;
    }

    public void setQuote(QuoteCreateResponseQuoteDTO value) {
        this.quote = value;
    }

    public QuoteCreateResponseConfirmationDTO getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(QuoteCreateResponseConfirmationDTO value) {
        this.confirmation = value;
    }
}






