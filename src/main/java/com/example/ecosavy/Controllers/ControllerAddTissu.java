package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.InvalidQuantityException;
import com.example.ecosavy.Models.Receiver;
import com.example.ecosavy.Models.Tissu;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class ControllerAddTissu {



    String filepath="E:/Users/tassm/Desktop/TissuDechet.txt";
    @FXML
    private JFXButton ButtonAddChemicalMat;

    @FXML
    private JFXButton ButtonAddFabricMateiral;

    @FXML
    private Button ButtonAddTrashFin;

    @FXML
    private TextField ColorField;

    @FXML
    private ComboBox IsBiodegradableField;

    @FXML
    private ComboBox IsRecyclableField;

    @FXML
    private TextField LifeSpanField;

    @FXML
    private TextField WasteIdField;

    @FXML
    private TextField WeightField;

    @FXML
    private ListView<String> chemicalCompositionListView;

    @FXML
    private TextField chemicalMaterialTextField;

    @FXML
    private TextField fabricMaterialTextField;

    @FXML
    private ListView<String> fabricMaterialsListView;

    @FXML
    private TextField quantityStockField;

    @FXML
    private TextField volumeTextField;

    @FXML
    void handleButtonAddTrashFinAction(ActionEvent event) {
        try {
            String wasteId = WasteIdField.getText();

            String quantityStockText = quantityStockField.getText();
            double quantityStock = Double.parseDouble(quantityStockText);
            boolean isRecyclable = "TRUE".equals(IsRecyclableField.getValue());
            boolean isBiodegradable = "TRUE".equals(IsBiodegradableField.getValue());
            String color = ColorField.getText();
            Double lifeSpan = Double.parseDouble(LifeSpanField.getText());
            Double weight = Double.parseDouble(WeightField.getText());

            Tissu trash = new Tissu(color, wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifeSpan);
            trash.setChemicalComposition(getChemicalCompositions());
            trash.setFabricMaterials(getFabricMaterials());
            trash.saveToFile(filepath);
            Stage currentStage = (Stage) WasteIdField.getScene().getWindow();
            currentStage.close();
        }catch(Exception e){
            e.getMessage();
        }

    }



   /* @FXML
    void HandleButtonTypeNextAction(ActionEvent event) {
        String filepath = "/com/example/ecosavy/InterfaceAddElectronicTrash.fxml";
        type = handleComboBoxSelection();

        switch (type) {
            case "Electronic":
                filepath = "/com/example/ecosavy/InterfaceAddElectronicTrash.fxml";
                break;
            case "Tissu":
                filepath = "/com/example/ecosavy/InterfaceAddTissuTrash.fxml";
                break;
            case "Verre":
                filepath = "/com/example/ecosavy/InterfaceAddVerreTrash.fxml";
                break;
            case "Plastic":
                filepath = "/com/example/ecosavy/InterfaceAddPlasticTrash.fxml";
                break;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filepath));
            Parent root = loader.load();
            ControllerAddTissu AddTrashController = loader.getController();
            Scene AddTrashScene = new Scene(root);

            Stage AddTrashStage = new Stage();

            AddTrashStage.setTitle("AddTrash Interface");
            AddTrashStage.setScene(AddTrashScene);

            AddTrashScene.getWindow().centerOnScreen();
            Stage currentStage = (Stage) ComboType.getScene().getWindow();
            currentStage.close();

            // Show the SignUp interface
            AddTrashStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String handleComboBoxSelection() {
        String selectedCategory = ComboType.getValue();
        return selectedCategory;
    }*/

    @FXML
    void handleButtonAddChemicalMatAction(ActionEvent event) {
        String chemicalMaterial = chemicalMaterialTextField.getText();
        String volume = volumeTextField.getText();

        if (!chemicalMaterial.isEmpty() && !volume.isEmpty()) {
            String composition = chemicalMaterial + ": " + volume;
            chemicalCompositionListView.getItems().add(composition);
            chemicalMaterialTextField.clear();
            volumeTextField.clear();
        }
    }

    /* @FXML
     void handleButtonRemoveChemicalMatAction(ActionEvent event) {
         ObservableList<String> selectedItems = chemicalCompositionListView.getSelectionModel().getSelectedItems();
         chemicalCompositionListView.getItems().removeAll(selectedItems);
     }*/
    public Map<String, Double> getChemicalCompositions() {
        Map<String, Double> chemicalCompositions = new HashMap<>();

        for (String composition : chemicalCompositionListView.getItems()) {
            String[] parts = composition.split(": ");
            String chemicalMaterial = parts[0];
            Double volume = Double.valueOf(parts[1]);
            chemicalCompositions.put(chemicalMaterial, volume);
        }

        return chemicalCompositions;
    }


    @FXML
    void handleButtonAddFabricMateiralAction(ActionEvent event) {
        String fabricMaterial = fabricMaterialTextField.getText();
        if (!fabricMaterial.isEmpty()) {
            fabricMaterialsListView.getItems().add(fabricMaterial);
            fabricMaterialTextField.clear();
        }
    }

    public ArrayList<String> getFabricMaterials() {
        return new ArrayList<>(fabricMaterialsListView.getItems());
    }


    /*public void handleButtonAddTrashPress(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/ecosavy/InterfaceTypeTrash.fxml"));
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





}