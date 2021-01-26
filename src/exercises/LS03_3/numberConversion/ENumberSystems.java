package exercises.LS03_3.numberConversion;

public enum ENumberSystems {
    HEXADECIMAL(16),
    OCTAL(8),
    DECIMAL(10),
    BINARY(2);

    private final int base;

    ENumberSystems(int value) {
        this.base = value;
    }

    public int toInt() {
        return this.base;
    }

}
