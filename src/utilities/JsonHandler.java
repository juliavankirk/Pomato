package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controllers.Controller;
import model.users.User;

import java.io.*;

public class JsonHandler {

    public void test(Controller controller) {
        JsonHandler jsonHandler = new JsonHandler();

        try {
            User user1 = controller.getCurrentUser();

            jsonHandler.saveToJson(user1);

//            User user2 = jsonHandler.loadFromJson();

        } catch (FileNotFoundException notFoundException){
            notFoundException.printStackTrace();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

    }

    private User loadFromJson() throws FileNotFoundException {
        String fileLocation = "data/user_test.json";

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));

        User user = gson.fromJson(bufferedReader, User.class);
        return user;
    }

    private void saveToJson(User user) throws IOException {
        String fileLocation = "data/user_test.json";

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        FileWriter fileWriter = new FileWriter(fileLocation);
        fileWriter.write(gson.toJson(user));
        fileWriter.close();
    }

    private void serializeUserNested(){
        User user = new User();
    }
}
