package exercises.LS03_3.numberConversion;

import exercises.utils.UserInteractionInputHandler;

public class NumberSystemConversion {

    private UserInteractionInputHandler userInteractionInputHandler = new UserInteractionInputHandler();


    private ENumberSystems chooseBase(String text) {
        ENumberSystems startBase = null;
        while (startBase == null) {
            System.out.println(text);
            String input = userInteractionInputHandler.readDataFromConsoleToString();
            switch (input) {
                case "binary", "2" -> startBase = ENumberSystems.BINARY;
                case "octa", "8" -> startBase = ENumberSystems.OCTA;
                case "deci", "10" -> startBase = ENumberSystems.DECI;
                case "hex", "16" -> startBase = ENumberSystems.HEXA;
                case "" -> System.out.println("Please enter something!");
                default -> System.out.println("This number system does not exist. Please try again.");
            }
        }
        return startBase;
    }

    public static String baseConversion(String number,
                                        ENumberSystems previousBase, ENumberSystems newBase) {
        boolean repeat = true;
        int parsedInt = 0;
        while (repeat) {
            try {
                parsedInt = Integer.parseInt(number, previousBase.toInt());
                repeat = false;
            } catch (NumberFormatException e) {
                System.out.println("The number system and the number doesn't match. Please try again");
            }
        }

        String convertedString = "";
        repeat = true;
        while (repeat) {
            try {
                convertedString = Integer.toString(parsedInt, newBase.toInt());
                repeat = false;
            } catch (NumberFormatException e) {
                System.out.println("The number could not converted. Please try again.");
            }
        }

        return convertedString;
    }


    public void speakWithUser() {
        System.out.println("Please enter a number from the number systems: hex, octa, deci or binary");
        String inputNumber = userInteractionInputHandler.readDataFromConsoleToString();
        ENumberSystems inputNumberBase = chooseBase("Please enter a number system [binary, octa, deci, hex]");
        ENumberSystems goalNumberSystem = chooseBase("Please enter the wished number system you want to convert in [binary, octa, deci, hex].");
        String convertedNumber = baseConversion(inputNumber, inputNumberBase, goalNumberSystem);
        System.out.println("number: "
                + inputNumber
                + "; system: "
                + inputNumberBase
                + " -> "
                + "converted number: "
                + convertedNumber
                + "; system: "
                + goalNumberSystem);
    }
}


