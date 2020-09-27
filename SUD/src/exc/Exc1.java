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

    public Exc1() {
        receiveInput = true;
        orderMap = new LinkedHashMap<>();
        sum = 0;
    }

    /**
     * Read console and return input as string
     *
     * @return String
     */
    private String readDataFromConsole() {
        String output;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // todo: why does autoclosable not work? Why can't I close it at all?
        try {
            output = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.SEVERE, "Something went wrong");
            output = "Error";
        }
        return output;
    }

    private void closeReader() {
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            LOG.log(Level.SEVERE, "Reader can't be closed!");
        }
    }

    /**
     * Receives user input and tries find an Double in input.
     * Finding is parsed into Double.
     *
     * @param input String
     * @return Double
     */
    private double checkAndParsePriceInput(String input) {
        Pattern doublePoint = Pattern.compile("\\d+\\.\\d+");
        Pattern doubleComma = Pattern.compile("\\d+\\,\\d+");
        Pattern withoutCommaAndDot = Pattern.compile("\\d+");
        Matcher matcherPoint = doublePoint.matcher(input);
        Matcher matcherComma = doubleComma.matcher(input);
        Matcher withoutCommaAndDotMatcher = withoutCommaAndDot.matcher(input);

        if (input.isEmpty()) {
            LOG.log(Level.SEVERE, "Please enter at least something!");
            return 0.0;
        } else {
            if (matcherPoint.find()) {
                String priceAsString = matcherPoint.group(0);
                return parseStringToDouble(priceAsString);

            } else if (matcherComma.find()) {
                String priceAsString = matcherComma.group(0);
                String processed = priceAsString.replace(",", ".");
                return parseStringToDouble(processed);

            } else if (withoutCommaAndDotMatcher.find()) {
                String priceAsString = withoutCommaAndDotMatcher.group(0);
                return parseStringToDouble(priceAsString);
            } else {
                LOG.log(Level.SEVERE, "Please enter a number.");
                return 0.0;
            }
        }
    }

    /**
     * Receives user input and tries find an Integer in input.
     * Finding is parsed into Integer.
     *
     * @param input String
     * @return Integer
     */
    private int checkAndParseAmountInput(String input) {
        if (input.isEmpty()) {
            LOG.log(Level.SEVERE, "Please enter at least something!");
            return 0;
        } else {
            Pattern amountPattern = Pattern.compile("\\d+");
            Matcher amountMatcher = amountPattern.matcher(input);

            if (amountMatcher.find()) {
                String amountAsString = amountMatcher.group(0);
                return parseStringToInt(amountAsString);
            } else {
                LOG.log(Level.SEVERE, "Please enter a number.");
                return 0;
            }
        }
    }

    /**
     * Parse String to Double
     *
     * @param input String
     * @return Double
     */
    private double parseStringToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NullPointerException | NumberFormatException exception) {
            LOG.log(Level.SEVERE, "The format is wrong. Try to enter another price.");
            exception.printStackTrace();
            return 0.0;
        }
    }

    /**
     * Parse String to Integer
     *
     * @param input String
     * @return Integer
     */
    private int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NullPointerException | NumberFormatException exception) {
            LOG.log(Level.SEVERE, "The format is wrong or empty. Try to enter another amount.");
            exception.printStackTrace();
            return 0;
        }
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
                String data = readDataFromConsole();
                intData = checkAndParseAmountInput(data);
            }

            while(doubleData == 0) {
                System.out.println("Please enter the belonging price for a single item.");
                String data2 = readDataFromConsole();
                doubleData = checkAndParsePriceInput(data2);
            }
            writeToMap(intData, doubleData);

            System.out.println("Would you like to enter another article? [y/n]");
            String data3 = readDataFromConsole();
            exitInput(data3);
        }
        printTheMap();
        closeReader();
    }

    public static void main(String[] args) {
        Exc1 test = new Exc1();
        test.speakWithUser();
    }

}
