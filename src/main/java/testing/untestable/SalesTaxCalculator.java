package testing.untestable;

import testing.tax.Address;
import testing.tax.Invoice;
import testing.tax.TaxTable;
import testing.tax.User;

/**
 * @author Piotrek
 */
public class SalesTaxCalculator {
    TaxTable taxTable;

    SalesTaxCalculator(TaxTable taxTable) {
        this.taxTable = taxTable;
    }

    float computeSalesTax(User user, Invoice invoice) {
        // note that "user" is never used directly
        Address address = user.getAddress();
        float amount = invoice.getSubTotal();
        return amount * taxTable.getTaxRate(address);
    }
}