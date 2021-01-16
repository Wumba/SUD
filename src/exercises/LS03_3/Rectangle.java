package exercises.LS03_3;

public class Rectangle extends GeometricForm {

    private double width;
    private double length;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("width must be over 0");
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("length must be over 0");
        }
    }


    @Override
    double circumference() {
        return length*2 + width*2;
    }

    @Override
    double area() {
        return length * width;
    }
}
