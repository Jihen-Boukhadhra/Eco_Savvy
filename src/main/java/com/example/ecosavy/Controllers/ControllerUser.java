package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.InterfaceAccessFile;
import com.example.ecosavy.Models.Receiver;
import com.example.ecosavy.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControllerUser implements InterfaceAccessFile {
    @FXML
    private TableColumn<Receiver, String> NomCol;

    @FXML
    private TableColumn<Receiver, String> NomEntrepriseCol;

    @FXML
    private TableColumn<Receiver, User.Secteur> SecteurCol;

    @FXML
    private TableColumn<Receiver, String> emailCOl;

    @FXML
    private TableView<Receiver> tableReceiver;
    ObservableList<Receiver> listrec = FXCollections.observableArrayList();
    @FXML
    private void initialize() {
        NomCol.setCellValueFactory(new PropertyValueFactory<>("Nom_user"));
        emailCOl.setCellValueFactory(new PropertyValueFactory<>("Email_user"));

        SecteurCol.setCellValueFactory(new PropertyValueFactory<>("Secteur"));
        NomEntrepriseCol.setCellValueFactory(new PropertyValueFactory<>("Nom_entreprise"));

        loadUsersToTableView();
    }
    private void loadUsersToTableView() {
        String filePath = "E:/Users/tassm/Desktop/Users.txt";
        ObservableList<Receiver> userList = readUsersFromFile(filePath);

        // Clear existing data in the table
        tableReceiver.getItems().clear();

        // Add users to the table
        tableReceiver.getItems().addAll(userList);
    }
    @Override
    public   ObservableList<Receiver> readUsersFromFile(String filePath) {
        ObservableList<Receiver> listrec = FXCollections.observableArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Receiver receiver = createUserFromLine(line);
                listrec.add(receiver);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }

        return listrec;
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

}
