package testing.assets;

/**
 * @author Piotrek
 */
public class FactoryAssets {
    private CurrentValue currentValue;
    private Magazine UEMagazine;
    private Magazine USMagazine;

    public CurrentValue getCurrentValue() {
        return currentValue;
    }


    public Magazine getUEMagazine() {
        return UEMagazine;
    }

    public void setUEMagazine(Magazine UEMagazine) {
        this.UEMagazine = UEMagazine;
    }

    public Magazine getUSMagazine() {
        return USMagazine;
    }

    public void setUSMagazine(Magazine USMagazine) {
        this.USMagazine = USMagazine;
    }
}
