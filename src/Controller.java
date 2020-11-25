import Model.Project.Database;
import Model.Project.Project;
import Model.Users.User;
import View.VMainMenu;
import View.VRegister;

import javax.xml.crypto.Data;
import java.util.UUID;

public class Controller {
    //Attributes
    Database mDatabase;
    VMainMenu mVMainMenu;
    VRegister mVRegister;


    //Constructor
    public Controller() {
        mDatabase = new Database();
        mVMainMenu = new VMainMenu();
        mVRegister = new VRegister();
    }

    public void main() {
        System.out.println("Welcome to Pomato!\n");

        doMainMenu();
    }

    void doMainMenu() {
        mVMainMenu.render();

        UUID id = null;
        String password;

        String mainMenuSelect = mVMainMenu.read();

        switch (mainMenuSelect) {
            case "1" -> {
                //Register menu
                User user = mVRegister.getUserData();

                mDatabase.addUser( user );
                mVRegister.registerSuccess();
                doMainMenu();
            }
            case "2" -> {

            }
            case "3" -> {

            }
            case "X" -> {

            }
            default -> {
                mVMainMenu.renderError();
                doMainMenu();
            }
        }
    }

}
