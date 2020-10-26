package exc.LS02_9;

import exc.talking.*;

import java.sql.SQLOutput;

public class LS02_Teiler implements UserInteractionViaConsole {
    InputReader inputReader = new InputReader();

    @Override
    public void speakWithUser() {
        System.out.println("Please enter a number.");
        int inputAsInt = 0;
        while (inputAsInt == 0) {
            String inputAsString = inputReader.readDataFromConsoleToString();
            inputAsInt = inputReader.checkAndParseIntegerInput(inputAsString);
        }
        System.out.println(this.divideAndConquer(inputAsInt).toString());
        System.out.println("Want to run again? [y/n]");
        inputReader.readDataFromConsoleToString()
    }

    public StringBuilder divideAndConquer(int input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("The possible divisors are")
                .append("\n");
        for (int i = 1; i <= input; i++) {
            int remainder = input % i;
            if (remainder == 0) {
                stringBuilder
                        .append(i)
                        .append(", ");
            }
        }
        return stringBuilder;
    }

    public static void main(String[] args) {
        LS02_Teiler teiler = new LS02_Teiler();
        teiler.speakWithUser();
    }

}
