package core.model.quote.body;

public class QuoteBodyItemDTO {
    private String item;
    private int quantity;
    private double unitaryPrice;
    private double discountPercentage;

    public QuoteBodyItemDTO() {

    }

    public QuoteBodyItemDTO(String item, int qty, double price, double discount) {
        setItem(item);
        setQuantity(qty);
        setUnitaryPrice(price);
        setDiscountPercentage(discount);
    }

    public String getItem() {
        return item;
    }

    public void setItem(String value) {
        this.item = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int value) {
        this.quantity = value;
    }

    public double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(double value) {
        this.unitaryPrice = value;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double value) {
        this.discountPercentage = value;
    }
}
