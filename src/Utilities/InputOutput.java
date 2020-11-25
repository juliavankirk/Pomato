package Utilities;

import java.util.Scanner;

public class InputOutput {

    private static final Scanner input = new Scanner(System.in);

    public static String inputString(String messageToUser) {
        System.out.print(messageToUser);
        String value = input.nextLine();

        return value;
    }

    public static int inputInt(String messageToUser) {
        int value = input.nextInt();
        input.nextLine();
        System.out.println(messageToUser);

        return value;
    }

    public static double inputDouble(String messageToUser) {
        double value = input.nextDouble();
        input.nextLine();
        System.out.println(messageToUser);

        return value;
    }

    public static float inputFloat(String messageToUser) {
        float value = input.nextFloat();
        input.nextLine();
        System.out.println(messageToUser);

        return value;
    }
    public static String line() {
        return "--------------------------------------------------------------------------------------------------------\n";
    }

    public static void closeScanner() {
        input.close();
    }
}
