package exc;

public class PublicTransportZone {
    private boolean receiveInput;
    private final InputReader inputReader;

    public  PublicTransportZone() {
        inputReader = new InputReader();
        receiveInput = true;
    }

    public String transferIntegerToWord(int number) {
        String numberAsString;
        switch(number) {
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

    private void speakWithUser() {
        System.out.println("WELCOME TO GIJA PUBLIC TRANSPORT");

        while (receiveInput) {
            int busZone = 0;
            while (busZone == 0) {
                System.out.println("Please enter the wished zone as a number. [1-10].");
                String data = inputReader.readDataFromConsoleToString();
                busZone = inputReader.checkAndParseIntegerInput(data);
            }
            String numberAsWord = transferIntegerToWord(busZone);
            System.out.println("Input Zone: " + busZone + "; Output Zone: " + numberAsWord);
            System.out.println("Would you like to go again? [y/n]");
            String input = inputReader.readDataFromConsoleToString();
            this.receiveInput = inputReader.exitInput(input);
        }
    }

    public static void main(String[] args) {
        PublicTransportZone publicTransportZone = new PublicTransportZone();
        publicTransportZone.speakWithUser();
    }
}
