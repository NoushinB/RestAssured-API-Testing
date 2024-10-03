package core.model.quote.body;

import java.util.ArrayList;
import java.util.List;

public class QuoteBodyDTO {

    private String customer;
    private List<QuoteBodyItemDTO> items;

    public QuoteBodyDTO(String customer) {
        setCustomer(customer);
    }

    public QuoteBodyDTO(QuoteBodyItemDTO item) {
        addItem(item);
    }

    public QuoteBodyDTO(String customer, List<QuoteBodyItemDTO> items) {
        setCustomer(customer);
        setItems(items);
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String value) {
        this.customer = value;
    }

    public List<QuoteBodyItemDTO> getItems() {
        return items;
    }

    public void setItems(List<QuoteBodyItemDTO> value) {
        this.items = value;
    }

    public void addItem(QuoteBodyItemDTO item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }
}

