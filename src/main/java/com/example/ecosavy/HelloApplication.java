package com.example.ecosavy;

import com.example.ecosavy.Models.BoiteCommnts;
import com.example.ecosavy.Models.Commentaire;
import com.example.ecosavy.Models.SComment;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collections;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Welcome!");
        stage.setScene(scene);
        scene.getWindow().centerOnScreen();

        stage.show();
    }


    public static void main(String[] args) {
        BoiteCommnts B=new BoiteCommnts();
        B.ajouter(new SComment("01","Feedback1"," Jihen", "Cette app est magnifique.",2));
        B.ajouter(new SComment("02","Feedback2"," tasnim", "belle app",5));
        B.ajouter(new SComment("03","Feedback3"," ali", "UI Mangnifique",1));
        B.ajouter(new SComment("04","Feedback4"," Jihen", "Utile",4));

        // Tri par nbrEtoiles croissant
        Collections.sort(B.getCommnts(), (c1, c2)-> (int) (c1.nbEtoiles()-c2.nbEtoiles()));
        System.out.println("Comments par Taille croissante");
        B.getCommnts().stream().forEach((comment) ->      System.out.println(comment.libelle() + " NbEtoiles: " + comment.nbEtoiles()));
        launch();


    }
}