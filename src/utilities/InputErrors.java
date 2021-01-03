package utilities;

public class InputErrors {

    public static String emptyFieldString(String userInput) {
        while (userInput.equals("")) {
            System.err.println("\nYou did not insert any information for this field.");
            userInput = InputOutput.inputString("Please try one more time");
        }
        return userInput;
    }

    public static int irrelevantInt(String userInput) {
        int correctInput = 0;
        try {
            correctInput = Integer.parseInt(userInput);
        }catch(NumberFormatException wrongInput){
            System.err.println("\nYou should insert a number here.");
            userInput = InputOutput.inputString("Please try again");
            irrelevantInt(userInput);

        }
        return correctInput;
    }

    public static double irrelevantDouble(String userInput) {
        double correctInput = 0.0;
        try {
            correctInput = Double.parseDouble(userInput);
        }catch(NumberFormatException wrongInput){
            System.err.println("\nYou should insert a number here.");
            userInput = InputOutput.inputString("Please try again");
            irrelevantDouble(userInput);

        }
        return correctInput;
    }

    public static String incorrectYesOrNo (String userInput) {
        userInput = InputOutput.inputString("Invalid input. you should answer with yes " +
                "or no. Please try again");

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
