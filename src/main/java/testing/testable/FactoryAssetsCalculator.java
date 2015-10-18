package testing.testable;

import com.google.common.collect.Lists;
import testing.assets.OOFactoryAssets;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Piotrek
 */
public class FactoryAssetsCalculator {
    private final List<OOFactoryAssets> assets;

    public FactoryAssetsCalculator() {
        this.assets = Lists.newArrayList();
    }

    public BigDecimal getValueOfAllAssets() {
        BigDecimal value = BigDecimal.ZERO;
        for (OOFactoryAssets factoryAssets : assets) {
            value = value.add(factoryAssets.getValue());
        }
        return value;
    }

    public void addAsset(OOFactoryAssets asset) {
        assets.add(asset);
    }
}
