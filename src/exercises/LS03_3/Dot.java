package exercises.LS03_3;

public class Dot {
    private double x;
    private double y;
    private final int lowerBorder = -100;
    private final int upperBorder = 100;
    private final String errorMessage = "value must be between " + lowerBorder + " and "  + upperBorder;


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        if (checkBorder(x)) {
            this.x = x;
        } else {
            throw new IllegalArgumentException("x " + errorMessage);
        }
    }

    public void setY(double y) {
        if (checkBorder(y)) {
            this.y = y;
        } else {
            throw new IllegalArgumentException("y " + errorMessage);
        }
    }

    public Dot() {
        this.x = 0;
        this.y = 0;
    }

    private boolean checkBorder(double value) {
        return value >= lowerBorder && value <= upperBorder;
    }

    public void moveDot(double x, double y) {
        try {
            setX(this.x + x);
            setY(this.y + y);
        } catch (IllegalArgumentException e) {
            System.out.println("");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[" + x + "|" + y + "]";
    }

    public static void main(String[] args) {
        Dot dot = new Dot();
        dot.moveDot(234, 34);
        System.out.println(dot);
    }
}
