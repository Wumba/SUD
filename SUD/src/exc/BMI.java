package exc;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BMI {

    private boolean receiveInput;
    private InputReader inputReader;

    public BMI() {
        receiveInput = true;
        inputReader = new InputReader();
    }



    private double calculateBMI(double height, double weight) {
        Double result = (weight / Math.pow(height, height));
        return inputReader.roundDouble(result, 2);
    }

    private  checkBMIResult(double bmiResult) {
        int caloriesAllowed;
        String answer;

        if (bmiResult > 0 && bmiResult < 18.5) {
            caloriesAllowed = 3000;
            answer = "underweight";
        } else if (bmiResult >= 18.5 && bmiResult < 25) {
            caloriesAllowed = 2000;
            answer = "normal weight";
        } else if (bmiResult >= 25 && bmiResult < 30) {
            caloriesAllowed = 1800;
            answer = "overweight";
        } else if (bmiResult >= 30 && bmiResult < 40) {
            caloriesAllowed = 1200;
            answer = "obesity";
        } else {
            caloriesAllowed = 700;
            answer = "heavy obesity";
        }


    }

    private void speakWithUser() {

        System.out.println("WELCOME TO GIJA BMI CALCULATOR");

        while (receiveInput) {
            double heightData = 0.0;
            double weightData = 0.0;
            double result;

            while (heightData == 0.0) {
                System.out.println("Please enter your height in meter:");
                String data = inputReader.readDataFromConsoleToString();
                heightData = inputReader.checkAndParseDoubleInput(data);
            }

            while (weightData == 0.0) {
                System.out.println("Please enter your weight in kg:");
                String data = inputReader.readDataFromConsoleToString();
                weightData = inputReader.checkAndParseDoubleInput(data);
            }
            result = calculateBMI(heightData, weightData);
            System.out.println("Your BMI is " + result + " kg/m^2");
            checkBMIResult(result);
        }
    }
}

