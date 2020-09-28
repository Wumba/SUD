package exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {
    private static final Logger LOG = Logger.getLogger(Bestellung.class.getName());
    private boolean receiveInput;
    private final LinkedHashMap<Integer, Double> orderMap;
    private double sum;
    BufferedReader bufferedReader;


    public double roundDouble(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public InputReader() {
        receiveInput = true;
        orderMap = new LinkedHashMap<>();
        sum = 0;
    }

    /**
     * Read console and return input as string
     *
     * @return String
     */
    public String readDataFromConsoleToString() {
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

    public void closeReader() {
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
    public double checkAndParseDoubleInput(String input) {
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
                String doubleAsString = matcherPoint.group(0);
                return parseStringToDouble(doubleAsString);

            } else if (matcherComma.find()) {
                String doubleAsString = matcherComma.group(0);
                String processed = doubleAsString.replace(",", ".");
                return parseStringToDouble(processed);

            } else if (withoutCommaAndDotMatcher.find()) {
                String doubleAsString = withoutCommaAndDotMatcher.group(0);
                return parseStringToDouble(doubleAsString);
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
    public int checkAndParseIntegerInput(String input) {
        if (input.isEmpty()) {
            LOG.log(Level.SEVERE, "Please enter at least something!");
            return 0;
        } else {
            Pattern intPattern = Pattern.compile("\\d+");
            Matcher intMatcher = intPattern.matcher(input);

            if (intMatcher.find()) {
                String amountAsString = intMatcher.group(0);
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

    public boolean exitInput(String input) {
        switch (input) {
            case "no":
            case "nein":
            case "n":
            case "No":
            case "NO":
            case "Never":
                return false;
            default:
                return true;
        }

    }
}

