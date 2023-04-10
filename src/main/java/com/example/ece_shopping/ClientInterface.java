package com.example.ece_shopping;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.scene.layout.GridPane;


public class ClientInterface extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'un label avec le texte "Page Client"
        Label label = new Label("Page Client");


        // Création de l'image du logo
        Image logoImage = new Image("C:/Users/paule/Desktop/ECE_Shopping_V2/ressources/logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitHeight(25);
        logoImageView.setFitWidth(200);

        // Création de la barre de recherche
        TextField searchField = new TextField();
        searchField.setPromptText("Rechercher...");
        searchField.setPrefWidth(800);

        // Création du bouton "Mon compte"
        Button accountButton = new Button("Mon compte");

        // Création du bouton "Panier"
        Button cartButton = new Button("Panier");

        // Création d'un conteneur de type HBox pour afficher le logo, la barre de recherche, le bouton "Mon compte" et le bouton "Panier" sur la même ligne
        HBox topBox = new HBox();
        topBox.setPadding(new Insets(10));
        topBox.setSpacing(10);
        topBox.getChildren().addAll(logoImageView, searchField, accountButton, cartButton);

        // Création d'un conteneur de type BorderPane pour organiser la mise en page
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(label);

        // Création de la scène
            //Scene scene = new Scene(root, 1600, 900);
        // Récupération de la taille de l'écran
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Création de la scène avec une taille proportionnelle à celle de l'écran
        Scene scene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8);

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Page Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Création des images
        Image image1 = new Image("C:/Users/paule/Desktop/ECE_Shopping_V2/ressources/article_1.png");
        Image image2 = new Image("C:/Users/paule/Desktop/ECE_Shopping_V2/ressources/article_2.png");

// Création des ImageView pour les images
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);

// Création des Labels pour les noms
        Label nameLabel1 = new Label("Telephone");
        Label nameLabel2 = new Label("Telephone 2");

// Création des Buttons pour les boutons "ajouter au panier"
        Button cartButton1 = new Button("Ajouter au panier");
        Button cartButton2 = new Button("Ajouter au panier");

// Création des conteneurs HBox pour chaque ligne
        VBox cell1 = new VBox();
        VBox cell2 = new VBox();

// Ajout des ImageView, Labels et Buttons aux HBox
        cell1.getChildren().addAll(imageView1, nameLabel1, cartButton1);
        cell2.getChildren().addAll(imageView2, nameLabel2, cartButton2);

// Création du conteneur GridPane pour organiser les lignes et colonnes
        GridPane gridPane = new GridPane();

// Ajout des HBox au GridPane
        gridPane.add(cell1, 0, 0);
        gridPane.add(cell2, 1, 0);

// Ajout du GridPane au conteneur BorderPane
        root.setCenter(gridPane);
    }
}



