package View;

import Controller.SQL;
import Model.ListeCommande;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MonCompteclient {

    public void start(Stage primaryStage) {
    }
    public static void infoclient(String nom,String mdp) {

        ListeCommande commande1 = new ListeCommande(SQL.remplirCommande());

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        // création des labels pour les entêtes
        Label _nom = new Label(nom);
        Label _mdp = new Label(mdp);
        Label label_username = new Label("Nom d'utilisateur :");
        Label label_password = new Label("Mot de passe :");
        Label labelNumCommande = new Label("Numéro de commande");
        Label labelDateCommande = new Label("Date");
        Label labelClient = new Label("Client");
        Label labelNbProduits = new Label("Nombre de produits");
        Label labelTotal = new Label("Total");
        Label labelAdresse = new Label("Adresse");
        Label labelVille = new Label("Ville");

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        grid.add(hbox, 0, 0, 2, 1);

        // ajout des entêtes à la grille
        grid.add(label_username, 0, 1);
        grid.add(_nom, 1, 1);
        grid.add(_mdp, 1, 2);
        grid.add(label_password, 0, 2);

        // création des labels pour les informations de chaque commande et ajout à la grille
        int j=0;
        for (int i = 0; i < commande1.getListeCommande().size(); i++) {
            if(commande1.getListeCommande().get(i).getUtilisateur().equals(nom)) {
                if(j==0){
                    grid.add(labelNumCommande, 0, 4);
                    grid.add(labelDateCommande, 1, 4);
                    grid.add(labelClient, 2, 4);
                    grid.add(labelNbProduits, 3, 4);
                    grid.add(labelTotal, 4, 4);
                    grid.add(labelAdresse, 5, 4);
                    grid.add(labelVille, 6, 4);
                }
                Label labelNumCommandeValue = new Label(String.valueOf(commande1.getListeCommande().get(i).getNumero()));
                Label labelDateCommandeValue = new Label(commande1.getListeCommande().get(i).getDate().toString());
                Label labelClientValue = new Label(commande1.getListeCommande().get(i).getUtilisateur());
                Label labelNbProduitsValue = new Label(String.valueOf(commande1.getListeCommande().get(i).getNombre_articles()));
                Label labelTotalValue = new Label(String.valueOf(commande1.getListeCommande().get(i).getPrix_total()));
                Label labelAdresseValue = new Label(String.valueOf(commande1.getListeCommande().get(i).getAdresse()));
                Label labelVilleValue = new Label(String.valueOf(commande1.getListeCommande().get(i).getVille()));

                grid.add(labelNumCommandeValue, 0, j + 6);
                grid.add(labelDateCommandeValue, 1, j + 6);
                grid.add(labelClientValue, 2, j + 6);
                grid.add(labelNbProduitsValue, 3, j + 6);
                grid.add(labelTotalValue, 4, j + 6);
                grid.add(labelAdresseValue, 5, j + 6);
                grid.add(labelVilleValue, 6, j + 6);
                j++;
            }
        }

        // Création d'un label avec le texte "Mon Compte"
        Label Pageadmin = new Label("Mon Compte");
        Pageadmin.setStyle("-fx-font-size: 20px;");
        Pageadmin.translateYProperty().set(-200);

        // Création de l'image du logo
        Image logoImage = new Image("file:ressource/logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitHeight(200);
        logoImageView.setFitWidth(280);

        BorderPane imagelogo = new BorderPane();
        imagelogo.setTop(logoImageView);
        imagelogo.setCenter(Pageadmin);
        BorderPane.setAlignment(logoImageView, Pos.TOP_CENTER);

        // ajout de la grille à un StackPane et création de la scène
        StackPane root = new StackPane();
        root.getChildren().add(imagelogo);
        root.getChildren().add(grid);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene newScene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        Stage newStage = new Stage();
        Button button_retour = new Button("Retour");
        grid.add(button_retour, 0, j+7);
        button_retour.setOnAction(e -> newStage.close());

        newStage.setScene(newScene);
        newStage.show();
    }

}

