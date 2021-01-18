package exercises.LS03_3;

class Circle extends GeometricForm {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
    this.radius = checkNotNull(radius);
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    @Override
    public double circumference() {
        return 2*Math.PI*radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius,2);
    }
}
