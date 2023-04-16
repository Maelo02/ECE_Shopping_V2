package View;

import Controller.Main;
import Model.Article;
import Model.Panier;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.Random;

import java.util.ArrayList;

public class Interfacecommande extends Application {


    public void start(Stage primaryStage){

    }

    public static void commande( Panier panier) {

                ArrayList<Article> panierArticle = panier.getPanierArticle();

                Stage newStage = new Stage();

                Button button = new Button("Retour");
                Button button_achat = new Button("Commander et payer");

                button.setOnAction(e -> newStage.close());

                Label label = new Label("Commande :");
                Label Ncommande = new Label("N° de commande : ");
                Label Narticle = new Label("Nombre d'article : ");
                Label label_adresse = new Label("Adresse :");
                Label label_ville = new Label("Ville :");
                TextField field_adresse = new TextField();
                TextField field_ville = new TextField();

                ImageView logo = new ImageView("file:ressource/logo.png");
                logo.setFitWidth(280);
                logo.setFitHeight(200);


                HBox hbLogo = new HBox(10);
                hbLogo.setAlignment(Pos.CENTER);
                hbLogo.setMargin(logo, new Insets(-350, 0, 0, 0));
                hbLogo.getChildren().addAll(logo);

                Random random = new Random();
                int NumCommande = random.nextInt(8999) + 1000;

                Label label_prixTotalPanier = new Label("Prix total de la commande : ");
                double prixTotalCommande = 0;


                GridPane grid = new GridPane();
                grid.setAlignment(Pos.CENTER);
                grid.add(label, 0, 0);
                grid.setStyle("-fx-font-size: 16px;");


                grid.add(hbLogo, 0, 0, 2, 1);
                for (Article article : panierArticle) {
                    prixTotalCommande += article.calculPrix();
                }

                label_prixTotalPanier.setText(label_prixTotalPanier.getText() + (prixTotalCommande)+ "");
                Ncommande.setText(Ncommande.getText() + (NumCommande)+ "");
                Narticle.setText(Narticle.getText() + (panierArticle.size())+ "");
                grid.add(Ncommande, 0, 1);
                grid.add(label_prixTotalPanier, 0, 2);
                grid.add(Narticle, 0, 3);
                grid.add(label_adresse, 0, 4);
                grid.add(field_adresse, 1, 4);
                grid.add(label_ville, 0, 5);
                grid.add(field_ville, 1, 5);
                grid.add(button, 0, panierArticle.size() + 6);
                grid.add(button_achat, 1, panierArticle.size() + 6);

                StackPane root = new StackPane();
                root.getChildren().add(grid);

                Screen screen = Screen.getPrimary();
                Rectangle2D bounds = screen.getVisualBounds();
                Scene newScene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

                newStage.setTitle("Commande");
                newStage.setScene(newScene);
                newStage.show();
            }
        }
