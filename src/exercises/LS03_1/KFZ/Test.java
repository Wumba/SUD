package exercises.LS03_1.KFZ;

public class Test {

    public static void main(String[] args) {
        LS03_KFZ kfz = new LS03_KFZ();
        LS03_KFZ alexCar = new LS03_KFZ(5,2,200,20);
        System.out.println(kfz);
        alexCar.setCurrentSpeed(45);
        alexCar.setPersonsInCar(3);
        alexCar.accelerate();
        alexCar.accelerate();
        alexCar.accelerate();
        alexCar.driveAtMaxSpeed();
        alexCar.pumpTheBreaks();
        alexCar.fillFuelTank();

    }
}
