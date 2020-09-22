package exc1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exc1 {

    LinkedHashMap<Double, Double> orderMap = new LinkedHashMap<Double, Double>();
    Logger LOG = Logger.getLogger(Exc1.class.getName());

    private String readDataAndPare() {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = bufferedReader.readLine();
            return name;
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.SEVERE, "Die Eingabe ist gesheitert");
            return "Error";
        }
    }

    private double parseInputToDouble(String input) {
        Pattern doublePoint = Pattern.compile("\\d+\\.\\d+");
        Pattern doubleComma = Pattern.compile("\\d+\\,\\d+");
        Matcher matcherPoint = doublePoint.matcher(input);
        Matcher matcherComma = doublePoint.matcher(input);

        if (m.find()) {
            String priceAsString = m.group(0);
            return Double.parseDouble(priceAsString);
        } else {

        }




    }

    private void handleUserInput() {


        double price = 0;
        double productAmount = 0;
        String continueChecker = "";

        while (!continueChecker.equals("ja")) {


            System.out.println("Geben sie einen Preis ohne Eurozeichen ein.");
            try {
                Scanner userInputScanner = new Scanner(System.in);
                price = userInputScanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Der Preis kann nicht eingelesen werden. \n"
                        + " Bitte geben sie einen einen Wert als Zahl ein."
                        + " Nachkommastellen bitte mit Punkt trennen.");
                e.printStackTrace();
            }

            System.out.println("Geben Sie Bestellmenge an.");
            try {
                Scanner userInputScanner = new Scanner(System.in);
                productAmount = userInputScanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Die Produktmenge kann nicht eingelesen werden. \n"
                        + " Bitte geben sie einen einen Wert als Zahl ein. \n"
                        + " Nachkommastellen bitte mit Punkt trennen.");
                e.printStackTrace();
            }

            System.out.println("M�chten Sie weitermachen(Enter) oder abbrechen(\"ja\")");
            try {
                Scanner userInputScanner = new Scanner(System.in);
                continueChecker = userInputScanner.nextLine();
            } catch (Exception e) {
                System.out.println("Es gibt einen Fehler bei der Eingabe.");
                e.printStackTrace();
            } finally {
                userInputScanner.close();
            }


            orderMap.put(productAmount, price);
        }

        userInputScanner.close();
    }


    public void consoleInput() {
        System.out.println("Willkommen bei GIJA-SHOP!");
        System.out.println("Geben Sie nachfolgend Ihre Produkt-Preise und -Mengen ein.");
        System.out.println("Dr�cken Sie bei einer Eingaben Enter, um das Programm zu beenden.");

        this.getUserInput();

    }

    public static void main(String[] args) {
        Exc1 bla = new Exc1();
        bla.consoleInput();
    }

}
