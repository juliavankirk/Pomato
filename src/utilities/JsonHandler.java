package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
import controllers.Controller;
import model.project.Database;
import model.project.Project;

import java.io.*;
import java.time.LocalDate;

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

            // TODO add the members back to a project
//            for (int i = 0; i < database.getUserList().size(); i++) {
//
//            }

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
