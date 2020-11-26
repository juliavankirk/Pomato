package view;


import utilities.InputOutput;

import java.util.ArrayList;

public class VMenuMain extends VMenu{

    ArrayList<VMenu> children;

    /**
     * Contructors
     */

    public VMenuMain(VMenu parent) {
        super(null);
        menuHeader = "Main Menu";
        menuLabel = "";
        menuQuestion = "Enter choice";
        menuChoice = "M";
    }

    public VMenuMain(VMenu parent, VMenuRegister r, VMenuLogin l, VMenuManual ma, VMenuExit e) {
        super(null);
        menuHeader = "Main Menu";
        menuLabel = "";
        menuQuestion = "Enter choice";
        menuChoice = "M";
        children = new ArrayList<VMenu>();
        children.add(new VMenuRegister(this));
        children.add(new VMenuLogin(this));
        children.add(new VMenuManual(this));
        children.add(new VMenuExit(this));
    }


    @Override
    public void renderMenu(boolean line) {

        if (line = true) {
            System.out.println("--------------------------------------------------------------------------------------------------------\n");
        }
        System.out.println(menuHeader + "\n");

        for (int i = 0; i < children.size(); i++) {
            System.out.println((i + 1) + ". " + children.get(i).menuLabel);
        }
        if (parent != null) {
            System.out.println((children.size() + 1) + ". Go back");
        }
        System.out.println("");
    }


    public void renderExit() {
        System.out.println("Exiting the system. Goodbye!");
    }


    public void renderError() {
        System.out.println("Invalid selection, restarting...");
    }

    @Override
    public int readInput() {
        int min = 1;
        int max = children.size();
        VMenu chosenVMenu;

        if (parent != null) {
            max++;
        }

        int inputResult = InputOutput.inputInt(menuQuestion);
        while(inputResult < min || inputResult > max) {
            inputResult = InputOutput.inputInt("Please enter a valid value(" + min + "-" + (max + 0) + "): ");
        }

        if (inputResult == (max + 1)) {
            chosenVMenu = this.parent;
        } else {
            chosenVMenu = children.get(inputResult - 1);
        }

        chosenVMenu.renderMenu(false);
        chosenVMenu.readInput();

        return inputResult;
    }
}
