package view;


import utilities.InputOutput;

import java.util.ArrayList;

public class VMenuMain extends VMenu{

//    ArrayList<VMenu> mChildren;

    /**
     * Contructors
     */
    public VMenuMain(VMenu parent) {
        super(null);
        menuHeader = "Main Menu";
        menuLabel = "Go back to Main Menu";
        menuQuestion = "Enter choice";
        menuChoice = "M";
        children = new ArrayList<VMenu>();
        children.add(new VMenuRegister(this));
        children.add(new VMenuLogin(this));
        children.add(new VMenuManual(this));
        children.add(new VMenuExit(this));
    }


    @Override
    public VMenu renderMenu(boolean line) {

        System.out.println(InputOutput.line() + menuHeader + "\n");

        for (int i = 0; i < children.size(); i++) {
            System.out.println((i + 1) + ". " + children.get(i).menuLabel);
        }
        if (parent != null) {
            System.out.println((children.size() + 1) + ". Go back");
        }
        System.out.println("");

        return chooseMenu();

//        return parent;
    }

    public void renderExit() {
        System.out.println("Exiting the system. Goodbye!");
    }

    public void renderError() {
        System.out.println("Invalid selection, restarting...");
    }

}
