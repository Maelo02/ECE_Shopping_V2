package com.example.ece_shopping;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class ArticleInterface extends Application {

    public void start(Stage primaryStage){

    }

    public static void afficherArticle()
    {
        // Ouvrir la nouvelle page
        Stage newStage = new Stage();

        // Créer la nouvelle page
        Button retourButton = new Button("Retour");
        retourButton.setOnAction(e -> newStage.close()); // fermer la fenêtre lorsque le bouton "Retour" est cliqué
        StackPane root = new StackPane(retourButton);

        Scene newScene = new Scene(root, 400, 600);

        newStage.setScene(newScene);
        newStage.show();

    }
}
