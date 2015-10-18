package testing.untestable;

import com.google.common.collect.Lists;
import testing.assets.FactoryAssets;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Piotrek
 */
public class FactoryAssetsCalculator {
    private final List<FactoryAssets> assets;

    public FactoryAssetsCalculator() {
        this.assets = Lists.newArrayList();
    }

    public BigDecimal getValueOfAllAssets() {
        BigDecimal value = BigDecimal.ZERO;
        for (FactoryAssets factoryAssets : assets) {
            value = value.add(factoryAssets.getCurrentValue().getValue().multiply(
                new BigDecimal(
                        factoryAssets.getUEMagazine().getNbOfUnits()
                                + factoryAssets.getUSMagazine().getNbOfUnits()
                )
            ));
        }
        return value;
    }

    public void addAsset(FactoryAssets asset) {
        assets.add(asset);
    }
}
