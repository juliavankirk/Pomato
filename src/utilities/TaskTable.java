package utilities;

import model.project.Checklist;
import model.project.ChecklistItem;
import model.project.SubTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTable {


    /**
     * ATTRIBUTES
     */
    ArrayList<SubTask> tasks;
    ArrayList<String> headerList;
    int cardWidth = 42;

    private String divider;
    private String cardDivider;
    private int cardRows;
    private int cardColumns;
    private ArrayList<ArrayList<SubTask>> taskLists = new ArrayList<>();
    private int largestListSize;

    public static String dividerHorizontalChar = "-";
    public static String dividerCornerChar = "++";
    public static String cardBorderVerticalChar = "||";


    /**
     * CONSTRUCTORS
     * @param tasks         tasks should always be sent in through a constructor.
     * @param headerList    If a user does not send in a list with headers then a default list of headers will be created.
     */
    public TaskTable(ArrayList<SubTask> tasks, ArrayList<String> headerList) {
        this.headerList = headerList;
        this.tasks = tasks;
    }
    public TaskTable(ArrayList<SubTask> tasks) {
        // this = this TaskTable class's constructor with the parameters (Arraylist<SubTask, ArrayList<String>)
        // If I only send in tasks the list with headers will default to the ones below.
        this(tasks, new ArrayList<>(Arrays.asList("TODO", "IN PROGRESS", "COMPLETED")));
    }


    /**
     * METHODS
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
                ArrayList<SubTask> currentTasks = this.taskLists.get(k);  //
                int thisSize = currentTasks.size();

                if (thisSize > currentRow) {
                    SubTask currentTask = currentTasks.get(currentRow);
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
    private ArrayList<String> createCard(SubTask task){
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

    private String initHorizontalCardDivider(SubTask task) {

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
     * Old and Experimental methods below
     */
    private void print(ArrayList<SubTask> subTaskList) {
        String status;
        System.out.print(InputOutput.shortLine());
        printLists(subTaskList, status = "TODO");
        System.out.print(InputOutput.shortLine());
        printLists(subTaskList, status = "IN PROGRESS");
        System.out.print(InputOutput.shortLine());
        printLists(subTaskList, status = "COMPLETED");
    }
    private void printLists(ArrayList<SubTask> subTaskList, String status) {
        System.out.println(status);

        for (SubTask currentSubTask : subTaskList) {

            if (currentSubTask.getStatus().equals(status)) {
                System.out.print(InputOutput.superShortLine());
                System.out.println(currentSubTask);
            }
        }
        System.out.println(" ");
    }
    private void printTaskBoard(ArrayList<SubTask> subTaskList){
        String leftAlignFormat = "| %-36s || %-36s || %-36s |%n";
        String line =     "+--------------------------------------++--------------------------------------++--------------------------------------+%n";

        System.out.format(line);
        System.out.format("|                 TODO                 ||             IN PROGRESS              ||              COMPLETED               |%n");
        System.out.format(line);

        // Temporary tasks
//        Task task = new Task("Task One", "I need you to do this ASAP", LocalDate.of(2020,12,24), 1);
//        task.setStatus("COMPLETED");
//        Task task2 = new Task("Task Two", "Who are you?", LocalDate.of(2020,12,23), 2);
//        task2.setStatus("COMPLETED");
//        Task task3 = new Task("Task Three", "The all-seeing unicorn bro", LocalDate.of(2020,12,22), 3);
//        task3.setStatus("IN PROGRESS");
//        Task task4 = new Task("Task Four", "Alright then I'll call you Benny", LocalDate.of(2020,12,21), 4);
//        task4.setStatus("IN PROGRESS");
//        Task task5 = new Task("Task Five", "This will do", LocalDate.of(2020,12,22), 3);
//        task5.setStatus("TODO");
//        Task task6 = new Task("Task Six", "And so Benny and unknown lived happy", LocalDate.of(2020,12,22), 3);
//        task6.setStatus("TODO");

//        HashMap<String, Task> taskHashMap = new HashMap<>();
//        taskHashMap.put("1",task);
//        taskHashMap.put("2",task2);
//        taskHashMap.put("3",task3);
//        ArrayList<Task> taskArrayList = new ArrayList<>();
//        taskArrayList.add(task);
//        taskArrayList.add(task2);
//        taskArrayList.add(task3);
//        taskArrayList.add(task4);
//        taskArrayList.add(task5);
//        taskArrayList.add(task6);

        // Separating tasks into different lists
        ArrayList<SubTask> todoList = new ArrayList<>();
        ArrayList<SubTask> inprogressList = new ArrayList<>();
        ArrayList<SubTask> completedList = new ArrayList<>();
        for (int i = 0; i < subTaskList.size(); i++) {
            int counter = 0;
            SubTask currentTask = subTaskList.get(i);
            if (currentTask.getStatus().equals("TODO")) {
                todoList.add(currentTask);
            } else if (currentTask.getStatus().equals("IN PROGRESS")) {
                inprogressList.add(currentTask);
            } else if (currentTask.getStatus().equals("COMPLETED")) {
                completedList.add(currentTask);
            }
        }

        // Getting size of list with largest size.
        int tSize = todoList.size();
        int iSize = inprogressList.size();
        int cSize = completedList.size();
        int largestListSize = 0;
        if (tSize >= iSize && tSize >= cSize) {
            largestListSize = tSize;
        } else if (iSize >= tSize && iSize >= cSize) {
            largestListSize = iSize;
        } else if (cSize >= tSize && cSize >= iSize) {
            largestListSize = cSize;
        }

        // Here we check some things
        for (int i = 0; i < largestListSize; i++) {
            truthChecker(leftAlignFormat, todoList, inprogressList, completedList);
            if (!todoList.isEmpty()) {
                todoList.remove(0);
            }
            if (!inprogressList.isEmpty()) {
                inprogressList.remove(0);
            }
            if (!completedList.isEmpty()) {
                completedList.remove(0);
            }
        }

//        System.out.format(line);
    }
    private void truthChecker(String leftAlignFormat, ArrayList<SubTask> todoList, ArrayList<SubTask> inprogressList, ArrayList<SubTask> completedList) {
        for (int j = 0; j < 1; j++) {
            if (todoList.isEmpty() && inprogressList.isEmpty() && completedList.isEmpty()) {
//            System.out.println("0, 0, 0");
            } else if (todoList.isEmpty() && inprogressList.isEmpty() && !completedList.isEmpty()) {
                leftAlignFormat = "  %-36s    %-36s  | %-36s |%n";

                for (int i = 0; i < 1; i++) {
                    System.out.format(leftAlignFormat,
                            "",
                            "",
                            "Title: " + completedList.get(i).getTitle()
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            "",
                            "-----"
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            "",
                            completedList.get(i).getDescription()
                    );
                    System.out.format(leftAlignFormat, "", "", "");
                    System.out.format(leftAlignFormat,
                            "",
                            "",
                            "-----"
                    );

                    System.out.format(leftAlignFormat,
                            "",
                            "",
                            "Due:      " + completedList.get(i).getDueDate()
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            "",
                            "Priority: " + completedList.get(i).getPriority()
                    );
                    System.out.format(leftAlignFormat,
                            "Start Date: " + todoList.get(i).getStartDate(),
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            "Assigned: " + "Wario",
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            todoList.get(i).getId().toString(),
                            "",
                            ""
                    );
                }
                System.out.format("                                                                                +--------------------------------------+%n");
//                todoList.remove(j);
//                inprogressList.remove(j);
//                completedList.remove(j);
//            System.out.println("0, 0, C");
            } else if (todoList.isEmpty() && !inprogressList.isEmpty() && completedList.isEmpty()) {
                leftAlignFormat = "  %-36s  | %-36s |  %-36s  %n";

//                for (int i = 0; i < 1; i++) {
                System.out.format(leftAlignFormat,
                        "",
                        "Title: " + inprogressList.get(j).getTitle(),
                        ""
                );
                System.out.format(leftAlignFormat,
                        "",
                        "-----",
                        ""
                );
                System.out.format(leftAlignFormat,
                        "",
                        inprogressList.get(j).getDescription(),
                        ""
                );
                System.out.format(leftAlignFormat, "", "", "");
                System.out.format(leftAlignFormat,
                        "",
                        "-----",
                        ""
                );

                System.out.format(leftAlignFormat,
                        "",
                        "Due:      " + inprogressList.get(j).getDueDate(),
                        ""
                );
                System.out.format(leftAlignFormat,
                        "",
                        "Priority: " + inprogressList.get(j).getPriority(),
                        ""
                );
                System.out.format(leftAlignFormat,
                        "",
                        "Start Date: " + inprogressList.get(j).getStartDate(),
                        ""
                );
                System.out.format(leftAlignFormat,
                        "",
                        "Assigned: " + "Wario",
                        ""
                );
                System.out.format(leftAlignFormat,
                        "",
                        inprogressList.get(j).getId().toString(),
                        ""
                );
//                }
                System.out.format("                                        +--------------------------------------+                                        %n");
//                todoList.remove(j);
//                inprogressList.remove(j);
//                completedList.remove(j);
//            System.out.println("0, IP, 0");
            } else if (todoList.isEmpty() && !inprogressList.isEmpty() && !completedList.isEmpty()) {
                leftAlignFormat = "  %-36s  | %-36s || %-36s |%n";

                for (int i = 0; i < 1; i++) {
                    System.out.format(leftAlignFormat,
                            "",
                            "Title: " + inprogressList.get(i).getTitle(),
                            "Title: " + completedList.get(i).getTitle()
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            "-----",
                            "-----"
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            inprogressList.get(i).getDescription(),
                            completedList.get(i).getDescription()
                    );
                    System.out.format(leftAlignFormat, "", "", "");
                    System.out.format(leftAlignFormat,
                            "",
                            "-----",
                            "-----"
                    );

                    System.out.format(leftAlignFormat,
                            "",
                            "Due:      " + inprogressList.get(i).getDueDate(),
                            "Due:      " + completedList.get(i).getDueDate()
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            "Priority: " + inprogressList.get(i).getPriority(),
                            "Priority: " + completedList.get(i).getPriority()
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            "Start Date: " + inprogressList.get(i).getStartDate(),
                            "Start Date: " + completedList.get(i).getStartDate()
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            "Assigned: " + "Wario",
                            "Assigned: " + "Wario"
                    );
                    System.out.format(leftAlignFormat,
                            "",
                            inprogressList.get(i).getId().toString(),
                            completedList.get(i).getId().toString()
                    );
                }
                System.out.format("                                        +--------------------------------------++--------------------------------------+%n");
//                todoList.remove(j);
//                inprogressList.remove(j);
//                completedList.remove(j);
//            System.out.println("0, IP, C");
            } else if (!todoList.isEmpty() && inprogressList.isEmpty() && completedList.isEmpty()) {
                leftAlignFormat = "| %-36s |  %-36s    %-36s  %n";

                for (int i = 0; i < 1; i++) {
                    System.out.format(leftAlignFormat,
                            "Title: " + todoList.get(i).getTitle(),
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            "-----",
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            todoList.get(i).getDescription(),
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat, "", "", "");
                    System.out.format(leftAlignFormat,
                            "-----",
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            "Due:      " + todoList.get(i).getDueDate(),
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            "Priority: " + todoList.get(i).getPriority(),
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            "Start Date: " + todoList.get(i).getStartDate(),
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            "Assigned: " + "Wario",
                            "",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            todoList.get(i).getId().toString(),
                            "",
                            ""
                    );
                }
                System.out.format("+--------------------------------------+                                                                                %n");
//                todoList.remove(j);
//                inprogressList.remove(j);
//                completedList.remove(j);
//            System.out.println("T, 0, 0");
            } else if (!todoList.isEmpty() && inprogressList.isEmpty() && !completedList.isEmpty()) {
                leftAlignFormat = "| %-36s |  %-36s  | %-36s |%n";

                for (int i = 0; i < 1; i++) {
                    System.out.format(leftAlignFormat,
                            "Title: " + todoList.get(i).getTitle(),
                            "",
                            "Title: " + completedList.get(i).getTitle()
                    );
                    System.out.format(leftAlignFormat,
                            "-----",
                            "",
                            "-----"
                    );
                    System.out.format(leftAlignFormat,
                            todoList.get(i).getDescription(),
                            "",
                            completedList.get(i).getDescription()
                    );
                    System.out.format(leftAlignFormat, "", "", "");
                    System.out.format(leftAlignFormat,
                            "-----",
                            "",
                            "-----"
                    );

                    System.out.format(leftAlignFormat,
                            "Due:      " + todoList.get(i).getDueDate(),
                            "",
                            "Due:      " + completedList.get(i).getDueDate()
                    );
                    System.out.format(leftAlignFormat,
                            "Priority: " + todoList.get(i).getPriority(),
                            "",
                            "Priority: " + completedList.get(i).getPriority()
                    );
                    System.out.format(leftAlignFormat,
                            "Start Date: " + todoList.get(i).getStartDate(),
                            "",
                            "Start Date: " + completedList.get(i).getStartDate()
                    );
                    System.out.format(leftAlignFormat,
                            "Assigned: " + "Wario",
                            "",
                            "Assigned: " + "Wario"
                    );
                    System.out.format(leftAlignFormat,
                            todoList.get(i).getId().toString(),
                            "",
                            completedList.get(i).getId().toString()
                    );
                }
                System.out.format("+--------------------------------------+                                        +--------------------------------------+%n");
//                todoList.remove(j);
//                inprogressList.remove(j);
//                completedList.remove(j);
//            System.out.println("T, 0, C");
            } else if (!todoList.isEmpty() && !inprogressList.isEmpty() && completedList.isEmpty()) {
                leftAlignFormat = "| %-36s || %-36s |%n";

                for (int i = 0; i < 1; i++) {
                    System.out.format(
                            leftAlignFormat, "Title: " + todoList.get(i).getTitle(), "Title: " + inprogressList.get(i).getTitle(), ""
                    );
                    System.out.format(leftAlignFormat, "-----", "-----", "");
                    System.out.format(
                            leftAlignFormat, todoList.get(i).getDescription(), inprogressList.get(i).getDescription(), ""
                    );
                    System.out.format(leftAlignFormat, "", "", "");
                    System.out.format(leftAlignFormat, "-----", "-----", "");

                    System.out.format(
                            leftAlignFormat, "Due:      " + todoList.get(i).getDueDate(), "Due:      " + inprogressList.get(i).getDueDate(), ""
                    );
                    System.out.format(
                            leftAlignFormat, "Priority: " + todoList.get(i).getPriority(), "Priority: " + inprogressList.get(i).getPriority(), ""
                    );
                    System.out.format(leftAlignFormat,
                            "Start Date: " + todoList.get(i).getStartDate(),
                            "Start Date: " + inprogressList.get(i).getStartDate(),
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            "Assigned: " + "Wario",
                            "Assigned: " + "Wario",
                            ""
                    );
                    System.out.format(leftAlignFormat,
                            todoList.get(i).getId().toString(),
                            inprogressList.get(i).getId().toString(),
                            ""
                    );
                }
                System.out.format("+--------------------------------------++--------------------------------------+%n");
//                todoList.remove(j);
//                inprogressList.remove(j);
//                completedList.remove(j);
//            System.out.println("T, IP, 0");
            } else if (!todoList.isEmpty() && !inprogressList.isEmpty() && !completedList.isEmpty()) {
                leftAlignFormat = "| %-36s || %-36s || %-36s |%n";

//                for (int i = 0; i < 1; i++) {
                System.out.format(leftAlignFormat,
                        "Title: " + todoList.get(j).getTitle(),
                        "Title: " + inprogressList.get(j).getTitle(),
                        "Title: " + completedList.get(j).getTitle()
                );
                System.out.format(leftAlignFormat,
                        "-----",
                        "-----",
                        "-----"
                );
                System.out.format(leftAlignFormat,
                        todoList.get(j).getDescription(),
                        inprogressList.get(j).getDescription(),
                        completedList.get(j).getDescription()
                );
                System.out.format(leftAlignFormat, "", "", "");
                System.out.format(leftAlignFormat,
                        "-----",
                        "-----",
                        "-----"
                );
//                Controller controller = new Controller();
//                for (int i = 0; i < todoList.get(i).getChecklists().size(); i++) {
//
//                    while(todoList.get(i).getChecklists().size() <)
//                    System.out.format(leftAlignFormat,
//                            "Checklist: " + todoList.get(i).getChecklists().get(i).getName(),
//                            "",
//                            ""
//                    );
//                    System.out.format(leftAlignFormat,
//                            todoList.get(i).getChecklists().get(i).getId(),
//                            "",
//                            ""
//                    );
//                }
//                System.out.format(leftAlignFormat,
//                        "Checklist: " + todoList.get(j).getc,
//                        "Checklist: " + inprogressList.get(j).getDueDate(),
//                        "Checklist: " + completedList.get(j).getDueDate()
//                );
                System.out.format(leftAlignFormat,
                        "Due:      " + todoList.get(j).getDueDate(),
                        "Due:      " + inprogressList.get(j).getDueDate(),
                        "Due:      " + completedList.get(j).getDueDate()
                );
                System.out.format(leftAlignFormat,
                        "Priority: " + todoList.get(j).getPriority(),
                        "Priority: " + inprogressList.get(j).getPriority(),
                        "Priority: " + completedList.get(j).getPriority()
                );
                System.out.format(leftAlignFormat,
                        "Start Date: " + todoList.get(j).getStartDate(),
                        "Start Date: " + inprogressList.get(j).getStartDate(),
                        "Start Date: " + completedList.get(j).getStartDate()
                );
                System.out.format(leftAlignFormat,
                        "Assigned: " + "Wario",
                        "Assigned: " + "Wario",
                        "Assigned: " + "Wario"
                );
                System.out.format(leftAlignFormat,
                        todoList.get(j).getId().toString(),
                        inprogressList.get(j).getId().toString(),
                        completedList.get(j).getId().toString()
                );
//                }
                System.out.format("+--------------------------------------++--------------------------------------++--------------------------------------+%n");

//                todoList.remove(j);
//                inprogressList.remove(j);
//                completedList.remove(j);
//            System.out.println("T, IP, C");
            }
        }
    }
}
