package exercises.LS03_3.numberConversion;

public enum ENumberSystems {
    HEXA(6),
    OCTA(8),
    DECI(10),
    BINARY(2);

    private int base;

    ENumberSystems(int value) {
        this.base = value;
    }

    public int toInt() {
        return this.base;
    }

}
