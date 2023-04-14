package com.example.ece_shopping;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.HashMap;

public class MonCompte extends Application {


    public void start(Stage primaryStage) {
    }
        public static void affichermoncompte()
        {

            System.out.println(UserSQL.getUsers());
            // Création d'un label avec le texte "Mon Compte"
            Label Pageadmin = new Label("Mon Compte");
            Pageadmin.setStyle("-fx-font-size: 20px;");
            Pageadmin.translateYProperty().set(-170);

            // Création de l'image du logo
            Image logoImage = new Image("file:ressource/logo.png");
            ImageView logoImageView = new ImageView(logoImage);
            logoImageView.setFitHeight(200);
            logoImageView.setFitWidth(280);

            BorderPane imagelogo = new BorderPane();
            imagelogo.setTop(logoImageView);
            imagelogo.setCenter(Pageadmin);
            BorderPane.setAlignment(logoImageView, Pos.TOP_CENTER);

            //String field_user = username;
            //String field_mdp = password;
            Label label_nom = new Label("Nom d'utilisateur :");
            Label label_prix = new Label("Mot De Passe :");

            //On crée la grille
            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);

            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25, 25, 25));


            grid.add(hbox, 0, 0, 2, 1);

            grid.add(label_nom, 0, 1);
            //grid.add(field_user, 1, 1);
            grid.add(label_prix, 0, 2);
            //grid.add(field_mdp, 1, 2);

            Stage newStage = new Stage();

            Button button_retour = new Button("Retour");

            grid.add(button_retour, 0, 3);

            button_retour.setOnAction(e -> newStage.close());

            // Créer une mise en page (layout) pour le champ de texte
            StackPane root = new StackPane();
            root.getChildren().add(imagelogo);
            root.getChildren().add(grid);

            // Créer une scène
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            Scene newScene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran


            newStage.setScene(newScene);
            newStage.show();

        }
    }



