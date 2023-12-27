package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Electronic;
import com.example.ecosavy.Models.Verre;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ControllerAddElectronic {
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
    private ComboBox containsRareMatField;

    @FXML
    private TextField e_waste_categField;

    @FXML
    private ComboBox isBiodegradableField;

    @FXML
    private ComboBox isRecyclableField;

    @FXML
    private TextField lifespanField;

    @FXML
    private TextField quantityStockField;

    @FXML
    private ComboBox usabilityField;

    @FXML
    private TextField voltageField;

    @FXML
    private TextField volumeTextField;

    @FXML
    private TextField wasteIdField;

    @FXML
    private TextField weightField;
    @FXML
    private DatePicker manufacturingDateField;

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
            String categorie_Elec = e_waste_categField.getText();
            double quantityStock = Double.parseDouble(quantityStockText);
            int voltage=Integer.valueOf(voltageField.getText());
            LocalDate local_date_prod =manufacturingDateField.getValue();
            Instant instant = Instant.from(local_date_prod.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            boolean isRecyclable = "TRUE".equals(isRecyclableField.getValue());
            boolean isBiodegradable = "TRUE".equals(isBiodegradableField.getValue());
            boolean containsRareMat = "TRUE".equals(containsRareMatField.getValue());
            Electronic.Status usability= Electronic.Status.valueOf(usabilityField.getValue().toString());

            Double lifeSpan = Double.parseDouble(lifespanField.getText());
            Double weight = Double.parseDouble(weightField.getText());

            Electronic trash = new Electronic(voltage,usability,categorie_Elec,containsRareMat,date, wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifeSpan);
            trash.setChemicalComposition(getChemicalCompositions());

            trash.saveToFile(filepath);
            Stage currentStage = (Stage) wasteIdField.getScene().getWindow();
            currentStage.close();

        }catch(Exception e){
            e.getMessage();
        }
    }
}
