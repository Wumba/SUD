package exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exc1 {
    private static final Logger LOG = Logger.getLogger(Exc1.class.getName());
    private boolean receiveInput;
    private final LinkedHashMap<Integer, Double> orderMap;
    private double sum;
    BufferedReader bufferedReader;
    InputReader inputReader;

    public Exc1() {
        receiveInput = true;
        orderMap = new LinkedHashMap<>();
        sum = 0;
        inputReader = new InputReader();
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

    private void exitInput(String input) {
        switch (input) {
            case "no":
            case "nein":
            case "n":
            case "No":
            case "NO":
            case "Never":
                this.receiveInput = false;
                break;
            default:
                this.receiveInput = true;
                break;
        }

    }

    private void speakWithUser() {

        System.out.println("WELCOME TO GIJA SHOP");

        while (receiveInput) {
            int intData = 0;
            double doubleData = 0.0;

            while(intData == 0) {
                System.out.println("Please enter the amount of items:");
                String data = inputReader.readDataFromConsoleToString();
                intData = inputReader.checkAndParseIntegerInput(data);
            }

            while(doubleData == 0) {
                System.out.println("Please enter the belonging price for a single item.");
                String data2 = inputReader.readDataFromConsoleToString();
                doubleData = inputReader.checkAndParseDoubleInput(data2);
            }
            writeToMap(intData, doubleData);

            System.out.println("Would you like to enter another article? [y/n]");
            String data3 = inputReader.readDataFromConsoleToString();
            exitInput(data3);
        }
        printTheMap();
        inputReader.closeReader();
    }

    public static void main(String[] args) {
        Exc1 test = new Exc1();
        test.speakWithUser();
    }

}
