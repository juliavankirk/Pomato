package utilities;

import model.project.Checklist;
import model.project.ChecklistItem;
import model.project.Task;
import model.users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TaskTable {


    /**
     * ATTRIBUTES
     */

    ArrayList<Task> tasks;
    ArrayList<String> headerList;

    private String divider;
    private String cardDivider;
    private int cardRows;
    private int cardColumns;
    private ArrayList<ArrayList<Task>> taskLists = new ArrayList<>();
    private int largestListSize;

    public static int cardWidth = 42;
    public static String dividerHorizontalChar = "-";
    public static String dividerCornerChar = "++";
    public static String cardBorderVerticalChar = "||";


    /**
     * CONSTRUCTORS
     * @param tasks         tasks should always be sent in through a constructor.
     * @param headerList    If a user does not send in a list with headers then a default list of headers will be created.
     */

    public TaskTable(ArrayList<Task> tasks, ArrayList<String> headerList) {
        this.headerList = headerList;
        this.tasks = tasks;
    }
    public TaskTable(ArrayList<Task> tasks) {
        // this = this TaskTable class's constructor with the parameters (Arraylist<SubTask, ArrayList<String>)
        // If I only send in tasks the list with headers will default to the ones below.
        this(tasks, new ArrayList<>(Arrays.asList("TODO", "IN PROGRESS", "COMPLETED")));
    }


    /**
     * Public methods:
     */

    // This method initializes everything we need and sets the relevant attributes. Then it prints the table.
    public void print() {
        // Initialize before printing.
        initCardColumns();
        initHorizontalDivider();
        initCardRowCount();
        this.cardColumns = this.taskLists.size();
        // Check largest list size
        this.largestListSize = maximumListSize(this.taskLists);

        // Print
        printTable();
    }


    /**
     * Private METHODS
     * @param lists The list I'm taking in here is a list of a list.
     * @param <T>   This means that I can take in an object of any type.
     * @return      I'm returning the list with the largest size since I need to know this to be able to print empty rows
     *              I need to create empty rows in order to fill the cards that are too short.
     */

    // This is a method that can take a list containing an object of any type.
    private <T> int maximumListSize(ArrayList<ArrayList<T>> lists) {
        int largestListSize = 0;
        for (int i = 0; i < lists.size(); i++) {
            largestListSize = Math.max(largestListSize, lists.get(i).size());
        }
        return largestListSize;
    }

    // Prints the headers and the cards.
    private void printTable() {
        printHeaders();
        createCards();
    }

    // Prints the Headers that are displayed above the cards. Ex: "COMPLETED", "IN PROGRESS" etc
    private void printHeaders() {
        String header = cardBorderVerticalChar;

        for (int i = 0; i < this.cardColumns; i++) {

            if (headerList.size() > i) {
                header = header + createTableHeader(headerList.get(i)) + cardBorderVerticalChar;
            } else {
                header = header + createTableHeader("-");
            }
        }

        System.out.println(divider);
        System.out.println(header);
        System.out.println(divider);
    }

    // TODO Refactor card printing to this method
    private void printCards(){
        System.out.println();

        System.out.println(divider);
    }


    // Create cards for printing. This also handles printing at the moment but this should be refactored out.
    private void createCards(){


        for (int currentRow = 0; currentRow < largestListSize; currentRow++) {
            ArrayList<ArrayList<String>> cardsForRowList = new ArrayList<>();

            for (int k = 0; k < taskLists.size(); k++) {
                ArrayList<Task> currentTasks = this.taskLists.get(k);  //
                int thisSize = currentTasks.size();

                if (thisSize > currentRow) {
                    Task currentTask = currentTasks.get(currentRow);
                    cardsForRowList.add(createCard(currentTask));

                } else {
                    cardsForRowList.add(createEmptyCard());
                }
            }

            // get highest card
            int highest = maximumListSize(cardsForRowList);

            // Make all cards the same height
            for (int i = 0; i < cardsForRowList.size(); i++) {

                // Shortcut to cardsForRowList
                ArrayList<String> cardStringList = cardsForRowList.get(i);

                for (int j = cardStringList.size(); j < highest; j++) {
                    cardStringList.add(createEmptyRow());
                }
            }

            for (int row = 0; row < highest; row++) {
                for (int column = 0; column < this.cardColumns; column++) {
                    String data = cardsForRowList.get(column).get(row);
                    StringBuilder str = new StringBuilder();

                    if ( column < this.cardColumns - 1) {
                        str
                                .append(cardBorderVerticalChar)
                                .append(createCardLine(data));
                    } else {
                        str
                                .append(cardBorderVerticalChar)
                                .append(createCardLine(data))
                                .append(cardBorderVerticalChar);
                    }

                    System.out.print(str);
                }
                System.out.print("\n");
            }
            System.out.println(divider);
        }
    }
    private ArrayList<String> createCard(Task task){
        ArrayList<String> taskAttributeStringList = new ArrayList<>();

        taskAttributeStringList = new ArrayList<>(Arrays.asList(
                "Title: " + task.getTitle()
        ));

        ArrayList<String> descriptionRows = new ArrayList<>();
        String description = "Description: " + task.getDescription();
        if (task.getDescription().length() > (cardWidth - 2)) {
            descriptionRows = splitString(description);
        } else {
            descriptionRows.add(description);
        }

        for (int i = 0; i < descriptionRows.size(); i++) {
            taskAttributeStringList.add(descriptionRows.get(i));
        }

        taskAttributeStringList.add("Created:  " + task.getDateCreated().toString());
        taskAttributeStringList.add("Due:      " + task.getDueDate().toString());
        taskAttributeStringList.add("Time to complete: " + String.valueOf(task.getEstimatedTime()));
        taskAttributeStringList.add("Priority: " + String.valueOf(task.getPriority()));
        taskAttributeStringList.add("ID: " + task.getId().toString());
        taskAttributeStringList.add("Status:   " + task.getStatus());
        for (int i = 0; i < task.getUserList().size(); i++) {
            User currentUser = task.getUserList().get(i);
            taskAttributeStringList.add("Assignee " + (i + 1) + ": " + currentUser.getUserName());
        }
        taskAttributeStringList.add(initHorizontalCardDivider(task));

        for (int i = 0; i < task.getChecklists().size(); i++) {
            Checklist currentChecklist = task.getChecklists().get(i);

            taskAttributeStringList.add( "Checklist: " + currentChecklist.getName());
            taskAttributeStringList.add( "ID: " + currentChecklist.getId().toString());

            for (int j = 0; j < currentChecklist.getChecklistItems().size(); j++) {
                ChecklistItem currentChecklistItem = currentChecklist.getChecklistItems().get(j);

                if (currentChecklistItem.getStatus().equals("Not Done")){
                    taskAttributeStringList.add( "[ ] " + currentChecklistItem.getTopic() + ", ID: " + currentChecklistItem.getId());
                } else {
                    taskAttributeStringList.add( "[V] " + currentChecklistItem.getTopic() + ", ID: " + currentChecklistItem.getId());
                }
            }
        }

        return taskAttributeStringList;
    }
    private ArrayList<String> createEmptyCard() {
        ArrayList<String> test = new ArrayList<>();
        test.add(createEmptyRow());
        return test;
    }
    private String createCardLine(String text){
        StringBuilder str = new StringBuilder();                    // 11
        double remainingchars = (double)this.cardWidth - text.length();     // 19

//        if (remainingchars < 2 && text.charAt(1){
//
//        }

        if (remainingchars < 2) {
            str
                    .append(" ")
                    .append(text, 0, Math.max(0,this.cardWidth) - 5)
//                    .append(splitString(text))
                    .append("... ");
        } else {
            str
                    .append(" ")
                    .append(text, 0, Math.min(Math.max(0,this.cardWidth), text.length()))
                    .append((" ").repeat((int)remainingchars - 1));
        }
//        System.out.println(str);

        return str.toString();
    }

    // Method for splitting a string that is too long to fit in a card
    private ArrayList<String> splitString(String text){
        int textLength = text.length();
        int textRows = textLength/this.cardWidth;
        ArrayList<String> finalDescriptionRows = new ArrayList<>();
        int startLineIndex= 0;

        for (int i = 0; i <= textRows; i++) {
            int end = (cardWidth - 2) * (i + 1);

            if (end > text.length()) {
                end = text.length();
            }

            finalDescriptionRows.add(text.substring(startLineIndex, end).trim());

            startLineIndex = end;
        }

        return finalDescriptionRows;
    }

    // If there is no card then this will be called to fill a row
    private String createEmptyRow() {
        return (" ")/*.repeat(cardWidth)*/;
    }

    // This handles creating the table header and placing the Titles in the center of the column.
    // Then it sends this string along to be printed elsewhere
    private String createTableHeader(String text) {
        StringBuilder str = new StringBuilder();
        int textLength = text.length();                         // 11
        double remainingchars = this.cardWidth - textLength;    // 19

        if (remainingchars < 2) {
            str
                    .append(" ")
                    .append(text, 0, Math.max(0,this.cardWidth - 5))
                    .append("... ");
        } else {
            int pre = (int) (remainingchars / 2.0);              // 3
            int sub = (int) Math.ceil(remainingchars / 2.0);     // 10

            str
                    .append((" ").repeat(pre))
                    .append(text)
                    .append((" ").repeat(sub));
        }

        return str.toString();
    }


    // Methods for initializing the look of the cards, how many rows and columns there should be.
    private void initHorizontalDivider() {
        String cardTop = dividerHorizontalChar.repeat(cardWidth);
        this.divider = dividerCornerChar + (cardTop + dividerCornerChar).repeat(taskLists.size());
    }

    private String initHorizontalCardDivider(Task task) {

        if (!(task.getChecklists().size() < 1)) {
            return dividerHorizontalChar.repeat(cardWidth - 2);
        }
        return "";
    }

    private void initCardRowCount() {
        this.cardRows = 0;

        for (int i = 0; i < taskLists.size(); i++) {
            this.cardRows = Math.max(this.cardRows, taskLists.size());
        }
    }

    private void initCardColumns() {
        this.taskLists.clear();

        for (String header : headerList) {
            this.taskLists.add(
                    new ArrayList<>(tasks
                            .stream()
                            .filter(subTask -> subTask.getStatus().equals(header))
                            .collect(Collectors.toList())
                    )
            );
        }
    }


    /**
     * Getters and setters:
     */

    public int getCardWidth() {
        return cardWidth;
    }

    public void setCardWidth(int cardWidth) {
        this.cardWidth = cardWidth;
    }

    public static String getDividerHorizontalChar() {
        return dividerHorizontalChar;
    }

    public static void setDividerHorizontalChar(String dividerHorizontalChar) {
        TaskTable.dividerHorizontalChar = dividerHorizontalChar;
    }

    public static String getDividerCornerChar() {
        return dividerCornerChar;
    }

    public static void setDividerCornerChar(String dividerCornerChar) {
        TaskTable.dividerCornerChar = dividerCornerChar;
    }

    public static String getCardBorderVerticalChar() {
        return cardBorderVerticalChar;
    }

    public static void setCardBorderVerticalChar(String cardBorderVerticalChar) {
        TaskTable.cardBorderVerticalChar = cardBorderVerticalChar;
    }
}
