package exercises.LS03_1;

public class LS03_KFZ {
    private static final String VALID_INTERVAL = "Please enter something between 0 and ";
    private static final String HIGHER_THAN_ZERO = "Please enter something above 0.";
    private static final String STOP_CAR = "Please stop the car first.";

    private int seatsNumber;
    private int personsInCar;
    private double fuelTankVolume;
    private double fuelInTank;
    private double maxSpeed;
    private double currentSpeed;
    private double price;


    public LS03_KFZ() {
    }

    public LS03_KFZ(int seatsNumber, double fuelTankVolume, double maxSpeed, double price) {
        this();
        setSeatsNumber(seatsNumber);
        setFuelTankVolume(fuelTankVolume);
        setMaxSpeed(maxSpeed);
        setPrice(price);
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        if (seatsNumber >= 0) {
            this.seatsNumber = seatsNumber;
        } else {
            System.out.println(HIGHER_THAN_ZERO);
        }
    }

    public int getPersonsInCar() {
        return personsInCar;
    }

    public void setPersonsInCar(int personsInCar) {
        if (personsInCar <= seatsNumber && personsInCar >= 0) {
            this.personsInCar = personsInCar;
        } else {
            System.out.println(VALID_INTERVAL + seatsNumber);
        }
        this.personsInCar = personsInCar;
    }

    public double getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(double fuelTankVolume) {
        if (fuelTankVolume >= 0) {
            this.fuelTankVolume = fuelTankVolume;
        } else {
            System.out.println(HIGHER_THAN_ZERO);
        }
    }

    public double getFuelInTank() {
        return fuelInTank;
    }

    public void setFuelInTank(double fuelInTank) {
        if (fuelInTank >= fuelTankVolume && fuelInTank >= 0) {
            this.fuelInTank = fuelInTank;
        } else {
            System.out.println(VALID_INTERVAL + fuelTankVolume);
        }

    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        if (fuelInTank >= 0) {
            this.maxSpeed = maxSpeed;
        } else {
            System.out.println(HIGHER_THAN_ZERO);
        }
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed <= maxSpeed && currentSpeed >= 0) {
            this.currentSpeed = currentSpeed;
        } else {
            System.out.println(VALID_INTERVAL + maxSpeed);
        }

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (fuelInTank >= 0) {
            this.price = price;
        } else {
            System.out.println(HIGHER_THAN_ZERO);
        }
        this.price = price;
    }

    public void pumpTheBreaks() {
        this.setCurrentSpeed(this.currentSpeed - 10);
        System.out.println("The vehicle has decreased speed by 10 kmh.");
    }

    public void accelerate() {
        this.setCurrentSpeed(this.currentSpeed + 10);
        System.out.println("The vehicle has increased speed by 10 kmh.");
    }

    public void drive() {
        setCurrentSpeed(maxSpeed);
        System.out.println("The vehicle is no driving at max speed until it reaches its destination");
    }

    public void getOut(int amountPersonsToStepOutOfCar) {
        if (currentSpeed == 0) {
            setPersonsInCar(seatsNumber - amountPersonsToStepOutOfCar);
        } else {
            System.out.println(STOP_CAR);
        }
    }

    public void getIn(int amountPersonsToStepIntoCar) {
        if (currentSpeed == 0) {
            setPersonsInCar(amountPersonsToStepIntoCar);
        } else {
            System.out.println(STOP_CAR);

        }
    }

    public void fillFuelTank() {
        setFuelInTank(fuelTankVolume);
        System.out.println("The fuel tank has been filled to its full volume.");
    }

    public void printStaticValues() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("The vehicle has the following properties: ").append("\n")
                .append("Number of Seats: ").append(seatsNumber).append("\n")
                .append("Volume of Fuel Tank: ").append(fuelTankVolume).append("\n")
                .append("Max Speed: ").append(maxSpeed).append("\n")
                .append("Price: ").append(price).append("\n");
        System.out.println(stringBuilder);
    }

    public void printDynamicValues() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("The status of the vehicle is: ").append("\n")
                .append("Number of persons: ").append(personsInCar).append("\n")
                .append("Amount of fuel in the tank: ").append(fuelInTank).append("\n")
                .append("Current Speed: ").append(currentSpeed).append("\n");
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {

    }
}

