package exercises.LS03_3;

public class TestGeometricForms {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(13.3,24.2);
        System.out.println(rectangle.area());
        System.out.println(rectangle.circumference());

        Circle circle = new Circle(34.3);
        System.out.println(circle.area());
        System.out.println(circle.circumference());
    }
}
