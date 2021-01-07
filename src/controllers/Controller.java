package controllers;

import model.project.*;
import model.users.User;
import utilities.InputOutput;
import utilities.JsonHandler;
import view.VMenu;
import view.menu.VMenuMain;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Controller {


    //Attributes
    Database mDatabase;
    VMenu mCurrentMenu;
    private User mCurrentUser;
    private Project mCurrentProject;
    private Task mCurrentTask;


    //Constructor
    public Controller() {
        mDatabase = new Database();
        mCurrentMenu = new VMenuMain(null);
        mCurrentUser = null;
        mCurrentProject = null;
        mCurrentTask = null;
    }


    /**
     * Methods
     * I don't know if I like to have the loop like this here but it keeps everything very simple.
     * This loop is what makes moving through the menu's possible.
     */
    public void executeViewsAndDatabase(Controller controller) {

        // Loads the .json file.
        loadJSON();

        // This is the loop that keeps us within the different menu's
        // Since we are always in a menu this will always run.
        while (mCurrentMenu != null) {

            //TODO Fix this:
//            // Saves the entire database
//            if (mDatabase != null) {
//                JsonHandler jsonHandler = new JsonHandler();
//                jsonHandler.saveDatabase(controller);
//            }

            // The method ".executeMenu" in the class "VMenu" returns the "chosenMenu",
            // which means that "mCurrentMenu" becomes the "chosenMenu".
            // So if we choose the "VMenuLogin" then we execute that menu.
            mCurrentMenu = mCurrentMenu.executeMenu(controller);
        }
    }


    /**
     * Handling Task/Tasks
     */
    public void addTask(String title, String description, LocalDate dueDate, LocalDate startDate,
                           double estimatedTime, int priority, ArrayList<String> assignees) {
        Task task = new Task(title, description, dueDate, startDate, estimatedTime, priority);

        String taskId = task.getId().toString();

        assignMembers(assignees, task);

        mCurrentProject.addActivity(task.getTitle() + "\n" +
                getCurrentUser().getName() + " has created this task on" +  " " + java.time.LocalTime.now() +
                "\n\n Assignees for this task are:\n");

        for ( int i = 0; i < task.getUserList().size(); i++ ) {
                    System.out.print(
                            task.getUserList().get(i) + "\n"
                    );
        }
    }

    public String removeTask(String taskId) {
        Task task = getTaskById(taskId);
        int taskListSize = getTaskListFromCurrentProject().size();

        for (int i = 0; i < taskListSize; i++) {
            UUID stringUuid = getTaskListFromCurrentProject().get(i).getId();

            if (stringUuid.toString().equals(taskId)) {
                getCurrentProject().removeTask(i);
                mCurrentProject.addActivity(task.getTitle() + "\n" +
                        getCurrentUser().getName() + " has removed this task" + " " +  java.time.LocalTime.now());
                return "Task with ID: " + taskId + " has been removed";
            }
        }
        return "Task with ID: " + taskId + " was not found";
    }

    public Task getTaskById(String taskId) {
        int taskListSize = getTaskListFromCurrentProject().size();

        for (int i = 0; i < taskListSize; i++) {
            UUID stringUuid = getTaskListFromCurrentProject().get(i).getId();

            if (stringUuid.toString().equals(taskId)) {
                return getTaskListFromCurrentProject().get(i);
            }
        }
        return null;
    }

    public void assignMembers(ArrayList<String> assignees, Task task) {
        Collection<User> users = mDatabase.getUserList();

        for ( String assignee : assignees ) {
            for ( User employee : users ) {
                if ( employee.getUserName().equals(assignee) ) {

                    // Set the current task
                    mCurrentTask = task;
                    mCurrentTask.getUserList().add(employee);

                    // add the task to an employee and to the project.
                    employee.getTask().add(mCurrentTask);
                    getCurrentProject().addTaskToList(task);

                }
            }
        }
    }

    public ArrayList<Task> getTasksForUser() { return getCurrentUser().getTask(); }

    public ArrayList<Task> getTaskListFromCurrentProject() {

        return getCurrentProject().getTaskList();
    }


    /**
     * Updating Task
     */
    public void updateTaskStatus(String updatedStatus, String taskId){
        Task task = getTaskById(taskId);
        task.setStatus(updatedStatus);
        mCurrentProject.addActivity(task.getTitle() + "\n" +
                getCurrentUser().getName() + " has changed this task status to " + updatedStatus + " " + java.time.LocalTime.now());
    }
    public void updateTaskTitle(String updatedTitle, String taskId){
        Task task = getTaskById(taskId);
        task.setTitle(updatedTitle);
        mCurrentProject.addActivity(task.getTitle() + "\n"
                + getCurrentUser().getName() + " has changed this task title to " + updatedTitle +  " " + java.time.LocalTime.now());
    }
    public void updateTaskDescription(String updatedDescription, String taskId){
        Task task = getTaskById(taskId);
        task.setDescription(updatedDescription);
        mCurrentProject.addActivity(task.getTitle() + "\n"
                + getCurrentUser().getName() + " has changed this task description to " + updatedDescription +  " " + java.time.LocalTime.now());
    }
    public void updateTaskPriority(int updatedPriority, String taskId){
        Task task = getTaskById(taskId);
        task.setPriority(updatedPriority);
        mCurrentProject.addActivity(task.getTitle() + "\n" +
                getCurrentUser().getName() + " has changed this task priority to " + updatedPriority +  " " + java.time.LocalTime.now());
    }
    public void updateTaskDueDate(LocalDate dueDate, String taskId){
        Task task = getTaskById(taskId);
        task.setDueDate(dueDate);
        mCurrentProject.addActivity(task.getTitle() + "\n"
                + getCurrentUser().getName() + " has changed this task due date to " + dueDate +  " " + java.time.LocalTime.now());
    }
    public void updateTaskEstimatedTime(Double estimatedTime, String taskId){
        Task task = getTaskById(taskId);
        task.setEstimatedTime(estimatedTime);
        mCurrentProject.addActivity(task.getTitle() + "\n"
                + getCurrentUser().getName() + " has changed this task estimated time to " + estimatedTime +  " " + java.time.LocalTime.now());
    }

    /**
     * Handling activity log
     *
     */


    public ArrayList <String> getActivityListFromProject(){
        return mCurrentProject.getActivityList();

    }

    /**
     * Handling checklists
     */

    public String addChecklist(String name, String taskId/*, ArrayList<String> itemStringList*/) {
        Task task = getTaskById(taskId);
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
            mCurrentProject.addActivity(task.getTitle() + "\n" +
                    getCurrentUser().getName() + " added a checklist with name " + checklist.getName() + " to this task " +  " " + java.time.LocalTime.now());

            return "Checklist with name: " + name + " has successfully been created";
       // }
    }

    public Checklist getChecklistById(String checklistId, String taskId) {
        Task task = getTaskById(taskId);
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
            mCurrentProject.addActivity(getTaskById(taskId).getTitle() + "\n" +
                    getCurrentUser().getName() + " removed checklist with name " + checklist.getName() + " from this task "  +  " " + java.time.LocalTime.now());
            return "The checklist has successfully been removed";
        }
        return "The checklist could not be found";
    }

    public void updateChecklistName(String updatedName, String checklistId, String taskId) {
        Checklist checklist = getChecklistById(checklistId, taskId);
        checklist.setName(updatedName);
        mCurrentProject.addActivity(getTaskById(taskId).getTitle() + "\n" +
                getCurrentUser().getName() + " has changed a checklist title to " + updatedName + " in this task " +  " " + java.time.LocalTime.now());
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
            if (currentChecklistItem.getId().equals(itemId)) {
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
           mCurrentProject.addActivity(getTaskById(taskId).getTitle() + "\n" +
                           getCurrentUser().getName() + " has removed items from checklist with name " + getChecklistById(checklistId,taskId).getName() +  "in this task " +  " " + java.time.LocalTime.now());
            return "The item has successfully been removed";
        }
        return "Checklist Item could not be found";
    }

    public void updateItemStatus(String checklistId, String taskId, String itemId) {
        ChecklistItem checklistItem = getChecklistItemById(checklistId, taskId, itemId);
        checklistItem.setStatus("Done");
        mCurrentProject.addActivity(getTaskById(taskId).getTitle() + "\n" +
                getCurrentUser().getName() + " has changed item status in checklist with name " + getChecklistById(checklistId,taskId).getName() + " in this task " +  " " + java.time.LocalTime.now());
    }

    public void updateItemTopic(String updatedTopic, String checklistId, String taskId, String itemId) {
        ChecklistItem checklistItem = getChecklistItemById(checklistId, taskId, itemId);
        checklistItem.setTopic(updatedTopic);
        mCurrentProject.addActivity(getTaskById(taskId).getTitle() + "\n" +
                getCurrentUser().getName() + " has updated a item topic in checklist with name " + getChecklistById(checklistId, taskId).getName() + " in this task " + " " + java.time.LocalTime.now());
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
        mCurrentProject.addActivity(getTaskById(taskId).getTitle() + "\n" +
                getCurrentUser().getName() + " has added items to checklist " + checklist.getName() + " in this task " +  " " + java.time.LocalTime.now());
        return "The item has successfully been added to the checklist";
    }

    /**
     * Handling user
     */

    public String checkUsername(String enteredUsername) {
        Collection<User> userList = mDatabase.getUserList();

        for (User someOne : userList) {
            if (someOne.getUserName().equals(enteredUsername)) {
                return "This username is taken before. Please select another username.";
            }
        }
        return enteredUsername;
    }


    public Project searchProjectByTitle(String title) {
        Collection<Project> projectList = mDatabase.getProjectList();
        for (Iterator<Project> iterator = projectList.iterator(); iterator.hasNext(); ) {
            Project project = iterator.next();
            if(project.getProjectTitle().equals(title)) {
                return project;
            }
        }
        Project newProject = new Project(title);
        mDatabase.addProject(newProject);
        return newProject;
    }


    public void addUser(String userName, String firstName, String lastName, String password, String companyName, double jobTitle,
            String hourlyWage ) {
        User user = new User(userName, firstName, lastName, password, companyName, jobTitle, hourlyWage);
        mDatabase.addUser( user );
        System.out.println("Your username is: " + user.getUserName() + "\nYour password is: " + user.getPassword());
    }

    public String removeUser(String username) {
        Collection<User> userList = mDatabase.getUserList();
        String realUsername = getCurrentUser().getUserName();
        if (username.equals(realUsername)) {
            getCurrentUser().getProjects().clear();
            getCurrentUser().getRoles().clear();
            mDatabase.getUserList().remove(getCurrentUser());
            return "You are no longer a user of Pomato.";

        }
        return "You entered a wrong username.";
    }


    public String logInUser(String enteredUserName, String enteredPassword) {
        Collection<User> userList = mDatabase.getUserList();

        for (User someOne : userList) {
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
    public String createProject(String title, String description, ArrayList<String> enteredUsernames,
                                LocalDate startDate, LocalDate dueDate) {

        Project project = new Project(title, description, startDate, dueDate);
        String projectId = project.getId().toString();

        Collection<User> userList = mDatabase.getUserList();

        for (int i = 0; i < enteredUsernames.size(); i++) {
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
                User someOne = iterator.next();
                if (someOne.getUserName().equals(enteredUsernames.get(i))) {
                    project.getProjectMembers().add(someOne);
                    someOne.getProjects().add(project);
                    someOne.addRole(projectId);

                    mDatabase.addProject(project);
                    project.getProjectMemberUUIDs().add(someOne.getId());
                }
            }
        }
        mCurrentUser.changeRole(projectId);

        System.out.println("\nProject " + project.getProjectTitle() + " is created successfully!\n" +
                "The following users are " +
                "added as members to this project:");

        for(int i = 0; i < project.getProjectMembers().size(); i++){
            System.out.print(
                project.getProjectMembers().get(i) +
                project.getProjectMembers().get(i).getRole(project.toString()) +
                "\n"
            );
        }

        return "\n" + getCurrentUser().getFirstName() + " " + getCurrentUser().getLastName() + " is the manager of this project now ;)";
    }

    public ArrayList<Project> getProjectsForCurrentUser() {
        return getCurrentUser().getProjects();
    }

    public void addMembers(ArrayList<String> newMembersUsernames) {

        Collection<User> userList = mDatabase.getUserList();

        for (String newMembersUsername : newMembersUsernames) {
            for (User someOne : userList) {
                if (someOne.getUserName().equals(newMembersUsername) &&
                        !(mCurrentProject.getProjectMembers().contains(someOne.getUserName()))) {
                    mCurrentProject.getProjectMembers().add(someOne);
                    mCurrentProject.getProjectMemberUUIDs().add(someOne.getId());

                    someOne.getProjects().add(mCurrentProject);
                    someOne.addRole(mCurrentProject.getId().toString());
                    System.out.println(someOne.getUserName() + " is successfully added.");
                }
            }
        }
    }

    public void changeRoles(ArrayList<String> memberUsernames) {

        for (String memberUsername : memberUsernames) {
            for (int j = 0; j < getCurrentProject().getProjectMembers().size(); j++) {
                if (memberUsername.equals(getCurrentProject().getProjectMembers().get(j).getUserName())) {
                    getCurrentProject().getProjectMembers().get(j).changeRole(getCurrentProject().getId().toString());
                    System.out.println(memberUsername.equals(getCurrentProject().getProjectMembers().get(j).getUserName()) +
                            "'s role in this project is successfully changed");
                }
            }
        }
        System.out.println("If you cannot find the usernames you entered before in here, you probably " +
                "entered the usernames incorrectly or those users are not a part of this project. Please try again later.");
    }

    /**
     * Methods for Current Project
     */
    public void setCurrentProject(int chosenProject) {
        mCurrentProject = getCurrentUser().getProjects().get(chosenProject);

//        saveDatabase(); // We save the project once it has been accessed
    }

    public Project getCurrentProject() {
        return mCurrentProject;
    }


    public String calculateHours(double hours) {
                double calculatedHours = mCurrentUser.getHourlyWage() * hours;
                mCurrentUser.setTotalWage(calculatedHours);
                return "Your total wage is " + calculatedHours + " SEK";

    }

    public void addHoliday(String hName, String hDescription, LocalDate hStartDate, LocalDate hEndDate) {

        Holiday holiday = new Holiday(hName, hDescription, hStartDate, hEndDate);

        getCurrentProject().addHolidayToList(holiday);
    }



    public String removeHolidayFromList(String developerName){

    int holidayListSize = getHolidayListFromCurrentProject().size();

        for (int i = 0; i < holidayListSize; i++) {
        String userName = getHolidayListFromCurrentProject().get(i).getUserName();

        if (developerName.toString().equals(userName)) {
            getCurrentProject().removeHoliday(i);
            return developerName + "'s " + "holiday information" + " has been removed";
        }
    }
        return "Holiday that belongs to: " + developerName + " was not found";
}

    public ArrayList<Holiday> getHolidayListFromCurrentProject() {

        return getCurrentProject().getHolidayList();

    }

    /**
     * Handling Ideas
     */

    public void addIdeaToProject(String newIdea) {
        Idea idea = new Idea(newIdea);
        getCurrentProject().getIdeas().add(idea);
    }

    public void addLike(int ideaNum) {
        getCurrentProject().getIdeas().get(ideaNum - 1).addLike();
    }

    public void addDisLike(int ideaNum) {
        getCurrentProject().getIdeas().get(ideaNum - 1).addDisLike();
    }

    public void addComment(int ideaNum, String comment) {
        String savedComment = getCurrentUser().getName() + " said: " + comment;
        getCurrentProject().getIdeas().get(ideaNum - 1).addComment(savedComment);
    }

    public void removeIdea(int ideaNum) {
        getCurrentProject().getIdeas().remove(ideaNum - 1);
    }

    public void viewComments(int ideaNum) {
        ArrayList<String> comment = getCurrentProject().getIdeas().get(ideaNum - 1).getComment();
        if(comment.size() != 0) {
            for (int i = 0; i < comment.size(); i++) {
                System.out.println(comment.get(i));
            }
        } else {
            System.out.println("There is still no comment for this idea. You can be the one who adds the first comment.");
        }
    }

    public void sendMessage(String recipient, String subject, String content) {
        Messages message = new Messages(getCurrentUser().getId(), subject, content);
        for (User userMsgVar : mDatabase.getUserList()) {
            if ( userMsgVar.getUserName().equals(recipient)) {
                userMsgVar.addMessage(message);
                System.out.println("Message successfully sent!");
                break;
            }
        }
    }

    public void showMessages() {
        for ( UUID Id : getCurrentUser().getInboxId()) { //for each instance in set of UUIDs
            System.out.println(Id);
        }
    }

    public void viewMessage(String input) {
        try {
            ArrayList<Messages> messages = getCurrentUser().getInbox(UUID.fromString(input));
            if ( messages != null ) {
                System.out.println();
                for ( Messages message : messages) {
                    System.out.println(message);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            System.out.println("Could not find message, please try again!");
        }
    }

    public void deleteMessage(String delete) {
        try {
            UUID id = UUID.fromString(delete);
            ArrayList<Messages> messages = getCurrentUser().getInbox(id);
            if ( messages != null ) {
                System.out.println();
                int removeIndex = 0;
                for ( Messages message : messages) {
                    System.out.println(removeIndex);
                    System.out.println(message);
                    System.out.println();
                    removeIndex++;
                }
                removeIndex = InputOutput.inputInt("Which message would you like to remove?");
                if ( getCurrentUser().removeMessage(removeIndex, id)) {
                    System.out.println("Successfully removed: " + removeIndex);
                } else {
                    System.out.println("Failed to remove: " + removeIndex + ". Please try again.\n");
                }
            }

        } catch (Exception e) {
            System.out.println("Message does not exist, please try again!");
        }
    }

    public void startTask(String task) {
        Collection<Task> taskList = mDatabase.getTaskList();

        //checks if input matches anything on the task list.
        for (Task exists : taskList) {
            if ( exists.getTitle().equals(task)) {
                mDatabase.startTask(getCurrentUser(), exists, LocalDate.now());
            }
        }
    }

    public void submitTask(String submit) {
        Collection<Progression> progression = mDatabase.getProgressionList();
        Progression progress = null;

        for (Progression taskStarted : progression) {
            if ( submit.equals(taskStarted.getTask().getTitle())) {
                progress = taskStarted;
            }
        }

        if ( null == progress ) {
            System.out.println("Task does not exist.");
        } else {
            Task task = null;
            for ( int i = 0; i < mDatabase.getTaskList().size(); i++) {
               if ( mDatabase.getTaskList().get(i).getTitle().equals(submit)) {
                   task = mDatabase.getTaskList().get(i);
               }
            }
        }
        progress.submitTask(LocalDate.now());

    }

    public void showAllTasks() {
        mDatabase.getProgressForUser(getCurrentUser());
    }

    public Double showTotalSalary() {
       Double mySalary = 0.0;

       for ( Progression progress : mDatabase.getProgressForUser(getCurrentUser()) ) {
           mySalary += progress.totalWages();
       }
       return mySalary;
    }

    // This method will load the database.json if it is not empty. Loading the database once, when the program starts
    public void loadJSON() {
        JsonHandler jsonHandler = new JsonHandler();
        try {
            jsonHandler.loadDatabase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Database temporaryDatabase = new Database();
        temporaryDatabase = jsonHandler.getFoundDatabase();
        if (temporaryDatabase != null) {
            mDatabase = temporaryDatabase;
        }
    }

    // this method is for loading the .csv file.
    public void loadDatabaseTwo() {

        String STORAGE = "./src/STORAGE.csv";

        try {
            File customerFile = new File(STORAGE);
            FileReader fileReader = new FileReader(customerFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] retrievedInfo = line.split(";");
                if (retrievedInfo[0].equals("User")) {
                    if (checkUsername(retrievedInfo[3]).equals(retrievedInfo[3])) {
                        User user = new User(retrievedInfo[3], retrievedInfo[1], retrievedInfo[2],
                                retrievedInfo[4], retrievedInfo[5], Double.parseDouble(retrievedInfo[6]), retrievedInfo[7]);

                        for (int i = 0; i < (retrievedInfo.length - 8); i = i + 2) {
                            Project project = searchProjectByTitle(retrievedInfo[i + 8]);
                            if (!(user.getProjects().contains(project))) {
                                user.getProjects().add(project);
                            }
                            if (!(project.getProjectMembers().contains(user.getUserName()))) {
                                project.getProjectMembers().add(user);
                                project.getProjectMemberUUIDs().add(user.getId());
                            }
                            user.addRole(project.getId().toString());
                            if (!(user.getRole(project.getId().toString()).equals(retrievedInfo[i + 9]))) {
                                user.changeRole(project.getId().toString());
                            }
                        }
                        mDatabase.addUser(user);
                    }
                    System.out.println("Added: " + Arrays.toString(retrievedInfo));
                }
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Database getDatabase() {
        return mDatabase;
    }

    public Task getCurrentTask() {
        return mCurrentTask;
    }

    public void setCurrentTask(Task mCurrentTask) {
        this.mCurrentTask = mCurrentTask;
    }

    /**
     * OLD CODE:
     */


    /**
     * Method for saving DATABASE to a file:
     */
/*
    public void saveDatabase() {
        String fileLocation = "data/database.ser";

        try {
            FileOutputStream fileOut = new FileOutputStream(fileLocation);
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(mDatabase);
            outStream.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadDatabase() {
        String fileLocation = "data/database.ser";
//        mDatabase = null;

        try {
            FileInputStream fileInput = new FileInputStream(fileLocation);
            ObjectInputStream inputStream = new ObjectInputStream(fileInput);
            mDatabase = (Database) inputStream.readObject();
            inputStream.close();
            fileInput.close();
        }
        catch (IOException ioEx) {
            ioEx.printStackTrace();
            return;
        }
        catch (ClassNotFoundException classEx) {
            classEx.printStackTrace();
            return;
        }
    }
*/

    // Check only part of ID.
//    public boolean checkIdWithDatabase(String inputId,  checkWithId){
//
//        if (checkWithId.contains(inputId) && !)
//
//            return true;
//    }
}
