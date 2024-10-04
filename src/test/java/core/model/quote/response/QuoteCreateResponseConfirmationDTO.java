package core.model.quote.response;

public class QuoteCreateResponseConfirmationDTO {
    private long level;
    private String message;

    public long getLevel() {
        return level;
    }

    public void setLevel(long value) {
        this.level = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }
}