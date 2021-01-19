package exercises.utils;

import exercises.utils.numberInputHandler.DoubleInputHandler;
import exercises.utils.numberInputHandler.IntegerInputHandler;
import exercises.utils.numberInputHandler.LongInputHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInteractionInputHandler {
//    private static final Logger LOG = Logger.getLogger(InputReader.class.getName());
    BufferedReader bufferedReader;


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

    public long readLongFromConsoleUntilValid() {
        LongInputHandler longInputHandler = new LongInputHandler();
        long inputAsLong = 0;
        while (inputAsLong == 0) {
            String inputAsString = this.readDataFromConsoleToString();
            inputAsLong = longInputHandler.checkAndParseLongInput(inputAsString);
        }
        return inputAsLong;
    }


    public int readIntFromConsoleUntilValid() {
        IntegerInputHandler integerInputHandler = new IntegerInputHandler();
        int inputAsInt = 0;
        while (inputAsInt == 0) {
            String inputAsString = this.readDataFromConsoleToString();
            inputAsInt = integerInputHandler.checkAndParseIntegerInput(inputAsString);
        }
        return inputAsInt;
    }

    public double readDoubleFromConsoleUntilValid() {
        DoubleInputHandler doubleInputHandler = new DoubleInputHandler();
        double inputAsDouble = 0;
        while (inputAsDouble == 0) {
            String inputAsString = this.readDataFromConsoleToString();
            inputAsDouble = doubleInputHandler.checkAndParseDoubleInput(inputAsString);
        }
        return inputAsDouble;
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

    /**
     * Checks if the user want to run again through the defined method
     * @return boolean
     */
    public boolean checkRunAgain() {
        System.out.println("Want to run again? \n Type \"no\" for exit. \n Press enter to proceed.");
        String exitString = readDataFromConsoleToString();
        return exitInput(exitString);
    }
}

