package io;

import java.util.Scanner;

public class Console {
    private static Scanner scan = new Scanner(System.in);

    public static void printWelcome() {
        System.out.println("\n" +
                "************************************************\n" +
                "***           Welcome and Bienvenue          ***\n" +
                "***                    to                    ***\n" +
                "***          ZipCo Inventory Manager         ***\n" +
                "************************************************");
    }

    public static String userInput(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }

    public static void printOut(String prompt) {
            System.out.println(prompt);
    }

    public static void printErr(String prompt) {
        System.err.println(prompt);
    }

}
