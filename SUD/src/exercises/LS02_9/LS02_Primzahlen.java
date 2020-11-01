package exercises.LS02_9;

import exercises.utils.NumberInputHandler;
import exercises.utils.UserInteractionViaConsole;

public class LS02_Primzahlen implements UserInteractionViaConsole {
    NumberInputHandler numberInputHandler = new NumberInputHandler();

    @Override
    public void speakWithUser() {
        boolean repeat;
        System.out.println("Welcome to GIJA prime number checker.");

        do {
            System.out.println("Please enter a whole number to check.");
            long inputNumber = numberInputHandler.readLongFromConsoleUntilValid();
            if(checkIfPrimeNumber(inputNumber)) {
                System.out.println(inputNumber + " is a prime number.");
            } else {
                System.out.println(inputNumber + " is not a prime number.");
            }
            repeat = numberInputHandler.checkRunAgain();
        } while (repeat);
    }

    private boolean checkIfPrimeNumber(long inputNumber) {
        long remainder = 1;
        long i = 2;

        for (i = 2; i < inputNumber && remainder != 0; i++) {
            remainder = inputNumber % i;
            System.out.println("i:" + i + " ;remainder: " + remainder);
        }
        return remainder != 0;
    }

    public static void main(String[] args) {
        LS02_Primzahlen primeNumbers = new LS02_Primzahlen();
        primeNumbers.speakWithUser();
    }
}
