package com.example.ece_shopping;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InterfaceAjoutArticle extends Application {

    public void start(Stage primaryStage) {
        // Création d'un label avec le texte "Page Admin"
        Label label = new Label("Ajouter un article");
        TextField field_nom = new TextField();
        TextField field_prix = new TextField();
        TextField field_prixBulk = new TextField();
        TextField field_quantiteBulk = new TextField();
        TextField field_quantite = new TextField();
        TextField field_id = new TextField();
        Label label_nom = new Label("Nom :");
        Label label_prix = new Label("Prix :");
        Label label_prixBulk = new Label("Prix Bulk :");
        Label label_quantite = new Label("Quantité :");
        Label label_quantiteBulk = new Label("Quantité Bulk :");
        Label label_id = new Label("Id :");

        Text text = new Text("Ajouter un article");

        Button button = new Button("Ajouter");

        text.setFont(Font.font("Verdana", 20));

        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(hbox, 0, 0, 2, 1);

        grid.add(label_nom, 0, 1);
        grid.add(field_nom, 1, 1);
        grid.add(label_prix, 0, 2);
        grid.add(field_prix, 1, 2);
        grid.add(label_prixBulk, 0, 3);
        grid.add(field_prixBulk, 1, 3);
        grid.add(label_quantite, 0, 4);
        grid.add(field_quantite, 1, 4);
        grid.add(label_quantiteBulk, 0, 5);
        grid.add(field_quantiteBulk, 1, 5);
        grid.add(label_id, 0, 6);
        grid.add(field_id, 1, 6);

        grid.add(button, 1, 7);

        button.setOnAction(event -> {
            String nomF = field_nom.getText();
            double prix = Double.parseDouble(field_prix.getText());
            double prixBulk = Double.parseDouble(field_prixBulk.getText());
            int quantite = Integer.parseInt(field_quantite.getText());
            int quantiteBulk = Integer.parseInt(field_quantiteBulk.getText());
            int id = Integer.parseInt(field_id.getText());

            SQL.ajouterArticle(nomF, prix, prixBulk, quantite, quantiteBulk, id);
        });


        // Créer une mise en page (layout) pour le champ de texte
        StackPane root = new StackPane();
        root.getChildren().add(grid);

        // Créer une scène
        Scene scene = new Scene(root, 400, 300);

        // Définir la scène et l'afficher
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
