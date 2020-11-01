package exercises.LS02_9;
import exercises.utils.*;


public class LS02_Teiler implements UserInteractionViaConsole {
    NumberInputHandler numberInputHandler = new NumberInputHandler();

    @Override
    public void speakWithUser() {
        boolean contiuneInput = true;
        while (contiuneInput) {
            System.out.println("Please enter a number.");
            int inputAsInt = 0;
            while (inputAsInt == 0) {
                String inputAsString = numberInputHandler.readDataFromConsoleToString();
                inputAsInt = numberInputHandler.checkAndParseIntegerInput(inputAsString);
            }
            System.out.println(this.divideAndConquer(inputAsInt).toString());
            System.out.println("Want to run again? Type \"no\" for exit.");
            String exitString = numberInputHandler.readDataFromConsoleToString();
            contiuneInput = numberInputHandler.exitInput(exitString);
        }
        numberInputHandler.closeReader();
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
