import controllers.Controller;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;

public class Main {


    /**
     * Attributes
     */
    Controller controller;
//    StorageController storageController = new StorageController();


    /**
     * main
     * Comment out "launch(args);" if you want to run the console version
     */
    public static void main(String[] args) {
//        launch(args);
        Main main = new Main();
        main.runProgram();
    }


    /**
     * Console Version:
     */
    public void runProgram() {
        controller = new Controller();
        controller.executeViewsAndDatabase(controller);
    }


//    /**
//     * JavaFX Version:
//     * @param primaryStage
//     * Stage == window
//     * @throws Exception
//     * Can throw exception...
//     */
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//
//        // This is for loading the .fxml
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//
//        // This is for setting window Title, the Scene/window, then ".show" the window.
//        primaryStage.setTitle("Pomato - Project Manager Tool");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//    }
}
