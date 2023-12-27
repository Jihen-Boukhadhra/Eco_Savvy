package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Dechet;
import com.example.ecosavy.Models.InterfaceAccessFile;
import com.example.ecosavy.Models.Receiver;
import com.example.ecosavy.Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ControllerTrash implements Initializable{



    @FXML
    private TableColumn<Dechet, Boolean> IsBidogradableCol;

    @FXML
    private TableColumn<Dechet, Boolean> IsRecycableCol;

    @FXML
    private TableColumn<Dechet, String> WasteIdCol;

    @FXML
    private TableColumn<Dechet, Double> quantityStockCol;

    @FXML
    private TableView<Dechet> tableTrash;

    @FXML
    private Button ButtonAddElectronic;

    @FXML
    private Button ButtonAddPlastic;

    @FXML
    private Button ButtonAddTissu;

    @FXML
    private Button ButtonVerre;


    ObservableList<Dechet> listrec = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WasteIdCol.setCellValueFactory(new PropertyValueFactory<>("wasteId"));
        IsRecycableCol.setCellValueFactory(new PropertyValueFactory<>("isRecyclable"));
        IsBidogradableCol.setCellValueFactory(new PropertyValueFactory<>("isBiodegradable"));
        quantityStockCol.setCellValueFactory(new PropertyValueFactory<>("quantityStock"));

        loadTrashToTableView();


    }
    private void loadTrashToTableView() {
        String filePath = "E:/Users/tassm/Desktop/TissuDechet.txt";
        ObservableList<Dechet> userList = readTrashFromFile(filePath);

        // Clear existing data in the table
        tableTrash.getItems().clear();

        // Add users to the table
        tableTrash.getItems().addAll(userList);
    }



    public   ObservableList<Dechet> readTrashFromFile(String filePath) {
        ObservableList<Dechet> listrec = FXCollections.observableArrayList();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Dechet dechet = createDechetFromLine(line);
                listrec.add(dechet);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }

        return listrec;
    }

    public  Dechet createDechetFromLine(String line) {
        String[] parts = line.split(";");


            String wasteId = parts[0];
            String isRecyclable = parts[1];
            String isBiodegradable = parts[2];

            String quantityStock = parts[3];


            Dechet d1=new Dechet(wasteId,Boolean.parseBoolean(isRecyclable),Boolean.parseBoolean(isBiodegradable),Double.parseDouble(quantityStock));

            return d1;
        }
    @FXML
    void handleButtonAddElectronicPress(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceAddElectronicTrash.fxml"));
            Parent root = loader.load();
            ControllerAddElectronic AddElectronicController = loader.getController();
            Scene AddTrashScene = new Scene(root);

            Stage AddTrashStage = new Stage();

            AddTrashStage.setTitle("ADD_Electronic Interface");
            AddTrashStage.setScene(AddTrashScene);

            AddTrashScene.getWindow().centerOnScreen();


            // Show the SignUp interface
            AddTrashStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleButtonAddPlasticPress(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceAddPlasticTrash.fxml"));
            Parent root = loader.load();
            ControllerAddPlastic AddPlasticController = loader.getController();
            Scene AddTrashScene = new Scene(root);

            Stage AddTrashStage = new Stage();

            AddTrashStage.setTitle("ADD_Plastic Interface");
            AddTrashStage.setScene(AddTrashScene);

            AddTrashScene.getWindow().centerOnScreen();


            // Show the SignUp interface
            AddTrashStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void handleButtonAddVerrePress(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceAddVerreTrash.fxml"));
            Parent root = loader.load();
            ControllerAddVerre AddVerreController = loader.getController();
            Scene AddTrashScene = new Scene(root);

            Stage AddTrashStage = new Stage();

            AddTrashStage.setTitle("ADD_Verre Interface");
            AddTrashStage.setScene(AddTrashScene);

            AddTrashScene.getWindow().centerOnScreen();


            // Show the SignUp interface
            AddTrashStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void handleButtonAddTissuPress(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceAddTissuTrash.fxml"));
            Parent root = loader.load();
            ControllerAddTissu AddTissuController = loader.getController();
            Scene AddTrashScene = new Scene(root);

            Stage AddTrashStage = new Stage();

            AddTrashStage.setTitle("ADD_TISSU Interface");
            AddTrashStage.setScene(AddTrashScene);

            AddTrashScene.getWindow().centerOnScreen();


            // Show the SignUp interface
            AddTrashStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*public void handleButtonAddTrashPress(ActionEvent event)throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceAddTissuTrash.fxml"));
            Parent root = loader.load();
            ControllerAddTissu AddTrashController = loader.getController();
            Scene AddTrashScene = new Scene(root);

            Stage AddTrashStage = new Stage();

            AddTrashStage.setTitle("AddTrash Interface");
            AddTrashStage.setScene(AddTrashScene);

            AddTrashScene.getWindow().centerOnScreen();


            // Show the SignUp interface
            AddTrashStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    @FXML
    void handleButtonSupprimer(ActionEvent event) {
        int selectedIndex = tableTrash.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("We will delete this item");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){

            tableTrash.getItems().remove(selectedIndex);}

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);

            alert.setTitle("Aucune sélection");

            alert.setHeaderText("Aucun trash sélectionné");

            alert.setContentText("SVP sélectionnez une trash dans la table");

            alert.showAndWait();
    }}

}
