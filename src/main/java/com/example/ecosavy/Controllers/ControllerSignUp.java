package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Receiver;
import com.example.ecosavy.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ControllerSignUp {

    String filepath="E:/Users/tassm/Desktop/Users.txt";

    @FXML
    private Button ButtonSignUpFIN;
    @FXML
    private TextField CompanyField;

    @FXML
    private TextField PhoneField;

    @FXML
    private ComboBox SectorField;

    @FXML
    private TextField UsernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;
    public void initialize() {
        // Add an event listener to handle the selected item change
        SectorField.setOnAction(event -> handleComboBoxSelection());
    }
    private String handleComboBoxSelection() {
        String selectedCategory = (String) SectorField.getValue();
        return selectedCategory;
    }
    @FXML
    void handleButtonSignUpFINPress(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();
        String username = UsernameField.getText();
        String sector = handleComboBoxSelection();
        String companyName = CompanyField.getText();
        User.Secteur secteur=User.Secteur.valueOf(sector);

        // Save data to a file
        Receiver receiver=new Receiver(username,email,secteur,companyName,password);
        receiver.saveToFile(filepath);
        // Show a success alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ACCOUNT CREATION");
        alert.setHeaderText(null);
        alert.setContentText("ACCOUNT CREATED successfully!");
        alert.showAndWait();
        Stage currentStage = (Stage) ButtonSignUpFIN.getScene().getWindow();
        currentStage.close();
    }





}