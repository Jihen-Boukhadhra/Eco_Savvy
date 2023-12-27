package com.example.ecosavy.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerProvider implements Initializable {
    @FXML
    private BorderPane borderPane;

    // Add an event handler for each JFXButton
    @FXML
    private void handleDashboardButton() {
        loadInterface("/com/example/ecosavy/InterfaceDashboard.fxml");
    }

    @FXML
    private void handleTrashButton() {
        loadInterface("/com/example/ecosavy/InterfaceTrash.fxml");
    }
    @FXML
    void handleClientsButton(ActionEvent event) {
        loadInterface("/com/example/ecosavy/InterfaceUser.fxml");
    }

    @FXML
    void handleCommentsButton(ActionEvent event) {
        loadInterface("/com/example/ecosavy/InterfaceComment.fxml");
    }
    @FXML
    void handlePriceTrashButton(ActionEvent event) {
        loadInterface("/com/example/ecosavy/InterfacePriceTrash.fxml");
    }

    @FXML
    void handleRapportButton(ActionEvent event) {
        loadInterface("/com/example/ecosavy/InterfaceReportPro.fxml");
    }
    @FXML
    void handleButtonProfileAction(ActionEvent event) {
        loadInterface("/com/example/ecosavy/InterfaceProfile.fxml");
    }

    // Method to load the FXML file into the BorderPane
    private void loadInterface(String fxmlFileName) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            Pane interfacePane = loader.load();

            // Set the loaded interface into the center of the BorderPane
            borderPane.setCenter(interfacePane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadInterface("/com/example/ecosavy/InterfaceDashboard.fxml");
    }
}
