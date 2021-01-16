package exercises.LS03_3;

public class Dot {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (x <= 0 && x <= 100) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("x value must be between 0 and 100");
        }
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (y <= 0 && y <= 100) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("y value must be between 0 and 100");
        }
    }

    public void moveDot(double x, double y) {
        try {
            setX(this.x + x);
            setY(this.y + y);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
