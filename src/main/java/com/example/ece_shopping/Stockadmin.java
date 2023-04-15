package com.example.ece_shopping;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane;

public class Stockadmin extends Application {

    public void start(Stage primaryStage) {

    }

    public static void voirstock() {
        // Création d'un label avec le texte "Page Client"
        Label label = new Label("Page Client");

        Stock stock1 = new Stock(SQL.remplirStock());

        Label nameLabel211 = new Label("");
        Label nameLabel212 = new Label("");
        Label nameLabel213 = new Label("");

        Stage newStage = new Stage();

        VBox cell21 = new VBox();

        Button[] plusbutton = new Button[stock1.getStockArticle().size()];
        Button[] moinsbutton = new Button[stock1.getStockArticle().size()];

        ImageView[] imageViews = new ImageView[stock1.getStockArticle().size()];
        Label[] nameLabels = new Label[stock1.getStockArticle().size()];
        Label QTStock = new Label("Quantité en Stock : ");
        VBox[] cells = new VBox[stock1.getStockArticle().size()];


        // Création de l'image du logo
        Image logoImage = new Image("file:ressource/logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitHeight(100);
        logoImageView.setFitWidth(140);

        // Création de la barre de recherche

        TextField searchField = new TextField();
        searchField.setPromptText("Rechercher...");
        searchField.setPrefWidth(800);
        searchField.setCenterShape(true);
        searchField.setTranslateY(35);

        // Création du bouton "Panier"
        Button button_retour = new Button("Retour");
        button_retour.setTranslateY(35);

        button_retour.setOnAction(e -> newStage.close());

        HBox topBox = new HBox();
        topBox.setPadding(new Insets(10));
        topBox.setSpacing(10);
        topBox.getChildren().addAll(logoImageView, searchField, button_retour);

        // Création d'un conteneur de type BorderPane pour organiser la mise en page
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(label);

        // Récupération de la taille de l'écran
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Création de la scène avec une taille proportionnelle à celle de l'écran
        Scene scene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        newStage.setScene(scene);
        newStage.show();

        GridPane gridPane = new GridPane();

        for (int i = 0; i < stock1.getStockArticle().size(); i++) {
            Image image = new Image("file:ressource/article_" + stock1.getStockArticle().get(i).getId() + ".png");
            imageViews[i] = new ImageView(image);

            if (imageViews[i].getImage().isError()) {
                Image image2 = new Image("file:ressource/Placeholder.png");
                imageViews[i] = new ImageView(image2);
            }

            nameLabels[i] = new Label(stock1.getStockArticle().get(i).getNom());
            QTStock = new Label("Quantité en Stock : " + stock1.getStockArticle().get(i).getQuantite());
            plusbutton[i] = new Button(" +1 ");
            moinsbutton[i] = new Button(" -1 ");

            cells[i] = new VBox();
            cells[i].getChildren().addAll(imageViews[i], nameLabels[i], QTStock, plusbutton[i], moinsbutton[i]);
            cells[i].setAlignment(Pos.CENTER);

            int finalI = i;

            plusbutton[i].setOnAction(event -> {
                SQL.ajoutQuantite(stock1.getStockArticle().get(finalI).getId());
                voirstock();
                newStage.close();
            });

            moinsbutton[i].setOnAction(event -> {
                SQL.retirQuantite(stock1.getStockArticle().get(finalI).getId());
                voirstock();
                newStage.close();
            });
        }

        cell21.getChildren().addAll(nameLabel211, nameLabel212, nameLabel213);

        gridPane.setHgap(10);
        gridPane.setVgap(30);
        gridPane.setTranslateX(90);

        for (int j = 0; j < stock1.getStockArticle().size(); j++) {
            int column = j % 4;
            int row = j / 4;
            gridPane.add(cells[j], column, row);
        }

        gridPane.add(cell21, 0, 5, 4, 1);

        ScrollPane scrollPane = new ScrollPane(gridPane);
        root.setCenter(scrollPane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Toujours afficher la barre de défilement verticale
        root.setCenter(scrollPane);
    }
}


