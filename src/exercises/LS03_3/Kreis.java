package exercises.LS03_3;

class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double circumference() {
        return radius*2;
    }

    public double area() {
        return 2*Math.PI*radius;
    }
}
