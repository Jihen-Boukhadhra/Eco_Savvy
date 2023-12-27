package com.example.ecosavy.Controllers;

import com.example.ecosavy.Models.Tissu;
import com.example.ecosavy.Models.Verre;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ControllerAddVerre {
    String filepath="E:/Users/tassm/Desktop/TissuDechet.txt";

    @FXML
    private JFXButton ButtonAddChemicalMat;

    @FXML
    private Button ButtonAddTrashFin;

    @FXML
    private TextField ColorField;

    @FXML
    private TextField TransparencyField;

    @FXML
    private ListView<String> chemicalCompositionListView;

    @FXML
    private TextField chemicalMaterialTextField;

    @FXML
    private ComboBox isBiodegradableField;

    @FXML
    private ComboBox isRecyclableField;

    @FXML
    private TextField lifeSpanField;

    @FXML
    private TextField quantityStockField;

    @FXML
    private TextField volumeTextField;

    @FXML
    private TextField wasteIdField;

    @FXML
    private TextField weightField;
    @FXML
    private DatePicker Production_Date;


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
            int transpancey_level=Integer.valueOf(TransparencyField.getText());
            LocalDate local_date_prod =Production_Date.getValue();
            Instant instant = Instant.from(local_date_prod.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            boolean isRecyclable = "TRUE".equals(isRecyclableField.getValue());
            boolean isBiodegradable = "TRUE".equals(isBiodegradableField.getValue());
            String color = ColorField.getText();
            Double lifeSpan = Double.parseDouble(lifeSpanField.getText());
            Double weight = Double.parseDouble(weightField.getText());

            Verre trash = new Verre(color,transpancey_level,date, wasteId, isRecyclable, isBiodegradable, quantityStock, weight, lifeSpan);
            trash.setChemicalComposition(getChemicalCompositions());

            trash.saveToFile(filepath);
            Stage currentStage = (Stage) wasteIdField.getScene().getWindow();
            currentStage.close();

        }catch(Exception e){
            e.getMessage();
        }
    }

}
