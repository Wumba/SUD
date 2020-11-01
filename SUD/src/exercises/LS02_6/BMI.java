package exercises.LS02_6;


import exercises.utils.NumberInputHandler;
import exercises.utils.UserInteractionViaConsole;

public class BMI implements UserInteractionViaConsole {

    private boolean receiveInput;
    private final NumberInputHandler numberInputHandler;

    public BMI() {
        receiveInput = true;
        numberInputHandler = new NumberInputHandler();
    }


    /**
     * Formula to calculate BMI
     * @param height double
     * @param weight double
     * @return double
     */
    private double calculateBMI(double height, double weight) {
        double result = (weight / Math.pow(height, height));
        return numberInputHandler.roundDouble(result, 2);
    }

    private BMIResultPair checkBMIResult(double bmiResult) {
        BMIResultPair pair = new BMIResultPair();

        if (bmiResult > 0 && bmiResult < 18.5) {
            pair.setCaloriesAllowed(3000);
            pair.setAnswer("underweight");
        } else if (bmiResult >= 18.5 && bmiResult < 25) {
            pair.setCaloriesAllowed(2000);
            pair.setAnswer("normal weight");
        } else if (bmiResult >= 25 && bmiResult < 30) {
            pair.setCaloriesAllowed(1800);
            pair.setAnswer("overweight");
        } else if (bmiResult >= 30 && bmiResult < 40) {
            pair.setCaloriesAllowed(1200);
            pair.setAnswer("obesity");
        } else {
            pair.setCaloriesAllowed(700);
            pair.setAnswer("heavy obesity");
        }
    return pair;
    }

    /**
     * User Interaction via Console
     */
    @Override
    public void speakWithUser() {

        System.out.println("WELCOME TO GIJA BMI CALCULATOR");

        while (receiveInput) {
            double heightData = 0.0;
            double weightData = 0.0;
            double result;

            while (heightData == 0.0) {
                System.out.println("Please enter your height in meter:");
                String data1 = numberInputHandler.readDataFromConsoleToString();
                heightData = numberInputHandler.checkAndParseDoubleInput(data1);
            }

            while (weightData == 0.0) {
                System.out.println("Please enter your weight in kg:");
                String data2 = numberInputHandler.readDataFromConsoleToString();
                weightData = numberInputHandler.checkAndParseDoubleInput(data2);
            }
            result = calculateBMI(heightData, weightData);
            System.out.println("Your BMI is " + result + " kg/m^2");
            System.out.println(checkBMIResult(result).getAnswer());
            System.out.println("You should eat " + checkBMIResult(result).getCaloriesAllowed() + " kcal per day.");
            System.out.println("Want to calculate again? (maybe it gets better...) [y/n]");
            String input = numberInputHandler.readDataFromConsoleToString();
            this.receiveInput = numberInputHandler.exitInput(input);
        }
    }

    public static void main(String[] args) {
        BMI bmi = new BMI();
        bmi.speakWithUser();
    }
}

