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



public class ClientInterface extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'un label avec le texte "Page Client"
        Label label = new Label("Page Client");

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




        // Création du bouton "Mon compte"
        Button monCompteButton = new Button("Mon compte");
        monCompteButton.setTranslateY(35);

        // Création du bouton "Panier"
        Button cartButton = new Button("Panier");
        cartButton.setTranslateY(35);

        HBox topBox = new HBox();
        topBox.setPadding(new Insets(10));
        topBox.setSpacing(10);
        topBox.getChildren().addAll(logoImageView, searchField, monCompteButton, cartButton);

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
        Scene scene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Page Clients");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Création des images
        Image image1 = new Image("file:ressource/article_1.png");
        Image image2 = new Image("file:ressource/article_2.png");
        Image image3 = new Image("file:ressource/article_3.png");
        Image image4 = new Image("file:ressource/article_4.png");
        Image image5 = new Image("file:ressource/article_5.png");
        Image image6 = new Image("file:ressource/article_6.png");
        Image image7 = new Image("file:ressource/article_7.png");
        Image image8 = new Image("file:ressource/article_8.png");
        Image image9 = new Image("file:ressource/article_9.png");
        Image image10 = new Image("file:ressource/article_10.png");
        Image image11 = new Image("file:ressource/article_11.png");
        Image image12 = new Image("file:ressource/article_12.png");
        Image image13 = new Image("file:ressource/article_13.png");
        Image image14 = new Image("file:ressource/article_14.png");
        Image image15 = new Image("file:ressource/article_15.png");
        Image image16 = new Image("file:ressource/article_16.png");
        Image image17 = new Image("file:ressource/article_17.png");
        Image image18 = new Image("file:ressource/article_18.png");
        Image image19 = new Image("file:ressource/article_19.png");
        Image image20 = new Image("file:ressource/article_20.png");


// Création des ImageView pour les images
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);
        ImageView imageView5 = new ImageView(image5);
        ImageView imageView6 = new ImageView(image6);
        ImageView imageView7 = new ImageView(image7);
        ImageView imageView8 = new ImageView(image8);
        ImageView imageView9 = new ImageView(image9);
        ImageView imageView10 = new ImageView(image10);
        ImageView imageView11 = new ImageView(image11);
        ImageView imageView12 = new ImageView(image12);
        ImageView imageView13 = new ImageView(image13);
        ImageView imageView14 = new ImageView(image14);
        ImageView imageView15 = new ImageView(image15);
        ImageView imageView16 = new ImageView(image16);
        ImageView imageView17 = new ImageView(image17);
        ImageView imageView18 = new ImageView(image18);
        ImageView imageView19 = new ImageView(image19);
        ImageView imageView20 = new ImageView(image20);



// Création des Labels pour les noms
        Label nameLabel1 = new Label("Telephone");
        Label nameLabel2 = new Label("Telephone 2");
        Label nameLabel3 = new Label("Telephone 3");
        Label nameLabel4 = new Label("Telephone 4");
        Label nameLabel5 = new Label("Telephone 5");
        Label nameLabel6 = new Label("Telephone 6");
        Label nameLabel7 = new Label("Telephone 7");
        Label nameLabel8 = new Label("Telephone 8");
        Label nameLabel9 = new Label("Telephone 9");
        Label nameLabel10 = new Label("Telephone 10");
        Label nameLabel11 = new Label("Telephone 11");
        Label nameLabel12 = new Label("Telephone 12");
        Label nameLabel13 = new Label("Telephone 13");
        Label nameLabel14 = new Label("Telephone 14");
        Label nameLabel15 = new Label("Telephone 15");
        Label nameLabel16 = new Label("Telephone 16");
        Label nameLabel17 = new Label("Telephone 17");
        Label nameLabel18 = new Label("Telephone 18");
        Label nameLabel19 = new Label("Telephone 19");
        Label nameLabel20 = new Label("Telephone 20");

        Label nameLabel211 = new Label("");
        Label nameLabel212 = new Label("");
        Label nameLabel213 = new Label("");

// Création des Buttons pour les boutons "ajouter au panier"
        Button cartButton1 = new Button("Ajouter au panier");
        Button cartButton2 = new Button("Ajouter au panier");
        Button cartButton3 = new Button("Ajouter au panier");
        Button cartButton4 = new Button("Ajouter au panier");
        Button cartButton5 = new Button("Ajouter au panier");
        Button cartButton6 = new Button("Ajouter au panier");
        Button cartButton7 = new Button("Ajouter au panier");
        Button cartButton8 = new Button("Ajouter au panier");
        Button cartButton9 = new Button("Ajouter au panier");
        Button cartButton10 = new Button("Ajouter au panier");
        Button cartButton11 = new Button("Ajouter au panier");
        Button cartButton12 = new Button("Ajouter au panier");
        Button cartButton13 = new Button("Ajouter au panier");
        Button cartButton14 = new Button("Ajouter au panier");
        Button cartButton15 = new Button("Ajouter au panier");
        Button cartButton16 = new Button("Ajouter au panier");
        Button cartButton17 = new Button("Ajouter au panier");
        Button cartButton18 = new Button("Ajouter au panier");
        Button cartButton19 = new Button("Ajouter au panier");
        Button cartButton20 = new Button("Ajouter au panier");


