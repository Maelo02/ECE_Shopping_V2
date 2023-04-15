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
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import java.util.Arrays;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;


public class ClientInterface extends Application {

    private String utilisateur;
    private String mdp;

    public ClientInterface(String parametre1, String parametre2) {
        this.utilisateur = parametre1;
        this.mdp = parametre2;
    }
    @Override
    public void start(Stage primaryStage) {

        // Création d'un label avec le texte "Page Client"
        Label label = new Label("Page Client");
        Stock stock1 = new Stock(SQL.remplirStock());

        Label nameLabel211 = new Label("");
        Label nameLabel212 = new Label("");
        Label nameLabel213 = new Label("");

        VBox cell21 = new VBox();

        ImageView[] imageViews = new ImageView[stock1.getStockArticle().size()];
        Label[] nameLabels = new Label[stock1.getStockArticle().size()];
        Button[] cartButtons = new Button[stock1.getStockArticle().size()];
        VBox[] cells = new VBox[stock1.getStockArticle().size()];

        // Création de l'image du logo
        Image logoImage = new Image("file:ressource/logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitHeight(100);
        logoImageView.setFitWidth(140);

        // Création de la barre de recherche

        TextField searchField = new TextField();
        searchField.setPromptText("Rechercher...");
        searchField.setPrefWidth(750);
        searchField.setCenterShape(true);
        searchField.setTranslateY(35);

        // Création du bouton "Mon compte"
        Button monCompteButton = new Button("Mon compte");
        monCompteButton.setTranslateY(35);

        // Création du bouton "Panier"
        Button cartButton = new Button("Panier");
        cartButton.setTranslateY(35);

        // Création du bouton "Admin"
        Button passeradmin = new Button("Admin");
        passeradmin.setTranslateY(35);

        // Création du bouton avec un menu déroulant "Filtrer"
        SplitMenuButton filtreButton = new SplitMenuButton();
        filtreButton.setText("Filtrer");
        MenuItem item1 = new MenuItem("A a Z");
        MenuItem item2 = new MenuItem("Z a A");
        MenuItem item3 = new MenuItem("Prix croissant");
        MenuItem item4 = new MenuItem("Prix decroissant");
        filtreButton.getItems().addAll(item1, item2, item3, item4);
        filtreButton.setTranslateY(35);

        HBox topBox = new HBox();
        topBox.setPadding(new Insets(10));
        topBox.setSpacing(10);
        topBox.getChildren().addAll(logoImageView, searchField, filtreButton, monCompteButton, cartButton, passeradmin);

        // Création d'un conteneur de type BorderPane pour organiser la mise en page
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(label);

        // Récupération de la taille de l'écran
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // Création de la scène avec une taille proportionnelle à celle de l'écran
        Scene scene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Page Clients");
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int i = 0; i <  stock1.getStockArticle().size(); i++)
        {
            Image image = new Image("file:ressource/article_" + stock1.getStockArticle().get(i).getId() + ".png");
            imageViews[i] = new ImageView(image);
            nameLabels[i] = new Label(stock1.getStockArticle().get(i).getNom());
            cartButtons[i] = new Button("Ajouter au panier");

            cells[i] = new VBox();
            cells[i].getChildren().addAll(imageViews[i], nameLabels[i], cartButtons[i]);
            cells[i].setAlignment(Pos.CENTER);
        }


        monCompteButton.setOnAction(e -> MonCompteclient.infoclient(utilisateur,mdp));

        cell21.getChildren().addAll(nameLabel211, nameLabel212, nameLabel213);
        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(30);
        gridPane.setTranslateX(90);

        for (int i = 0; i < stock1.getStockArticle().size(); i++) {
            int column = i % 4;
            int row = i / 4;
            gridPane.add(cells[i], column, row);
        }

        item1.setOnAction(event -> {
            System.out.println("Option 1 sélectionnée");

            gridPane.getChildren().clear();
            for(int i = 0; i < stock1.getStockArticle().size(); i++)
            {
                cells[i].getChildren().clear();
            }

            // Tri des articles par ordre alphabétique
            stock1.getStockArticle().sort(Comparator.comparing(Article::getNom));

            for (int i = 0; i <  stock1.getStockArticle().size(); i++)
            {
                Image image = new Image("file:ressource/article_" + stock1.getStockArticle().get(i).getId() + ".png");
                imageViews[i] = new ImageView(image);
                nameLabels[i] = new Label(stock1.getStockArticle().get(i).getNom());
                cartButtons[i] = new Button("Ajouter au panier");

                cells[i] = new VBox();
                cells[i].getChildren().addAll(imageViews[i], nameLabels[i], cartButtons[i]);
                cells[i].setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < stock1.getStockArticle().size(); i++) {
                int column = i % 4;
                int row = i / 4;
                gridPane.add(cells[i], column, row);
            }

            for (int i = 0; i < cartButtons.length; i++) {
                int j = i;
                cartButtons[i].setOnAction(e -> ArticleInterface.afficherArticle(stock1.getStockArticle().get(j)));
            }
        });

        item2.setOnAction(event -> {
            System.out.println("Option 2 sélectionnée");

            gridPane.getChildren().clear();
            for(int i = 0; i < stock1.getStockArticle().size(); i++)
            {
                cells[i].getChildren().clear();
            }

            // Tri des articles par ordre alphabétique decroissant
            stock1.getStockArticle().sort(Comparator.comparing(Article::getNom).reversed());

            for (int i = 0; i <  stock1.getStockArticle().size(); i++)
            {
                Image image = new Image("file:ressource/article_" + stock1.getStockArticle().get(i).getId() + ".png");
                imageViews[i] = new ImageView(image);
                nameLabels[i] = new Label(stock1.getStockArticle().get(i).getNom());
                cartButtons[i] = new Button("Ajouter au panier");

                cells[i] = new VBox();
                cells[i].getChildren().addAll(imageViews[i], nameLabels[i], cartButtons[i]);
                cells[i].setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < stock1.getStockArticle().size(); i++) {
                int column = i % 4;
                int row = i / 4;
                gridPane.add(cells[i], column, row);
            }

            for (int i = 0; i < cartButtons.length; i++) {
                int j = i;
                cartButtons[i].setOnAction(e -> ArticleInterface.afficherArticle(stock1.getStockArticle().get(j)));
            }
        });

        item3.setOnAction(event -> {
            System.out.println("Option 3 sélectionnée");
            gridPane.getChildren().clear();
            for(int i = 0; i < stock1.getStockArticle().size(); i++)
            {
                cells[i].getChildren().clear();
            }

            // Tri des articles par ordre alphabétique
            stock1.getStockArticle().sort(Comparator.comparing(Article::getPrix));

            for (int i = 0; i <  stock1.getStockArticle().size(); i++)
            {
                Image image = new Image("file:ressource/article_" + stock1.getStockArticle().get(i).getId() + ".png");
                imageViews[i] = new ImageView(image);
                nameLabels[i] = new Label(stock1.getStockArticle().get(i).getNom());
                cartButtons[i] = new Button("Ajouter au panier");

                cells[i] = new VBox();
                cells[i].getChildren().addAll(imageViews[i], nameLabels[i], cartButtons[i]);
                cells[i].setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < stock1.getStockArticle().size(); i++) {
                int column = i % 4;
                int row = i / 4;
                gridPane.add(cells[i], column, row);
            }
            for (int i = 0; i < cartButtons.length; i++) {
                int j = i;
                cartButtons[i].setOnAction(e -> ArticleInterface.afficherArticle(stock1.getStockArticle().get(j)));
            }
        });

        item4.setOnAction(event -> {
            System.out.println("Option 4 sélectionnée");
            gridPane.getChildren().clear();
            for(int i = 0; i < stock1.getStockArticle().size(); i++)
            {
                cells[i].getChildren().clear();
            }

            // Tri des articles par ordre alphabétique decroissant
            stock1.getStockArticle().sort(Comparator.comparing(Article::getPrix).reversed());

            for (int i = 0; i <  stock1.getStockArticle().size(); i++)
            {
                Image image = new Image("file:ressource/article_" + stock1.getStockArticle().get(i).getId() + ".png");
                imageViews[i] = new ImageView(image);
                nameLabels[i] = new Label(stock1.getStockArticle().get(i).getNom());
                cartButtons[i] = new Button("Ajouter au panier");

                cells[i] = new VBox();
                cells[i].getChildren().addAll(imageViews[i], nameLabels[i], cartButtons[i]);
                cells[i].setAlignment(Pos.CENTER);
            }

            for (int i = 0; i < stock1.getStockArticle().size(); i++) {
                int column = i % 4;
                int row = i / 4;
                gridPane.add(cells[i], column, row);
            }

            for (int i = 0; i < cartButtons.length; i++) {
                int j = i;
                cartButtons[i].setOnAction(e -> ArticleInterface.afficherArticle(stock1.getStockArticle().get(j)));
            }
        });

        searchField.setOnAction(event -> {
            String searchText = searchField.getText();
            ArrayList<String> rechercheStock = new ArrayList<>();
            System.out.println("Searching for: " + searchText);
            for (Article article : stock1.getStockArticle()) {
                if (article.getNom().toLowerCase().contains(searchText.toLowerCase())) {
                    System.out.println(article.getNom());
                    rechercheStock.add(article.getNom());
                }
            }
            gridPane.getChildren().clear();
            for(int i = 0; i < gridPane.getChildren().size(); i++)
            {
                cells[i].getChildren().clear();
            }

            int count = 0;
            for (String articleNom : rechercheStock) {
                for (int i = 0; i < stock1.getStockArticle().size(); i++) {
                    if (stock1.getStockArticle().get(i).getNom().equals(articleNom)) {
                        // Créer les nœuds correspondants pour l'article
                        Image image = new Image("file:ressource/article_" + stock1.getStockArticle().get(i).getId() + ".png");
                        imageViews[count] = new ImageView(image);
                        nameLabels[count] = new Label(stock1.getStockArticle().get(i).getNom());
                        cartButtons[count] = new Button("Ajouter au panier");

                        cells[count] = new VBox();
                        cells[count].getChildren().addAll(imageViews[count], nameLabels[count], cartButtons[count]);
                        cells[count].setAlignment(Pos.CENTER);

                        // Ajouter les nœuds au conteneur gridPane
                        int column = count % 4;
                        int row = count / 4;
                        gridPane.add(cells[count], column, row);

                        // Mettre à jour le compteur pour accéder au prochain index de tableau
                        count++;
                    }
                }
            }

            for (int i = 0; i < cartButtons.length; i++) {
                int j = i;
                cartButtons[i].setOnAction(e -> ArticleInterface.afficherArticle(stock1.getStockArticle().get(j)));
            }

        });

        for (int i = 0; i < cartButtons.length; i++) {
            int j = i;
            cartButtons[i].setOnAction(e -> ArticleInterface.afficherArticle(stock1.getStockArticle().get(j)));
        }

        passeradmin.setOnAction(event -> {
            passeradmin Passeradmin = new passeradmin(utilisateur,mdp);
            try {
                Passeradmin.start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ScrollPane scrollPane = new ScrollPane(gridPane);
        root.setCenter(scrollPane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Toujours afficher la barre de défilement verticale
        root.setCenter(scrollPane);
    }
}



