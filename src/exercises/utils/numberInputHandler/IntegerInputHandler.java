package exercises.utils.numberInputHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerInputHandler {

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
}
