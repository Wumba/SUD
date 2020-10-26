package exc.talking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {
//    private static final Logger LOG = Logger.getLogger(InputReader.class.getName());
    BufferedReader bufferedReader;

    public double roundDouble(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    /**
     * Read console and return input as string
     *
     * @return String
     */
    public String readDataFromConsoleToString() {
        String output;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            output = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong");
            output = "Error";
        }
        return output;
    }

    public void closeReader() {
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            System.out.println("Reader can't be closed!");
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
            System.out.println("Please enter at least something!");
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
                System.out.println("Please enter a number.");
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
        int output;
        if (input.isEmpty()) {
            System.out.println("Please enter at least something!");
            output = 0;
        } else {

            Pattern intPattern = Pattern.compile("\\d+");
            Matcher intMatcher = intPattern.matcher(input);
            if (intMatcher.find()) {
                String inputAsString = intMatcher.group(0);
                output = this.parseStringToInt(inputAsString);

                if (inputAsString.length() != input.length()) {
                    System.out.println("The input \"" + input + "\" will be converted to \"" + inputAsString + "\"");
                }

            } else {
                System.out.println("Please enter a number.");
                output = 0;
            }
        }
        return output;
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
            System.out.println("The format is wrong. Try to enter another number.");
            exception.printStackTrace();
            return 0.0;
        }
    }

    public int readIntFromConsoleUntilValid() {
        int inputAsInt = 0;
        while (inputAsInt == 0) {
            String inputAsString = this.readDataFromConsoleToString();
            inputAsInt = this.checkAndParseIntegerInput(inputAsString);
        }
        return inputAsInt;
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
            System.out.println("The format is wrong or empty. Try to enter another number.");
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

