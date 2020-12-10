package controllers;

import model.project.Database;
import model.project.Project;
import model.project.Task;
import com.sun.jdi.event.MonitorContendedEnteredEvent;
import model.project.*;
import model.users.User;
import view.VMenu;
import view.menu.VMenuMain;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class Controller {


    //Attributes
//    StorageController mStorageController;

    Database mDatabase;
    VMenu mCurrentMenu;
    private User mCurrentUser;
    private Project mCurrentProject;


    //Constructor
    public Controller() {
        mDatabase = new Database();
        mCurrentMenu = new VMenuMain(null);
        mCurrentUser = null;
        mCurrentProject = null;
    }


    /**
     * Methods
     * I don't know if I like to have the loop like this here but it keeps everything very simple.
     * This loop is what makes moving through the menu's possible.
     */
    public void executeViewsAndDatabase(Controller controller) {

        //Loading the database once, when the program starts
        loadDatabase();

        // This is the loop that keeps us within the different menu's
        // Since we are always in a menu this will always run.
        while (mCurrentMenu != null) {

            // Right now we are saving the database every time we switch view
            saveDatabase();

            // The method ".executeMenu" in the class "VMenu" returns the "chosenMenu",
            // which means that "mCurrentMenu" becomes the "chosenMenu".
            // So if we choose the "VMenuLogin" then we execute that menu.
            mCurrentMenu = mCurrentMenu.executeMenu(controller);
        }
    }


    /**
     * Handling Task/Tasks
     */
    public void addSubTask(String title, String description, LocalDate dueDate, LocalDate startDate,
                           double estimatedTime, int priority) {
        SubTask subTask = new SubTask(title, description, dueDate, startDate, estimatedTime, priority);
        getCurrentProject().addTaskToList(subTask);
    }

    public String removeSubTask(String taskId) {
        int taskListSize = getTaskListFromCurrentProject().size();

        for (int i = 0; i < taskListSize; i++) {
            UUID stringUuid = getTaskListFromCurrentProject().get(i).getId();

            if (stringUuid.toString().equals(taskId)) {
                getCurrentProject().removeTask(i);
                return "Task with ID: " + taskId + " has been removed";
            }
        }
        return "Task with ID: " + taskId + " was not found";
    }

    public SubTask getTaskById(String taskId) {
        int taskListSize = getTaskListFromCurrentProject().size();

        for (int i = 0; i < taskListSize; i++) {
            UUID stringUuid = getTaskListFromCurrentProject().get(i).getId();

            if (stringUuid.toString().equals(taskId)) {
                return getTaskListFromCurrentProject().get(i);
            }
        }
        return null;
    }

    public ArrayList<SubTask> getTaskListFromCurrentProject() {

        return getCurrentProject().getTaskList();
    }



    /*
    Handling checklists
     */


    public String addChecklist(String name, String taskId/*, ArrayList<String> itemStringList*/) {
        SubTask task = getTaskById(taskId);
        Checklist checklist = new Checklist(name);


        /*if (!(itemStringList.isEmpty())) {
            ArrayList<ChecklistItem> checklistItemList = new ArrayList<>();

            for (String s : itemStringList) {
                checklistItemList.add(new ChecklistItem(s));
            }
            checklist.setItems(checklistItemList);
            task.addChecklist(checklist);

            return "Checklist with name: " + name + " and " + checklistItemList.size() + " item(s), has successfully been created";
        } else {*/
            task.addChecklist(checklist);

            return "Checklist with name: " + name + " has successfully been created";
       // }
    }

    public Checklist getChecklistById(String checklistId, String taskId) {
        SubTask task = getTaskById(taskId);
        int checklistSize = task.getChecklists().size();
        for (int i = 0; i < checklistSize; i++) {
            // get checklist
            Checklist currentChecklist = task.getChecklists().get(i);
            // get id
            UUID stringUuid = currentChecklist.getId();
            if (stringUuid.toString().equals(checklistId)) {
                return currentChecklist;
            }
        }
        return null;
    }

    public ArrayList<Checklist> getChecklists(String taskId) {
        Task task = getTaskById(taskId);
        return task.getChecklists();
    }

    public String removeChecklist(String checklistId, String taskId) {
        ArrayList<Checklist> checklists = getChecklists(taskId);
        Checklist checklist = getChecklistById(checklistId, taskId);
        if (checklist != null) {
            checklists.remove(checklist);
            return "The checklist has successfully been removed";
        }
        return "The checklist could not be found";
    }

    public void updateChecklistName(String updatedName, String checklistId, String taskId) {
        Checklist checklist = getChecklistById(checklistId, taskId);
        checklist.setName(updatedName);
    }

    /**
     * handling checklist items
     */

    public ArrayList<ChecklistItem> getChecklistItems(String taskId, String checklistId) {
        Checklist checklist = getChecklistById(checklistId, taskId);
        return checklist.getChecklistItems();
    }

    public ChecklistItem getChecklistItemById(String checklistId, String taskId, String itemId) {
        Checklist checklist = getChecklistById(checklistId, taskId);
        int checklistItemSize = checklist.getChecklistItems().size();
        for (int i = 0; i < checklistItemSize; i++) {
            // get checklist
            ChecklistItem currentChecklistItem = checklist.getChecklistItems().get(i);
            // get id
            //UUID stringUuid = currentChecklistItem.getId();
            if (currentChecklistItem.getId().equals(checklistId)) {
                return currentChecklistItem;
            }
        }
        return null;
    }

    public String removeChecklistItem(String checklistId, String itemId, String taskId) {
        ArrayList<ChecklistItem> checklistItems = getChecklistItems(taskId, checklistId);
        ChecklistItem checklistItem = getChecklistItemById(checklistId, taskId, itemId);
        if (checklistItem != null) {
            checklistItems.remove(checklistItem);
            return "The item has successfully been removed";
        }
        return "Checklist Item could not be found";
    }

    public void updateItemStatus(String checklistId, String taskId, String itemId) {
        ChecklistItem checklistItem = getChecklistItemById(checklistId, taskId, itemId);
        checklistItem.setStatus("Done");
    }

    public void updateItemTopic(String updatedTopic, String checklistId, String taskId, String itemId) {
        ChecklistItem checklistItem = getChecklistItemById(checklistId, taskId, itemId);
        checklistItem.setTopic(updatedTopic);
    }

    public String checkItemId(String enteredId, String checklistId, String taskId){
        Checklist checklist = getChecklistById(checklistId, taskId);
        ArrayList <ChecklistItem> checklistItems = checklist.getChecklistItems();
        for (ChecklistItem checklistItem : checklistItems) {
            if (checklistItem.getId().equals(enteredId)){
                return "Id: " + enteredId +  "already exists in this checklist, please enter another topic";
            }
        }return enteredId;
    }

    public String addChecklistItems(String checklistId, String taskId, String topic, String id) {
        Checklist checklist = getChecklistById(checklistId, taskId);
        ChecklistItem checklistItem = new ChecklistItem(id, topic);
        checklist.addChecklistItem(checklistItem);
        return "The item has successfully been added to the checklist";
    }

    /**
     * Updating Task
     */
    public void updateTaskStatus(String updatedStatus, String taskId){
        SubTask subTask = getTaskById(taskId);
        subTask.setStatus(updatedStatus);
    }
    public void updateTaskTitle(String updatedTitle, String taskId){
        SubTask subTask = getTaskById(taskId);
        subTask.setTitle(updatedTitle);
    }
    public void updateTaskDescription(String updatedDescription, String taskId){
        SubTask subTask = getTaskById(taskId);
        subTask.setDescription(updatedDescription);
    }
    public void updateTaskPriority(int updatedPriority, String taskId){
        SubTask subTask = getTaskById(taskId);
        subTask.setPriority(updatedPriority);
    }
    public void updateTaskDueDate(LocalDate dueDate, String taskId){
        SubTask subTask = getTaskById(taskId);
        subTask.setDueDate(dueDate);
    }
    public void updateTaskEstimatedTime(Double estimatedTime, String taskId){
        SubTask subTask = getTaskById(taskId);
        subTask.setEstimatedTime(estimatedTime);
    }


    /**
     *  Handling user
     */

    public String checkUsername(String enteredUsername) {
        Collection<User> userList = mDatabase.getUserList();

        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
            User someOne = iterator.next();
            if(someOne.getUserName().equals(enteredUsername)) {
                return "This username is taken before. Please select another username.";
            }
        }
        return enteredUsername;
    }


    public void addUser(String userName, String firstName, String lastName, String password, String companyName, double jobTitle,
            String hourlyWage ) {
        User user = new User(userName, firstName, lastName, password, companyName, jobTitle, hourlyWage);
        mDatabase.addUser( user );
        System.out.println("Your username is: " + user.getUserName() + "\nYour password is: " + user.getPassword());
    }

    public void removeUser(String id) {
        mDatabase.removeUser(UUID.fromString(id));
    }


    public String logInUser(String enteredUserName, String enteredPassword) {
        Collection<User> userList = mDatabase.getUserList();

        for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
            User someOne  = iterator.next();
            if (someOne.getUserName().equals(enteredUserName)) {
                if (someOne.getPassword().equals(enteredPassword)) {
                    setCurrentUser(someOne);

                    return "Bravo! You logged in.";
                } else {

                    return "Password is incorrect";
                }
            }
        }
        return "Username is incorrect";
    }

    /**
     * Methods for Current Logged-In User
     */
    public void setCurrentUser(User currentUser) {
        mCurrentUser = currentUser;
    }

    public User getCurrentUser() {
        return mCurrentUser;
    }


    /**
     * Handling Project
     */
    public String createProject(String title, String description, ArrayList<String> enteredIds,
                                LocalDate startDate, LocalDate dueDate) {

        Project project = new Project(title, description, startDate, dueDate);
        String projectId = project.getId().toString();

        Collection<User> userList = mDatabase.getUserList();

        for (int i = 0; i < enteredIds.size(); i++) {
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
                User someOne = iterator.next();

                if (someOne.getId().equals(enteredIds.get(i))) {
                   project.getProjectMembers().add(someOne);
                   someOne.getProjects().add(project);
                   someOne.addRole(projectId);
                }
            }
        }
        mCurrentUser.changeRole(projectId);

        return "\nProject " + project.getProjectTitle() + " is created successfully! You are the manager of this project now ;)";
    }

    public ArrayList<Project> getProjects() {
        return getCurrentUser().getProjects();
    }

    public void addMembers(ArrayList<String> newMembersIds) {

        Collection<User> userList = mDatabase.getUserList();

        for (int i = 0; i < newMembersIds.size(); i++) {
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext(); ) {
                User someOne = iterator.next();

                if (someOne.getId().equals(newMembersIds.get(i))) {
                    mCurrentProject.getProjectMembers().add(someOne);
                    someOne.getProjects().add(mCurrentProject);
                    someOne.addRole(mCurrentProject.getId().toString());
                }
            }
        }


    }

    public void changeRoles(ArrayList<String> memberIds) {

        for(int i = 0; i < memberIds.size(); i++) {
            for(int j = 0; j < getCurrentProject().getProjectMembers().size(); j++) {
                if(memberIds.get(i).equals(getCurrentProject().getProjectMembers().get(j).getId())) {
                    getCurrentProject().getProjectMembers().get(j).changeRole(getCurrentProject().getId().toString());
                }
            }
        }
        System.out.println("Roles are successfully changed");
    }

    /**
     * Methods for Current Project
     */
    public void setCurrentProject(int chosenProject) {
        mCurrentProject = getCurrentUser().getProjects().get(chosenProject);

        saveDatabase(); // We save the project once it has been accessed
    }

    public Project getCurrentProject() {
        return mCurrentProject;
    }


    /**
     * Method for saving DATABASE to a file:
     */

    //TODO Save the Database with all the users
    public void saveDatabase() {
        String fileLocation = "data/database.ser";

        try {
            FileOutputStream fileOut = new FileOutputStream(fileLocation);
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(mDatabase);
            outStream.close();
            fileOut.close();
//            System.out.println("Changes are saved in " + fileLocation);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadDatabase() {
        String fileLocation = "data/database.ser";

        try {
            FileInputStream fileInput = new FileInputStream(fileLocation);
            ObjectInputStream inputStream = new ObjectInputStream(fileInput);
            mDatabase = (Database) inputStream.readObject();
            inputStream.close();
            fileInput.close();
        }
        catch (IOException ioEx) {
            System.out.println("Database is incompatible");
            ioEx.printStackTrace();
        }
        catch (ClassNotFoundException classEx) {
            System.out.println("Database not found");
            classEx.printStackTrace();
        }
    }
//    void doMainMenu() {
//        mVMenuMain.renderMenu(true);
//
//        UUID id = null;
//        String password;
//
//        int mainMenuSelect = mVMenuMain.readInput();
//
//        switch (mainMenuSelect) {
//            case 1 -> {
//                //Register menu
//                mVMenuRegister.renderMenu(true);
//                User user = mVMenuRegister.getUserData();
//
//                mDatabase.addUser( user );
//                mVMenuRegister.registerSuccess();
//                doMainMenu();
//            }
//            case 2 -> {
//                mVMenuLogin.renderMenu(true);
//                mVMenuLogin.readInput();
//            }
//            case 3 -> {
//                mVMenuManual.renderMenu(true);
//                mVMenuManual.readInput();
//            }
//            case 4 -> {
//                mVMenuExit.renderMenu(true);
//                mVMenuExit.readInput();
//            }
//            default -> {
//                mVMenuMain.renderError();
//                doMainMenu();
//            }
//        }
//        doMainMenu();
//    }
}
