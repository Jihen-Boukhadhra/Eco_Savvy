package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Commentaire;
import com.example.ecosavy.Models.Rapport_Recyclage;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerReportRec implements Initializable {

    @FXML
    private Button add;
    @FXML
    private TextField auteurInput;
    @FXML
    private TextField contenuInput;
    @FXML
    private TextField idInput;
    @FXML
    private Button remove;
    @FXML
    private TextField titreInput;
    @FXML
    private TableColumn<Rapport_Recyclage, String> auteurCol;


    @FXML
    private TableColumn<Rapport_Recyclage, String> contenuCol;


    @FXML
    private TableColumn<Rapport_Recyclage, String> idCol;

    @FXML
    private TableView<Rapport_Recyclage> tableComm;

    @FXML
    private TableColumn<Rapport_Recyclage, String> libelleCol;


    /*ObservableList<Rapport_Recyclage> initialData(){
        Rapport_Recyclage  R1 = new Rapport_Recyclage("01","Feedback1"," Jihen", "Le recyclage des textiles permet d'éviter l'utilisation de fibres vierges.");
        Rapport_Recyclage R2 = new Rapport_Recyclage("02","Feedback2"," Tasnim","Ce recyclage assure la réduction ddes matériaux toxiques.");
        return FXCollections.observableArrayList(R1, R2);
    }*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Rapport_Recyclage,String>("Id_Rapport"));
        libelleCol.setCellValueFactory(new PropertyValueFactory<Rapport_Recyclage,String>("Titre"));
        contenuCol.setCellValueFactory(new PropertyValueFactory<Rapport_Recyclage,String>("Contenu"));
        auteurCol.setCellValueFactory(new PropertyValueFactory<Rapport_Recyclage,String>("Auteur"));

        Rapport_Recyclage  R1 = new Rapport_Recyclage("01","RecyclageTissu"," Jihen", "Le recyclage des textiles permet d'éviter l'utilisation de fibres vierges.");
        Rapport_Recyclage R2 = new Rapport_Recyclage("02","matériauxToxiques"," Tasnim","Ce recyclage assure la réduction ddes matériaux toxiques.");
        Rapport_Recyclage  R3 = new Rapport_Recyclage("03","Carbon%"," Ahmed", "Cette app permet de réduire le pourcenatge de corbone dans le monde entier .");
        Rapport_Recyclage R4 = new Rapport_Recyclage("04","Général"," hani","Rapport positif.");
        Rapport_Recyclage  R5 = new Rapport_Recyclage("05","Electronic"," Mohamed", "Le recyclage des éléctroniques permet d'éviter l'utilisation de fibres toxiques.");
        Rapport_Recyclage R6 = new Rapport_Recyclage("06","Général"," Salma","Rapport positif.");
        ObservableList<Rapport_Recyclage> listComnt=FXCollections.observableArrayList(R1, R2,R3,R4,R5,R6);



        // Add users to the table
        tableComm.setItems(listComnt);

    }

    @FXML
    void addRapport(ActionEvent event) {
        Rapport_Recyclage rapport = new Rapport_Recyclage(idInput.getText(), titreInput.getText(), auteurInput.getText(), contenuInput.getText());
        ObservableList<Rapport_Recyclage> rapports = tableComm.getItems();
        rapports.add(rapport);
        tableComm.setItems(rapports);
    }

    @FXML
    void removeRapport(ActionEvent event) {
        int selectedID = tableComm.getSelectionModel().getSelectedIndex();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("We will delete this item");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        tableComm.getItems().remove(selectedID);}
    }

}


