package com.example.ecosavy.Controllers;


import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import com.example.ecosavy.Models.Dechet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
public class ControllerTrashRec implements Initializable {

    @FXML
    private TextField barre;
    @FXML
    private TableView<Dechet> tableview;

    @FXML
    private TableColumn<Dechet, Boolean> isbioCol;

    @FXML
    private TableColumn<Dechet, Boolean> isrecCol;

    @FXML
    private TableColumn<Dechet, Double> qCol;



    @FXML
    private TableColumn<Dechet, String> widCol;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        widCol.setCellValueFactory(new PropertyValueFactory<Dechet,String>("wasteId"));
        isrecCol.setCellValueFactory(new PropertyValueFactory<Dechet,Boolean>("isRecyclable"));
        isbioCol.setCellValueFactory(new PropertyValueFactory<Dechet,Boolean>("isBiodegradable"));
        qCol.setCellValueFactory(new PropertyValueFactory<Dechet,Double>("quantityStock"));


        Dechet D1 = new Dechet("W1", true, true, 250.0);
        Dechet D2 = new Dechet("W2", true, false, 50.0);
        Dechet D3 = new Dechet("W3", false, true, 160.0);
        Dechet D4 = new Dechet("W4", true, true, 100.0);
        Dechet D5 = new Dechet("W5", false, false, 50.0);

        ObservableList<Dechet> dataList = FXCollections.observableArrayList(D1, D2, D3, D4, D5);

        tableview.setItems(dataList);
    }
}
















// Wrap the ObservableList in a FilteredList (initially display all data).
       /* FilteredList<Dechet> filteredData = new FilteredList<>(dataList, b -> true);

        // Set the filter Predicate whenever the filter changes.
        barre.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(dechet -> {
                // If filter text is empty, display all trashes.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Implement your filtering logic here.
                return dechet.isIsRecyclable(); // Example: Only show recyclable items.

            });
        });

        // Wrap the FilteredList in a SortedList.
        SortedList<Dechet> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        // Add sorted (and filtered) data to the table.
        tableview.setItems(sortedData);
    }*/