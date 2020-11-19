package tool;

import java.util.Scanner;

public class InputOutput {

    private static final Scanner input = new Scanner(System.in);

    public static String inputString(String messageToUser) {
        System.out.print(messageToUser);
        String inputResult = input.nextLine();

        return inputResult;
    }

    public static int inputInt(String messageToUser) {
        int inputResult = input.nextInt();
        input.nextLine();
        System.out.println(messageToUser);

        return inputResult;
    }

    public static double inputDouble(String messageToUser) {
        double inputResult = input.nextDouble();
        input.nextLine();
        System.out.println(messageToUser);

        return inputResult;
    }

    public static boolean inputBoolean(String messageToUser) {
        boolean inputResult = input.nextBoolean();
        input.nextLine();
        System.out.println(messageToUser);

        return inputResult;
    }

    public static float inputFloat(String messageToUser) {
        float inputResult = input.nextFloat();
        input.nextLine();
        System.out.println(messageToUser);

        return inputResult;
    }

    public static void closeScanner() {
        input.close();
    }
}
