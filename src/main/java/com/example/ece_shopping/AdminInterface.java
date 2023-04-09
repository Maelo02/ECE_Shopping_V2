package com.example.ece_shopping;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AdminInterface extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'un label avec le texte "Page Admin"
        Label label = new Label("Page Admin");

        // Création d'un conteneur de type StackPane pour afficher le label au centre de la fenêtre
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // Création de la scène
        Scene scene = new Scene(root, 600, 400);

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Page Admin");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
