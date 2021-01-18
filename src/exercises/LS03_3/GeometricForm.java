package exercises.LS03_3;

abstract class GeometricForm {

    abstract double circumference();
    abstract double area();

    protected double checkNotNull(double value) {
        if (value > 0) {
            return value;
        } else {
            throw new IllegalArgumentException("value cannot be null");
        }
    }

}
