package exercises.LS03_3;

class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new IllegalArgumentException("Radius must be above 0");
        }
    }

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
