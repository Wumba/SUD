package exc1;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class IfCondition {

    LinkedHashMap<Double, Double> orderMap = new LinkedHashMap<Double, Double>();

    public void getUserInput() {


        double price = 0;
        double productAmount = 0;
        String	continueChecker = "";

        while(!continueChecker.equals("ja")) {

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
        IfCondition bla = new IfCondition();
        bla.consoleInput();
    }

}