// Création des conteneurs HBox pour chaque ligne
        VBox cell1 = new VBox();
        VBox cell2 = new VBox();
        VBox cell3 = new VBox();
        VBox cell4 = new VBox();
        VBox cell5 = new VBox();
        VBox cell6 = new VBox();
        VBox cell7 = new VBox();
        VBox cell8 = new VBox();
        VBox cell9 = new VBox();
        VBox cell10 = new VBox();
        VBox cell11 = new VBox();
        VBox cell12 = new VBox();
        VBox cell13 = new VBox();
        VBox cell14 = new VBox();
        VBox cell15 = new VBox();
        VBox cell16 = new VBox();
        VBox cell17 = new VBox();
        VBox cell18 = new VBox();
        VBox cell19 = new VBox();
        VBox cell20 = new VBox();
        VBox cell21 = new VBox();


// Ajout des ImageView, Labels et Buttons aux HBox
        cell1.getChildren().addAll(imageView1, nameLabel1, cartButton1);
        cell2.getChildren().addAll(imageView2, nameLabel2, cartButton2);
        cell3.getChildren().addAll(imageView3, nameLabel3, cartButton3);
        cell4.getChildren().addAll(imageView4, nameLabel4, cartButton4);
        cell5.getChildren().addAll(imageView5, nameLabel5, cartButton5);
        cell6.getChildren().addAll(imageView6, nameLabel6, cartButton6);
        cell7.getChildren().addAll(imageView7, nameLabel7, cartButton7);
        cell8.getChildren().addAll(imageView8, nameLabel8, cartButton8);
        cell9.getChildren().addAll(imageView9, nameLabel9, cartButton9);
        cell10.getChildren().addAll(imageView10, nameLabel10, cartButton10);
        cell11.getChildren().addAll(imageView11, nameLabel11, cartButton11);
        cell12.getChildren().addAll(imageView12, nameLabel12, cartButton12);
        cell13.getChildren().addAll(imageView13, nameLabel13, cartButton13);
        cell14.getChildren().addAll(imageView14, nameLabel14, cartButton14);
        cell15.getChildren().addAll(imageView15, nameLabel15, cartButton15);
        cell16.getChildren().addAll(imageView16, nameLabel16, cartButton16);
        cell17.getChildren().addAll(imageView17, nameLabel17, cartButton17);
        cell18.getChildren().addAll(imageView18, nameLabel18, cartButton18);
        cell19.getChildren().addAll(imageView19, nameLabel19, cartButton19);
        cell20.getChildren().addAll(imageView20, nameLabel20, cartButton20);
        cell21.getChildren().addAll(nameLabel211, nameLabel212, nameLabel213);

        cell1.setAlignment(Pos.CENTER);
        cell2.setAlignment(Pos.CENTER);
        cell3.setAlignment(Pos.CENTER);
        cell4.setAlignment(Pos.CENTER);
        cell5.setAlignment(Pos.CENTER);
        cell6.setAlignment(Pos.CENTER);
        cell7.setAlignment(Pos.CENTER);
        cell8.setAlignment(Pos.CENTER);
        cell9.setAlignment(Pos.CENTER);
        cell10.setAlignment(Pos.CENTER);
        cell11.setAlignment(Pos.CENTER);
        cell12.setAlignment(Pos.CENTER);
        cell13.setAlignment(Pos.CENTER);
        cell14.setAlignment(Pos.CENTER);
        cell15.setAlignment(Pos.CENTER);
        cell16.setAlignment(Pos.CENTER);
        cell17.setAlignment(Pos.CENTER);
        cell18.setAlignment(Pos.CENTER);
        cell19.setAlignment(Pos.CENTER);
        cell20.setAlignment(Pos.CENTER);
        cell21.setAlignment(Pos.CENTER);


// Création du conteneur GridPane pour organiser les lignes et colonnes
        GridPane gridPane = new GridPane();
        //gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(30);
        gridPane.setTranslateY(30);
// Ajout des HBox au GridPane
        gridPane.add(cell1, 0, 0);
        gridPane.add(cell2, 1, 0);
        gridPane.add(cell3, 2, 0);
        gridPane.add(cell4, 3, 0);
        gridPane.add(cell5, 0, 1);
        gridPane.add(cell6, 1, 1);
        gridPane.add(cell7, 2, 1);
        gridPane.add(cell8, 3, 1);
        gridPane.add(cell9, 0, 2);
        gridPane.add(cell10, 1, 2);
        gridPane.add(cell11, 2, 2);
        gridPane.add(cell12, 3, 2);
        gridPane.add(cell13, 0, 3);
        gridPane.add(cell14, 1, 3);
        gridPane.add(cell15, 2, 3);
        gridPane.add(cell16, 3, 3);
        gridPane.add(cell17, 0, 4);
        gridPane.add(cell18, 1, 4);
        gridPane.add(cell19, 2, 4);
        gridPane.add(cell20, 3, 4);
        gridPane.add(cell21, 0, 5, 4, 1);



       ScrollPane scrollPane = new ScrollPane(gridPane);
        root.setCenter(scrollPane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Toujours afficher la barre de défilement verticale
        root.setCenter(scrollPane);


    }
}



