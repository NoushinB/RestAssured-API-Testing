package core.model.quote.response;

public class QuoteCreateResponseLineDTO {
    private double discountPercentage;
    private String item;
    private int quantity;
    private double unitaryPrice;
    private double linePrice;
    private double discountAmount;

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double value) {
        this.discountPercentage = value;
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

    public double getLinePrice() {
        return linePrice;
    }

    public void setLinePrice(double value) {
        this.linePrice = value;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double value) {
        this.discountAmount = value;
    }
}