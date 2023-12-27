module com.example.ecosavy {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires com.jfoenix;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.mail;
    opens com.example.ecosavy.Models to javafx.base;
    opens com.example.ecosavy to javafx.fxml;
    exports com.example.ecosavy;
    exports com.example.ecosavy.Controllers;
    opens com.example.ecosavy.Controllers to javafx.fxml;
}