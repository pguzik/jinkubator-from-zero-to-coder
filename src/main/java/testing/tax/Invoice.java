package testing.tax;

/**
 * @author Piotrek
 */
public class Invoice {

    private float subTotal;
    private int amount;
    private Product product;

    public Invoice(int amount, Product product) {
        this.amount = amount;
        this.product = product;
        subTotal = product.getValue();
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
}
