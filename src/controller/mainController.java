package controller;
import java.util.ArrayList;
import Model.users.User;
import Model.users.Employee;
import tool.InputOutput;

public class mainController {
    //  InputOutput inputOutput = new InputOutput();
    //Attributes
    private ArrayList<User> users;


    //Constructors
    public mainController() {
        this.users = new ArrayList<User>();
    }



    public void addEmployee(String firstName, String lastName, String userName, String password) {
        Employee employee = new Employee(firstName, lastName, userName, password);
        users.add(employee);

    }
    public int getId(String employeeId) {
        int idToRemove = -1;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(employeeId)) {
                idToRemove = i;
            }
        }
        return idToRemove;
    }

    public ArrayList<User> removeEmployee(String employeeId)  {
        int employee = getId(employeeId);
        if (employee != -1) {
            users.remove(employee);
            System.out.println("Your account has been removed");
        } else {
            System.out.println("User account with ID: " + employeeId + " was not found");
        }
        return users;
    }




}
