package core.model.quote.response;

import java.util.List;

public class QuoteCreateResponseQuoteDTO {
    private double totalPrice;
    private String id;
    private List<QuoteCreateResponseLineDTO> lines;
    private String customer;
    private long revision;
    private long status;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double value) {
        this.totalPrice = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public List<QuoteCreateResponseLineDTO> getLines() {
        return lines;
    }

    public void setLines(List<QuoteCreateResponseLineDTO> value) {
        this.lines = value;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String value) {
        this.customer = value;
    }

    public long getRevision() {
        return revision;
    }

    public void setRevision(long value) {
        this.revision = value;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long value) {
        this.status = value;
    }
}
