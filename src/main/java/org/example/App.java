package org.example;

import java.util.Scanner;

public class App {

    static int[] elpriser = new int[24];
    static boolean priserInmatade = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.print("""
                    Elpriser
                    ========
                    1. Inmatning
                    2. Min, Max och Medel
                    3. Sortera
                    4. Bästa Laddningstid (4h)
                    e. Avsluta
                    """);

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inmatning(scanner);
                    break;

                case "2":
                    if (priserInmatade) {
                        minMaxMedel();
                    } else {
                        System.out.print("Du måste först mata in elpriser.\n");
                    }
                    break;

                case "3":

                    break;

                case "4":

                    break;

                case "e":
                    break;

                default:
                    System.out.print("Ogiltigt val, försök igen.\n");
                    break;
            }

        } while (!choice.equalsIgnoreCase("e"));

        scanner.close();
    }

    public static void minMaxMedel() {
        int min = elpriser[0];
        int max = elpriser[0];
        int minTimme = 0;
        int maxTimme = 0;
        int sum = 0;

        for (int i = 0; i < elpriser.length; i++) {
            sum += elpriser[i];
            if (elpriser[i] < min) {
                min = elpriser[i];
                minTimme = i;
            }
            if (elpriser[i] > max) {
                max = elpriser[i];
                maxTimme = i;
            }
        }

        double medel = sum / 24.0;
        System.out.printf("\nLägsta pris: %02d-%02d, %d öre/kWh", minTimme, (minTimme +1), min);
        System.out.printf("\nHögsta pris: %02d-%02d, %d öre/kWh", maxTimme, (maxTimme +1), max);
        System.out.printf("\nMedelpris: %.2f öre/kWh\n", medel);
    }


    public static void inmatning(Scanner scanner) {
        System.out.println("Mata in elpriser (i hela ören) för varje timme (00-01, 01-02, ... 23-24):");
        for (int i = 0; i < 24; i++) {
            System.out.println("Timme " + i + "-" + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Felaktig inmatning. Mata in ett heltal i ören");
                scanner.next();
            }
            elpriser[i] = scanner.nextInt();
        }
        priserInmatade = true;
        scanner.nextLine();
    }

}



