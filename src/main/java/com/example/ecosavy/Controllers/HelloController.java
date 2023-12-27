package com.example.ecosavy.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;

public class HelloController  {


        @FXML private Label label;


        public void handleButtonPress(ActionEvent event) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceLogin.fxml"));
                Parent root = loader.load();
                ControllerLogin loginController = loader.getController();
                Scene loginScene = new Scene(root);
                Stage currentStage = (Stage) label.getScene().getWindow();
                currentStage.setTitle("Login Interface");
                currentStage.setScene(loginScene);

                loginScene.getWindow().centerOnScreen();
                currentStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}