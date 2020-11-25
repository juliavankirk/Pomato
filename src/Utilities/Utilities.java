package Utilities;

import java.util.Scanner;

public class Utilities {

    private static final Scanner scan = new Scanner(System.in);

    public static int intInput () {
        int value;
        value = scan.nextInt();
        scan.nextLine();
        return value;
    }

    public static Double doubleInput () {
        double value;
        value = scan.nextDouble();
        scan.nextLine();
        return value;
    }

    public static String stringInput () {
            return scan.nextLine();
        }

    public static float inputFloat(String messageToUser) {
        float value = scan.nextFloat();
        scan.nextLine();
        System.out.println(messageToUser);

        return value;
    }

    public static String line() {
        return "--------------------------------------------------------------------------------------------------------\n";
    }

    public static void closeScanner() {
        scan.close();
    }
}
