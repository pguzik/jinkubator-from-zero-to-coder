package testing.assets;

import java.math.BigDecimal;

/**
 * @author Piotrek
 */
public class CurrentValue {
    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
