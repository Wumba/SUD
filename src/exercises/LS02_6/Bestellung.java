package exercises.LS02_6;

import exercises.utils.UserInteractionInputHandler;
import exercises.utils.IUserInteractionViaConsole;
import exercises.utils.numberInputHandler.DoubleInputHandler;
import exercises.utils.numberInputHandler.IntegerInputHandler;

import java.util.LinkedHashMap;
import java.util.logging.Logger;

public class Bestellung implements IUserInteractionViaConsole {
    private static final Logger LOG = Logger.getLogger(Bestellung.class.getName());
    private boolean receiveInput;
    private final LinkedHashMap<Integer, Double> orderMap;
    private double sum;
    UserInteractionInputHandler userInteractionInputHandler;

    public Bestellung() {
        receiveInput = true;
        orderMap = new LinkedHashMap<>();
        sum = 0;
        userInteractionInputHandler = new UserInteractionInputHandler();
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
                IntegerInputHandler integerInputHandler = new IntegerInputHandler();
                System.out.println("Please enter the amount of items:");
                String data = userInteractionInputHandler.readDataFromConsoleToString();
                intData = integerInputHandler.checkAndParseIntegerInput(data);
            }

            while(doubleData == 0) {
                DoubleInputHandler doubleInputHandler = new DoubleInputHandler();
                System.out.println("Please enter the belonging price for a single item.");
                String data2 = userInteractionInputHandler.readDataFromConsoleToString();
                doubleData = doubleInputHandler.checkAndParseDoubleInput(data2);
            }
            writeToMap(intData, doubleData);

            System.out.println("Would you like to enter another article? [y/n]");
            String data3 = userInteractionInputHandler.readDataFromConsoleToString();
            this.receiveInput = userInteractionInputHandler.exitInput(data3);
        }
        printTheMap();
        userInteractionInputHandler.closeReader();
    }

    public static void main(String[] args) {
        Bestellung test = new Bestellung();
        test.speakWithUser();
    }

}
