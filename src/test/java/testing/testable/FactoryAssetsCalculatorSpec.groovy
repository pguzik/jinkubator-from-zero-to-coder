package testing.testable
import spock.lang.Specification
import testing.assets.OOFactoryAssets
/**
 * @author Piotrek
 */
class FactoryAssetsCalculatorSpec extends Specification {

    private final static BigDecimal VALUE_A = new BigDecimal(900);
    private final static BigDecimal VALUE_B = new BigDecimal(200);

    def "should calculate funds value" () {
        given:
            FactoryAssetsCalculator assetsCalculator = new FactoryAssetsCalculator()
            OOFactoryAssets PLAssets = Stub();
            OOFactoryAssets USAssets = Stub();

        when:
            PLAssets.getValue() >> VALUE_A
            USAssets.getValue() >> VALUE_B

            assetsCalculator.addFund(PLAssets);
            assetsCalculator.addFund(USAssets);

        then:
            assetsCalculator.valueOfAllAssets == VALUE_A.add(VALUE_B)
    }
}
