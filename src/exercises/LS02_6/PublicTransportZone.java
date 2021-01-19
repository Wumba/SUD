package exercises.LS02_6;

import exercises.utils.UserInteractionInputHandler;
import exercises.utils.IUserInteractionViaConsole;
import exercises.utils.numberInputHandler.IntegerInputHandler;

public class PublicTransportZone implements IUserInteractionViaConsole {
    private boolean receiveInput;
    private final UserInteractionInputHandler userInteractionInputHandler;

    public PublicTransportZone() {
        userInteractionInputHandler = new UserInteractionInputHandler();
        receiveInput = true;
    }

    /**
     * Transfer int numbers to a word
     * @param number int
     * @return String
     */
    public String transferIntegerToWord(int number) {
        String numberAsString;
        switch (number) {
            case 1:
                numberAsString = "one";
                break;
            case 2:
                numberAsString = "two";
                break;
            case 3:
                numberAsString = "three";
                break;
            case 4:
                numberAsString = "four";
                break;
            case 5:
                numberAsString = "five";
                break;
            case 6:
                numberAsString = "six";
                break;
            case 7:
                numberAsString = "seven";
                break;
            case 8:
                numberAsString = "eight";
                break;
            case 9:
                numberAsString = "nine";
                break;
            case 10:
                numberAsString = "ten";
                break;
            default:
                numberAsString = "0";
                break;
        }
        return numberAsString;

    }

    @Override
    public void speakWithUser() {
        System.out.println("WELCOME TO GIJA PUBLIC TRANSPORT");

        while (receiveInput) {
            int busZone = 0;
            while (busZone == 0) {
                IntegerInputHandler integerInputHandler = new IntegerInputHandler();
                System.out.println("Please enter the wished zone as a number. [1-10].");
                String data = userInteractionInputHandler.readDataFromConsoleToString();
                busZone = integerInputHandler.checkAndParseIntegerInput(data);
            }
            String numberAsWord = transferIntegerToWord(busZone);
            System.out.println("Input Zone: " + busZone + "; Output Zone: " + numberAsWord);
            System.out.println("Would you like to go again? [y/n]");
            String input = userInteractionInputHandler.readDataFromConsoleToString();
            this.receiveInput = userInteractionInputHandler.exitInput(input);
        }
    }

    public static void main(String[] args) {
        PublicTransportZone publicTransportZone = new PublicTransportZone();
        publicTransportZone.speakWithUser();
    }
}
