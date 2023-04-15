package com.example.ece_shopping;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class AdminInterface extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Création d'un label avec le texte "Page Admin"
        Label Pageadmin = new Label("Page Admin");
        Pageadmin.setStyle("-fx-font-size: 20px;");
        Pageadmin.translateYProperty().set(-100);

        // Création de l'image du logo
        Image logoImage = new Image("file:ressource/logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitHeight(200);
        logoImageView.setFitWidth(280);

        // Création des boutons "Mon compte", "Stock" , "Commande", "Ajouter un article" et "Compte client"
        Button listeDesComptes = new Button("Liste des comptes");
        Button stockButton = new Button("Stock");
        Button commandeButton = new Button("Commande");
        Button ajouterarticle = new Button("Ajouter un article");
        Button compteclient = new Button("Compte client");

        // Création d'un conteneur de type VBox pour organiser la mise en page des boutons
        VBox buttonBox = new VBox(10, listeDesComptes, stockButton, commandeButton, ajouterarticle,compteclient);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));
        buttonBox.translateYProperty().set(-150);

        // Création d'un conteneur de type BorderPane pour organiser la mise en page
        BorderPane root = new BorderPane();
        root.setTop(logoImageView);
        root.setCenter(Pageadmin);
        root.setBottom(buttonBox);
        BorderPane.setAlignment(logoImageView, Pos.TOP_CENTER);

        listeDesComptes.setOnAction(e -> ListeCompteInterface.afficherListeDesComptes());
        stockButton.setOnAction(e -> Stockadmin.voirstock());
        //commandeButton.setOnAction(e -> Commandeadmin.affichercommande());
        ajouterarticle.setOnAction(e -> InterfaceAjoutArticle.ajouterarticle());

        compteclient.setOnAction(e -> {
            try {
                new ClientInterface("Compte client d'un administrateur","AMMP").start(new Stage());
                primaryStage.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene newScene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Page Clients");
        primaryStage.setScene(newScene);
        primaryStage.show();


    }
}



