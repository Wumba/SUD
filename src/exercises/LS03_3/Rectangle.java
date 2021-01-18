package exercises.LS03_3;

public class Rectangle extends GeometricForm {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = checkNotNull(length);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = checkNotNull(width);
    }

    @Override
    double circumference() {
        return 2*length+width*2;
    }

    @Override
    public double area() {
        return length*width;
    }
}
