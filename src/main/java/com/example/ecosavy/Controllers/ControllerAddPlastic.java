package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Plastique;
import com.example.ecosavy.Models.Tissu;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ControllerAddPlastic {
    String filepath="E:/Users/tassm/Desktop/TissuDechet.txt";

    @FXML
    private JFXButton ButtonAddChemicalMat;

    @FXML
    private Button ButtonAddTrashFin;

    @FXML
    private ListView<String> chemicalCompositionListView;

    @FXML
    private TextField chemicalMaterialTextField;

    @FXML
    private ComboBox codePlasticField;

    @FXML
    private ComboBox isBiodegradableField;

    @FXML
    private ComboBox isRecyclableField;

    @FXML
    private TextField lifespanField;

    @FXML
    private TextField quantityStockField;

    @FXML
    private TextField typePlasticField;

    @FXML
    private TextField volumeTextField;

    @FXML
    private TextField wasteIdField;

    @FXML
    private TextField weightField;

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
    void handleButtonAddTrashFinAction(ActionEvent event) {
        try {
            String wasteId = wasteIdField.getText();

            String quantityStockText = quantityStockField.getText();
            double quantityStock = Double.parseDouble(quantityStockText);
            boolean isRecyclable = "TRUE".equals(isRecyclableField.getValue());
            boolean isBiodegradable = "TRUE".equals(isBiodegradableField.getValue());
            String typePlastic = typePlasticField.getText();
            int codePlastic=Integer.valueOf(codePlasticField.getValue().toString());
            Double lifeSpan = Double.parseDouble(lifespanField.getText());
            Double weight = Double.parseDouble(weightField.getText());

            Plastique trash = new Plastique(typePlastic,codePlastic, wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifeSpan);
            trash.setChemicalComposition(getChemicalCompositions());

            trash.saveToFile(filepath);
            Stage currentStage = (Stage) wasteIdField.getScene().getWindow();
            currentStage.close();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
