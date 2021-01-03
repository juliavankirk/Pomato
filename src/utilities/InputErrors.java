package utilities;

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
        }catch(NumberFormatException ex){
            System.err.println("You should insert a number here.");
            userInput = InputOutput.inputString("Please try again");
            sth = Integer.parseInt(userInput);
        }
        return sth;
    }

}
