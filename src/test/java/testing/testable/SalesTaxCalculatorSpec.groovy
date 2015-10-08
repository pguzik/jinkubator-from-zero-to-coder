package testing.testable
import spock.lang.Specification
import testing.tax.Address
import testing.tax.TaxTable

/**
 * @author Piotrek
 */
class SalesTaxCalculatorSpec extends Specification {

    def "sales tax is calculated"() {
        given: "there is a tax table"
            SalesTaxCalculator calculator = new SalesTaxCalculator(new TaxTable())
        and: "there is an Address"
            Address address = new Address("1600 Amphitheatre Parkway...")

        when: "we calculate tax"
            float tax = calculator.computeSalesTax(address, 95.00f)

        then: "tax is calculated"
            tax == 4.75
    }
}
