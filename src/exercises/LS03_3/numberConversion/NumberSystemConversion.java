package exercises.LS03_3.numberConversion;

import exercises.utils.UserInteractionInputHandler;

public class NumberSystemConversion {

    UserInteractionInputHandler userInteractionInputHandler = new UserInteractionInputHandler();


    private ENumberSystems chooseBase() {
       ENumberSystems startBase = null;
        while (startBase == null) {
            System.out.println("Please enter a number system [binary, octa, deci, hex]");
            String input = userInteractionInputHandler.readDataFromConsoleToString();
            switch (input) {
                case "binary", "2" -> {
                    startBase = ENumberSystems.BINARY;
                }
                case "octa", "8" -> {
                    startBase =  ENumberSystems.OCTA;
                }
                case "deci", "10" -> {
                    startBase =  ENumberSystems.DECI;
                }
                case "hex", "16" -> {
                    startBase =  ENumberSystems.HEXA;
                }
                default -> System.out.println("This number system does not exist. Please try again.");
            }
        }
        return startBase;
    }

    public static String baseConversion(String number,
                                        ENumberSystems previousBase, ENumberSystems newBase) {
        int fromString = Integer.parseInt(number, previousBase.toInt());
        return Integer.toString(fromString, newBase.toInt());
    }



    public void speakWithUser() {
        System.out.println("please enter a number of one of the following number systems: hex, octa, deci or binary");
        String inputNumber = userInteractionInputHandler.readDataFromConsoleToString();

    }
}


