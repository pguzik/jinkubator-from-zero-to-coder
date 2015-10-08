package testing.testable;

import testing.tax.Address;
import testing.tax.TaxTable;

/**
 * @author Piotrek
 */
public class SalesTaxCalculator {
    TaxTable taxTable;

    SalesTaxCalculator(TaxTable taxTable) {
        this.taxTable = taxTable;
    }

    float computeSalesTax(Address address, float amount) {
        return amount * taxTable.getTaxRate(address);
    }
}