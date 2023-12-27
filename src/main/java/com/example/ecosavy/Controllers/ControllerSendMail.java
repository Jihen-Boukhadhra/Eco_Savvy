package com.example.ecosavy.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

public class ControllerSendMail {
    @FXML
    private TextField email;
    @FXML
    private TextField Nom_Prenom;


    public void handleButtonSendPress(ActionEvent event) {
        // Get your email credentials
        String username = "tasnimemaamouri@gmail.com";
        String password = "czpr lhhz jwam gxpo";

        // Set up the email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with the email credentials
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText()));
            message.setSubject("New password");
            Random rand = new Random();

            String nvMDP = rand.ints(48, 123)

                    .filter(num -> (num<57 || num>=65) && (num<=90 || num>=97))

                    .limit(15)

                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)

                    .toString();

            message.setText("Bonjour,"+Nom_Prenom.getText()+"\n voici votre nouveau mot de passe : "+nvMDP);

            // Send the message
            Transport.send(message);

            // Show a success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Email Sent");
            alert.setHeaderText(null);
            alert.setContentText("Email sent successfully!");
            alert.showAndWait();

            // Clear fields after sending
            email.clear();
            Stage currentStage = (Stage) email.getScene().getWindow();
            currentStage.close();



        } catch (MessagingException e) {
            e.printStackTrace();
            // Show an error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error occurred while sending email. Please check your email credentials and try again.");
            alert.showAndWait();
        }
    }
    }

