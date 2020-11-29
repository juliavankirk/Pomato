//package controllers;
//
//import javafx.animation.FadeTransition;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.VBox;
//import javafx.util.Duration;
//
//import java.io.Serializable;
//
//public class InterfaceController implements Serializable {
//
//    public TextField displayName;
//    public TextField displayPassword;
//    public VBox mainField;
//    public VBox inputField;
//    public TextArea showManual;
//    public Button buttonBack;
//
//    public void pressExit(ActionEvent actionEvent) {
//        System.exit(0);
//    }
//
//    public void pressRegister(ActionEvent actionEvent) {
//        if (actionEvent.equals(actionEvent)) {
//            FadeTransition t = new FadeTransition(new Duration(500),inputField);
//            t.setFromValue(0);
//            t.setToValue(1);
//            t.play();
//        }
////        inputField.setOpacity(1.0);
//    }
//
//    public void pressLogin(ActionEvent actionEvent) {
//        if (actionEvent.equals(actionEvent)) {
//            FadeTransition fade = new FadeTransition(new Duration(500),inputField);
//            fade.setFromValue(0);
//            fade.setToValue(1);
//            fade.play();
//        }
////        inputField.setOpacity(1.0);
//    }
//
//    public void pressManual(ActionEvent actionEvent) {
//        buttonBack.setOpacity(1);
//
//        if (actionEvent.equals(actionEvent)) {
//            FadeTransition fade = new FadeTransition(new Duration(500),mainField);
//            fade.setFromValue(1);
//            fade.setToValue(0);
//            fade.play();
//            mainField.setDisable(true);
//            inputField.setDisable(true);
//
//            FadeTransition fade2 = new FadeTransition(new Duration(1000),showManual);
//            fade2.setFromValue(0);
//            fade2.setToValue(1);
//            fade2.play();
//        }
////        mainField.setOpacity(0.0);
//    }
//
//    public void pressBack(ActionEvent actionEvent) {
//        buttonBack.setOpacity(0);
//
//        if (actionEvent.equals(actionEvent)) {
//            FadeTransition fade = new FadeTransition(new Duration(1000),mainField);
//            fade.setFromValue(0);
//            fade.setToValue(1);
//            fade.play();
//            mainField.setDisable(false);
//            inputField.setDisable(false);
//
//            FadeTransition fade2 = new FadeTransition(new Duration(500),showManual);
//            fade2.setFromValue(1);
//            fade2.setToValue(0);
//            fade2.play();
//        }
//    }
//}
