package testing.untestable

import spock.lang.Specification
import testing.tax.Address
import testing.tax.Invoice
import testing.tax.Product
import testing.tax.TaxTable
import testing.tax.User

/**
 * @author Piotrek
 */
class SalesTaxCalculatorSpec extends Specification {
    def "sales tax is calculated"() {
        given: "there is a tax table"
            SalesTaxCalculator calculator = new SalesTaxCalculator(new TaxTable())
        and: "there is an Address"
            Address address = new Address("1600 Amphitheatre Parkway...")
        and: "there is a User"
            User user = new User(address)
        and: "there is an Invoice"
            Invoice invoice = new Invoice(1, new Product(95.00f))

        when: "we calculate tax"
            float tax = calculator.computeSalesTax(user, invoice)

        then: "tax is calculated"
            tax == 4.75
    }
}
