package exercises.LS02_9;
import exercises.utils.*;
import exercises.utils.numberInputHandler.IntegerInputHandler;


public class LS02_Teiler implements IUserInteractionViaConsole {
    UserInteractionInputHandler userInteractionInputHandler = new UserInteractionInputHandler();

    @Override
    public void speakWithUser() {
        boolean contiuneInput = true;
        while (contiuneInput) {
            System.out.println("Please enter a number.");
            int inputAsInt = 0;
            while (inputAsInt == 0) {
                IntegerInputHandler integerInputHandler = new IntegerInputHandler();
                String inputAsString = userInteractionInputHandler.readDataFromConsoleToString();
                inputAsInt = integerInputHandler.checkAndParseIntegerInput(inputAsString);
            }
            System.out.println(this.divideAndConquer(inputAsInt).toString());
            System.out.println("Want to run again? Type \"no\" for exit.");
            String exitString = userInteractionInputHandler.readDataFromConsoleToString();
            contiuneInput = userInteractionInputHandler.exitInput(exitString);
        }
        userInteractionInputHandler.closeReader();
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
