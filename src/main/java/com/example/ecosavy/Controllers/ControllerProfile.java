package com.example.ecosavy.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class ControllerProfile {

    @FXML
    private Button SignOut;

    @FXML
    void SignOut(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/hello-view.fxml"));
            Parent startRoot = loader.load();
            Scene loginScene = new Scene(startRoot);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(loginScene);
            loginScene.getWindow().centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}