package testing.untestable
import spock.lang.Specification
import testing.assets.CurrentValue
import testing.assets.FactoryAssets
import testing.assets.Magazine
/**
 * @author Piotrek
 */
class FactoryAssetsCalculatorSpec extends Specification {

    private int NB_OF_UNITS_HAMMER_PL = 5;
    private int NB_OF_UNITS_SPOON_PL = 1;
    private int NB_OF_UNITS_HAMMER_US = 4;
    private int NB_OF_UNITS_SPOON_US = 1;
    private BigDecimal ASSETS_PL_VALUE = new BigDecimal(3);
    private BigDecimal ASSETS_US_VALUE = new BigDecimal(2);

    def "should calculate funds value" () {
        given:
            FactoryAssetsCalculator assetsCalculator = new FactoryAssetsCalculator()
            FactoryAssets hammerAssets = Stub()
            FactoryAssets spoonAssets = Stub()
            Magazine hammerPLMagazine = Stub()
            Magazine spoonPLMagazine = Stub()
            Magazine hammerUSMagazine = Stub()
            Magazine spoonUSMagazine = Stub()
            CurrentValue currentValueA = Stub()
            CurrentValue currentValueB = Stub()
            hammerAssets.getUEMagazine() >> hammerPLMagazine
            hammerAssets.getUSMagazine() >> hammerUSMagazine
            spoonAssets.getUEMagazine() >> spoonPLMagazine
            spoonAssets.getUSMagazine() >> spoonUSMagazine
            hammerPLMagazine.getNbOfUnits() >> NB_OF_UNITS_HAMMER_PL
            spoonPLMagazine.getNbOfUnits() >> NB_OF_UNITS_SPOON_PL
            hammerUSMagazine.getNbOfUnits() >> NB_OF_UNITS_HAMMER_US
            spoonUSMagazine.getNbOfUnits() >> NB_OF_UNITS_SPOON_US
            //Stub Returning a Stub ??? !!!
            hammerAssets.getCurrentValue() >> currentValueA
            spoonAssets.getCurrentValue() >> currentValueB
            currentValueA.getValue() >> ASSETS_PL_VALUE
            currentValueB.getValue() >> ASSETS_US_VALUE
        when:
            assetsCalculator.addFund(hammerAssets);
            assetsCalculator.addFund(spoonAssets);
        then:
            assetsCalculator.valueOfAllAssets == BigDecimal.valueOf(31)
    }
}
