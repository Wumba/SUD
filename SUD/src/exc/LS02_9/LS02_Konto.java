package exc.LS02_9;

import exc.talking.InputReader;
import exc.talking.UserInteractionViaConsole;

public class LS02_Konto implements UserInteractionViaConsole {
    InputReader inputReader = new InputReader();
    int startVal = 1000;

    @Override
    public void speakWithUser() {
        boolean contiuneInput = true;

        while (contiuneInput) {
            System.out.println("Enter the dispot for your account");
            int data = inputReader.readIntFromConsoleUntilValid();
            System.out.println();
            System.out.println("Want to run again? Type \"no\" for exit.");
            String exitString = inputReader.readDataFromConsoleToString();
            contiuneInput = inputReader.exitInput(exitString);
        }
        inputReader.closeReader();
    }


    public static void main(String[] args) {
        LS02_Teiler teiler = new LS02_Teiler();
        teiler.speakWithUser();
    }

    public int readIntFromConsoleUntilValid() {
        int inputAsInt = 0;
        while (inputAsInt == 0) {
            String inputAsString = inputReader.readDataFromConsoleToString();
            inputAsInt = inputReader.checkAndParseIntegerInput(inputAsString);
        }
        return inputAsInt;
    }


}
