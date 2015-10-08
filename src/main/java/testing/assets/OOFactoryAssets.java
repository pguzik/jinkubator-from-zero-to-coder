package testing.assets;

import java.math.BigDecimal;

/**
 * @author Piotrek
 */
public class OOFactoryAssets {

    private CurrentValue currentValue;
    private Magazine UEMagazine;
    private Magazine USMagazine;

    public BigDecimal getValue() {
        BigDecimal value = BigDecimal.ZERO;
        value = value.add(currentValue.getValue().multiply(
            new BigDecimal(
                    UEMagazine.getNbOfUnits() + USMagazine.getNbOfUnits()
            )
        ));
        return value;
    }
}
