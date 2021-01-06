package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
import controllers.Controller;
import model.project.Database;
import model.project.Project;
import model.users.Role;
import model.users.User;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class JsonHandler {

    public void saveDatabase(Controller controller) {
        JsonHandler jsonHandler = new JsonHandler();
        Database database = controller.getDatabase();

        try {
            Project project = controller.getCurrentProject();
            jsonHandler.saveToJson(database);

        } catch (FileNotFoundException notFoundException){
            System.out.println("File was not found.");
            notFoundException.printStackTrace();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public Database loadDatabase() throws FileNotFoundException {
        String fileLocation = "data/user_test.json";
        Database database = new Database();

        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new DateDeserializer());

            Gson gson = gsonBuilder.setPrettyPrinting().create();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));

            database = gson.fromJson(bufferedReader, Database.class);

            // TODO Refactor this monster. It is not working properly.
            //  This nested for loop is supposed to add a User back to a Project,
            //  since we do not save the ProjectMembers in the Project class.
            Collection<User> userList = database.getUserList();
            for (Iterator<User> iterator = userList.iterator(); iterator.hasNext();) {
                User currentUser = iterator.next();

                for (int i = 0; i < currentUser.getRoles().size(); i++) {
                    String currentRoleId = currentUser.getRoles().get(i).getProjectId();

                    for (int j = 0; j < currentUser.getProjects().size(); j++) {
                        Project currentProject = currentUser.getProjects().get(j);
                        String currentProjectId = currentProject.getId().toString();

                        if (currentProjectId.equals(currentRoleId)) {

                            if (currentProject.getProjectMembers() == null) {
                                ArrayList<User> tempUserList = new ArrayList<>();
                                tempUserList.add(currentUser);
                                currentProject.setProjectMembers(tempUserList);
                            } else {
                                currentProject.getProjectMembers().add(currentUser);
                            }
                        }
                    }

                }
            }

        } catch (FileNotFoundException notFoundException){
            System.out.println("File was not found.");
            notFoundException.printStackTrace();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

        return database;
    }

    private <T> void saveToJson(T anyT) throws IOException {
        String fileLocation = "data/user_test.json";

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new DateSerializer());

        Gson gson = gsonBuilder.create();

        FileWriter fileWriter = new FileWriter(fileLocation);
        fileWriter.write(gson.toJson(anyT));
        fileWriter.close();
    }
}
