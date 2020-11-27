//package view;
//
//import controllers.Controller;
//import utilities.InputOutput;
//
//public class VMenuExit extends VMenu {
//
//
//
//    /**
//     * Contructors
//     */
//
//    public VMenuExit(VMenu parent) {
//        super(parent);
//        menuHeader = "Exit";
//        menuLabel = "Exit Pomato";
//        menuQuestion = "Are you sure you want to exit?(Yes/No)";
//        menuChoice = "E";
//        children = null;
//    }
//
//
//    /**
//     * Methods
//     */
//
//    @Override
//    public VMenu excecuteMenu(boolean line, Controller controller) {
//        System.out.println(InputOutput.line() + menuHeader + "\n");
//
//        chooseMenu(mParent);
//
//        return mParent;
//    }
//
////    @Override
////    public int readInput() {
////        String yesNo = InputOutput.inputString(menuQuestion);
////
////        if (yesNo.equalsIgnoreCase("YES")) {
////            System.exit(0);
////        }
////
////        return 0;
////    }
//}
