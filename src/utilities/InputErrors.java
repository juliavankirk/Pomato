package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InputErrors {


    public static String emptyFieldString(String userInput) {
        while (userInput.equals("")) {
            userInput = InputOutput.inputString("you did not insert any information for this field. Please try one more time");
        }
        return userInput;
    }

//    public static int emptyFieldInt(Integer userInput) {
//        while (userInput.equals("")) {
//            userInput = InputOutput.inputInt("you did not insert any information for this field. Please try one more time");
//        }
//        return userInput;
//    }

    public static double irrelevantDouble(String userInput) {
        double sth = 0.0;
        try {
            sth = Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            System.err.println("You should insert a number here.");
            userInput = InputOutput.inputString("Please try again");
            sth = Integer.parseInt(userInput);
        }
        return sth;
    }

    public static String incorrectYesOrNo(String userInput) {

        userInput = InputOutput.inputString("Invalid Input! Please type yes or no");

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













