package test;

import java.util.Scanner;

public class ScannerTry {
    public static void main (String[] args)
    {
        double zahl;
        Scanner scan = new Scanner( System.in );

        System.out.print("Geben Sie ein double ein: ");
        zahl = scan.nextDouble();

        System.out.println("zahl: " + zahl + " zahl * 2: " + 2.0*zahl );
    }
}
