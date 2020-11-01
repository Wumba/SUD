package exercises.LS02_6;

import exercises.utils.NumberInputHandler;
import exercises.utils.UserInteractionViaConsole;

import java.util.LinkedHashMap;
import java.util.logging.Logger;

public class Bestellung implements UserInteractionViaConsole {
    private static final Logger LOG = Logger.getLogger(Bestellung.class.getName());
    private boolean receiveInput;
    private final LinkedHashMap<Integer, Double> orderMap;
    private double sum;
    NumberInputHandler numberInputHandler;

    public Bestellung() {
        receiveInput = true;
        orderMap = new LinkedHashMap<>();
        sum = 0;
        numberInputHandler = new NumberInputHandler();
    }


    /**
     * Save parsed user inputs to map
     *
     * @param amount Integer
     * @param price  Double
     */
    private void writeToMap(int amount, Double price) {
        orderMap.put(amount, price);
    }

    /**
     * Print user inputs as a list of everything and the total price of all.
     * The amount gets multiplied with the price of every single item. The sum of that is the total price.
     */
    private void printTheMap() {

        System.out.println("You ordered the following: ");
        orderMap.entrySet().stream().forEach(map -> {
            if (map.getKey() != 0) {
                System.out.println("ItemCount " + map.getKey() + "; Price " + map.getValue());
            }
        });

        System.out.println("The total price of everything is  " + this.sum);
        orderMap.entrySet().stream().forEach(map -> {
            Double aDouble = map.getKey() * map.getValue();
            add(aDouble);
        });
    }

    private void add(double aDouble) {
        this.sum = this.sum + aDouble;
    }

    @Override
    public void speakWithUser() {

        System.out.println("WELCOME TO GIJA SHOP");

        while (receiveInput) {
            int intData = 0;
            double doubleData = 0.0;

            while(intData == 0) {
                System.out.println("Please enter the amount of items:");
                String data = numberInputHandler.readDataFromConsoleToString();
                intData = numberInputHandler.checkAndParseIntegerInput(data);
            }

            while(doubleData == 0) {
                System.out.println("Please enter the belonging price for a single item.");
                String data2 = numberInputHandler.readDataFromConsoleToString();
                doubleData = numberInputHandler.checkAndParseDoubleInput(data2);
            }
            writeToMap(intData, doubleData);

            System.out.println("Would you like to enter another article? [y/n]");
            String data3 = numberInputHandler.readDataFromConsoleToString();
            this.receiveInput = numberInputHandler.exitInput(data3);
        }
        printTheMap();
        numberInputHandler.closeReader();
    }

    public static void main(String[] args) {
        Bestellung test = new Bestellung();
        test.speakWithUser();
    }

}
