package exercises.utils.numberInputHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleInputHandler {

    public static double roundDouble(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    /**
     * Receives user input and tries find an Double in input.
     * Finding is parsed into Double.
     *
     * @param input String
     * @return Double
     */
    public double checkAndParseDoubleInput(String input) {
        Pattern doublePoint = Pattern.compile("-?\\d+\\.\\d+");
        Pattern doubleComma = Pattern.compile("-?\\d+\\,\\d+");
        Pattern withoutCommaAndDot = Pattern.compile("-?\\d+");
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
}
