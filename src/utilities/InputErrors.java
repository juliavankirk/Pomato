package utilities;

public class InputErrors {
    static int correctIntInput;
    static double correctDoubleInput;

    public static String emptyFieldString(String userInput) {
        while (userInput.equals("")) {
            System.err.println("\nYou did not insert any information for this field.");
            System.out.println("");
            userInput = InputOutput.inputString("Please try one more time");
        }
        return userInput;
    }

    public static int irrelevantInt(String userInput) {
        try {
            correctIntInput = Integer.parseInt(userInput);
        }catch(NumberFormatException wrongInput){
            System.err.println("You should insert a number here.");
            System.out.println("");
            userInput = InputOutput.inputString("Please try again");
            irrelevantInt(userInput);
        }
        return correctIntInput;
    }

    public static double irrelevantDouble(String userInput) {
        try {
            correctDoubleInput = Double.parseDouble(userInput);
        }catch(NumberFormatException wrongInput){
            System.err.println("You should insert a number here.");
            System.out.println("");
            userInput = InputOutput.inputString(" Please try again");
            irrelevantDouble(userInput);
        }
        return correctDoubleInput;
    }

    public static int inRangeIntInput (int userInput, int upperRange, int lowerRange) {
        if (userInput < upperRange && userInput > lowerRange) {
            return userInput;
        }
        System.err.println("The number you entered is out of range.");
        System.out.println("");
        userInput = irrelevantInt(InputOutput.inputString("Please try again"));
        return inRangeIntInput(userInput, upperRange, lowerRange);
    }

    public static int checkMenuChoice(String userInput, int upperRange, int lowerRange) {
        int userInt1 = irrelevantInt(userInput);
        int userInt2 = inRangeIntInput(userInt1, upperRange, lowerRange);

        return userInt2;
    }

    public static String incorrectYesOrNo (String userInput) {
        System.err.println("Invalid input. You should answer with yes or no.");
        System.out.println("");
        userInput = InputOutput.inputString("Please try again");

        switch (userInput) {
            case "yes" -> {
                return "yes";
            }
            case "no" -> {
                return "no";
            }
            default -> {
                return incorrectYesOrNo(userInput);
            }
        }
    }

}
