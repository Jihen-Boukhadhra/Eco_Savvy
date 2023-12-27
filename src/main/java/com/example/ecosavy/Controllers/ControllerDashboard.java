package com.example.ecosavy.Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ControllerDashboard {
    @FXML
    private Pane VBPane;

    // Add this method to set the VBPane reference
    public void setVBPane(Pane VBPane) {
        this.VBPane = VBPane;
    }
}
