package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Commentaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerComments implements Initializable {

        @FXML
        private Button add;
        @FXML
        private Text auteur;
        @FXML
        private TableColumn<Commentaire, String> auteurCol;
        @FXML
        private TextField auteurInput;
        @FXML
        private Text contenu;
        @FXML
        private TableColumn<Commentaire, String> contenuCol;
        @FXML
        private TextField contenuInput;
        @FXML
        private Text id;
        @FXML
        private TableColumn<Commentaire, String> idCol;
        @FXML
        private TextField idInput;
        @FXML
        private Button remove;
        @FXML
        private TableView<Commentaire> tableComm;
        @FXML
        private Text titre;
        @FXML
        private TableColumn<Commentaire, String> libelleCol;
        @FXML
        private TextField titreInput;

        ObservableList<Commentaire> initialData(){
            Commentaire  R1 = new Commentaire("01","Feedback1"," Jihen", "Cette app est magnifique.");
            Commentaire R2 = new Commentaire("02","Feedback2"," Tasnim","L'usage de EcoSavvy est très clair. ");
            return FXCollections.observableArrayList(R1, R2);
        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            idCol.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("ID_Comment"));
            libelleCol.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("Libelle"));
            contenuCol.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("Contenu"));
            auteurCol.setCellValueFactory(new PropertyValueFactory<Commentaire,String>("Auteur"));

            Commentaire  R1 = new Commentaire("01","Feedback1"," Jihen", "Cette app est magnifique.");
            Commentaire R2 = new Commentaire("02","Feedback2"," Tasnim","L'usage de EcoSavvy est très clair. ");
            ObservableList<Commentaire> listComnt=FXCollections.observableArrayList(R1, R2);



            // Add users to the table
            tableComm.setItems(listComnt);

        }
        @FXML
        void addComment(ActionEvent event) {
            Commentaire commentaire = new Commentaire(idInput.getText(), titreInput.getText(), auteurInput.getText(), contenuInput.getText());
            ObservableList<Commentaire> commentaires = tableComm.getItems();
            commentaires.add(commentaire);
            tableComm.setItems(commentaires);
        }

        @FXML
        void removeComment(ActionEvent event) {
            int selectedID = tableComm.getSelectionModel().getSelectedIndex();
            tableComm.getItems().remove(selectedID);
        }
    }


