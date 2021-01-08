package view.menu;

import controllers.Controller;
import view.VMenu;

public class VMenuManual extends VMenu {


    /**
     * Constructors
     */
    public VMenuManual(VMenu parent) {
        super(parent);
        mMenuHeader = "Manual";
        mMenuLabel = "View manual";
        mMenuQuestion = "Enter choice";
        mMenuChoice = "X";
        mSubMenus = null;
//        mSubMenu = false;
    }


    /**
     * Methods
     */
    @Override
    public void menuContent(Controller controller) {

        System.out.println("What is Pomato?\n" +
                "\n" +
                "POMATO is the only tool you will ever need for managing your projects inside of an IDE. In only 2 months our team has managed to pack this tool full of features. You will never want to use any other tool for managing your project after you have witnessed our beautiful task board.\n" +
                "\n" +
                "\n" +
                "Install\n" +
                "Install an IDE of choice on Windows or Mac. (We developed this tool on windows with the IDE, IntelliJ)\n" +
                "Clone and Pull our project from GitLab.\n" +
                "Install the Gson library by going to src/gson-2.8.6.jar\n" +
                "Once the .jar is added as an external library you can run the Main.java\n" +
                "\n" +
                "The Main application\n" +
                "Registration\n" +
                "Once you start the program, the main menu appears which gives you 5 different options. The first one is Registration in which you can fill in a form receiving your job-related information, and be registered in the system as a user in order to be able to be a member of other’s projects or make and manage your own project. You will also be asked to enter a username and password to log in to the system in the future. Please make sure to remember your username and password and do not share your password with others for security reasons. The information you enter while registration is saved in the system and you do not have to be worried about refilling the registration form each time you exit and start the program again. According to our privacy policy, only your username, first name, and last name will be shared with your fellow project members.\n" +
                "\n" +
                "Note: If you wish to remove your account, you can do so by entering the third option “handle user account” when you’ve logged in. \n" +
                "\n" +
                "Logging in as a user\n" +
                "The second option given to you in the main menu is Log-In. You are able to log in with your username and password which was chosen by you while registering in the Pomato. By logging in to the system, you will be able to use our many interesting options to manage or contribute to your projects. If you do not know how to register in Pomato, please read the Registration section in this manual.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Import data\n" +
                "You are able to view the imported data from the JSON file by choosing this menu option.  \n" +
                "More information: \n" +
                "When the program starts the database.json file will be loaded automatically. This menu option will simply display the information that was loaded. This file is filled with two standard users Erik and Linda. Username: “erik” and “linda”. Password: 123.\n" +
                "The file can be edited if you should want to change any information outside of the program.\n" +
                "If you are having problems or if you want to clear the loaded data, simply open the database.json and empty the file.\n" +
                "\n" +
                "You are also able to import data from a CSV file by selecting this option. \n" +
                "\n" +
                "The information must be a list of users with the following format: \n" +
                "User;FirstName;LastName;UserName;Password;CompanyName;Salary;JobTitle;Project1;Role1;Project2;Role2;... .\n" +
                "\n" +
                "The users that are imported to Pomato must not be registered manually before. If a project title that is in the list was used before, the imported user of that project is added to the existing members of the project. Also the roles of the users in the list is case sensitive. So be careful while typing them.\n" +
                "User tips: If you downgrade yourself in a project and no one else is a manager in the project, you can use this CSV file to import a member as a manager in your own project and fix everything. \n" +
                "\n" +
                "Creating a project\n" +
                "When you log in to the system, you will be able to see another menu representing all your projects you are a member of and some other options including Create new projects. You can always Create your own projects by selecting this option. You are also able to add as many other members as you want to your project when creating it or even after that by entering their usernames so you don’t need to be worried if you don’t know the username of some of the members while creating the project. You can gain more information about this in the Adding members section in the manual. You are not able to create a project with a title that was used before. Once you create a project, you are the manager of that project by default. You will know more about roles and how to change them under the Changing roles of members section in the manual.\n" +
                "\n" +
                "\n" +
                "\n" +
                "The Project Menu\n" +
                "\n" +
                "Changing roles of members\n" +
                "Once you create a project you are the manager of that project by default. The manager has some authority that other members don’t e.g. Adding members, Changing roles, Adding holidays … . You can change the roles of each member including yourself after creating the project. You are able to see the Change Roles option when you select the project in the Logged-In menu. If you want to downgrade yourself to a developer, make sure you upgrade someone else to a manager first, since once everyone in a project is a developer, no one is able to make changes that only managers can do. In case this happens, there is only one way to fix it which is explained in the Import data section.   If you are a developer in a project and want to upgrade yourself to be a manager, the only way is the manager of the project changes your role. \n" +
                "\n" +
                "Idea board\n" +
                "Pomato made it possible for project members to share their Ideas and give each other feedback by creating an interactive idea log. Each member is able to leave their ideas, like, dislike and also leave their comments about other’s ideas in this log. Every member can access this log by choosing the Idea Board option after they enter their project menu. \n" +
                "\n" +
                "Adding members\n" +
                "As a manager, you are able to add more members to your project. You can do this by selecting the Add member option in the project’s menu. You only need to have the correct username of the member you are willing to add, therefore those members must be registered in the system before to have usernames. Be mindful that you cannot add members who are already participating in the project.\n" +
                "\n" +
                "Task board\n" +
                "Any member is able to view the taskboard. Here you can add a new task and it will be displayed in a card on the board. If you want to edit the task you can do so by choosing the correct menu option. \n" +
                "\n" +
                "\n" +
                "Checklist\n" +
                "Any member can create a checklist to every task that is being displayed on the taskboard. The checklist will be viewed on the taskboard, and it's possible to edit the checklist and mark items as done. \n" +
                "User tip: Do not edit a non-existing checklist.  \n" +
                "\n" +
                "\n" +
                "Activity log \n" +
                "Any member can view an activity log which is specific for the project they’re currently visiting. The activity log displays activities done by the team members when it comes to tasks. The things that are displayed on the activity log is mainly the task at hand. What changes have been made to the task, at what time the changes were made to the task, as well as who made the changes in question.\n" +
                "\n" +
                "View Total Wage\n" +
                "You can see your total wage by choosing View Total Wage in the project menu. You only have to enter the amount of hours that you worked. Pomato automatically calculates your total wage according to the salary you entered while registering in the system. \n" +
                "\n" +
                "Employee’s Holidays\n" +
                "Every employee needs some days off to rest and Pomato made it easier for project members to access their righteous needs. As a manager you can add or remove your project members’ holidays and also view all of them by selecting Employees Holidays in the project menu.\n" +
                "\n" +
                "Economic overview\n" +
                "This page will help you see hired employees and the tasks created for the current project.\n"
        );

        System.out.println(" ");
    }
}
