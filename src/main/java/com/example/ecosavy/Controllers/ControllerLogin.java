package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Receiver;
import com.example.ecosavy.Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControllerLogin {


    @FXML
    private Button ButtonLogin;
    @FXML
    private TextField email;

    @FXML
    private PasswordField passwordField;



    public   List<Receiver> readUsersFromFile(String filePath) {
        List<Receiver> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Receiver receiver = createUserFromLine(line);
                userList.add(receiver);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }

        return userList;
    }

    public  Receiver createUserFromLine(String line) {
        String[] parts = line.split(";");
        if (parts.length == 5 ) {

            String username = parts[0];
            String email = parts[1];
            String password = parts[2];

            String sector = parts[3];
            String companyName = parts[4];
            User.Secteur secteur= User.Secteur.valueOf(sector);
            return new Receiver (username,email,secteur,companyName,password);
        } else {
            // Handle incorrect format or invalid data
            throw new IllegalArgumentException("Invalid data format: " + line);
        }}
    @FXML
    public void Login(ActionEvent event) {
        String enteredEmail = email.getText()/* retrieve entered email */;
        String enteredPassword = passwordField.getText() /* retrieve entered password */;
        // Check if the entered credentials match to the provider account
        if (enteredEmail.equals("tasnimemaamouri@gmail.com")&&enteredPassword.equals("tas123Pro")) {
            // Redirect to the "interface receiver"
            redirectToProviderInterface();
            return;

        }else{
        String filepath="E:/Users/tassm/Desktop/Users.txt";
        List<Receiver> userList = readUsersFromFile(filepath);



        // Check if the entered credentials match any Receiver in the list
        for (Receiver user : userList) {
            if (user.getEmail_user().equals(enteredEmail) && user.getPassword().equals(enteredPassword)) {
                // Redirect to the "interface receiver"
                redirectToReceiverInterface();
                return; // Exit the method if the credentials match
            }
        }}

        // If the loop completes without finding a matching user
        showAlert("Incorrect email or password");
    }

    private void redirectToReceiverInterface() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceReceiver.fxml"));
            Parent root = loader.load();
            ControllerReceiver controllerReceiver = loader.getController();
            Scene receiverScene = new Scene(root);
            Stage currentStage = (Stage) ButtonLogin.getScene().getWindow();
            currentStage.setTitle("Receiver Interface");
            currentStage.setScene(receiverScene);

            receiverScene.getWindow().centerOnScreen();
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void redirectToProviderInterface() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceProvider.fxml"));
            Parent root = loader.load();
            ControllerProvider controllerProvider = loader.getController();
            Scene providerScene = new Scene(root);
            Stage currentStage = (Stage) ButtonLogin.getScene().getWindow();
            currentStage.setTitle("Provider Interface");
            currentStage.setScene(providerScene);

            providerScene.getWindow().centerOnScreen();
            currentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void handleButtonSignUpPress(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceSignUp.fxml"));
            Parent root = loader.load();
            ControllerSignUp SignUpController = loader.getController();
            Scene SignUpScene = new Scene(root);

            Stage SignUpStage = new Stage();

            SignUpStage.setTitle("SignUp Interface");
            SignUpStage.setScene(SignUpScene);

            SignUpScene.getWindow().centerOnScreen();


            // Show the SignUp interface
            SignUpStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleButtonForgotPassPress(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("we will send a new password in your address email ");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceSendMail.fxml"));
                Parent root = loader.load();
                ControllerSendMail sendMailController = loader.getController();
                Scene sendMailScene = new Scene(root);
                Stage sendMailStage = new Stage();
                sendMailStage.setTitle("Send Mail Interface");
                sendMailStage.setScene(sendMailScene);

                sendMailScene.getWindow().centerOnScreen();
                sendMailStage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
