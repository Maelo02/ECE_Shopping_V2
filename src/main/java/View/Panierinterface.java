package View;

import Model.Article;
import Model.Panier;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

import java.util.ArrayList;

public class Panierinterface extends Application {
    public void start(Stage primaryStage) {

    }

    public static void panierAfficher(Panier panier) {

        ArrayList<Article> panierArticle = panier.getPanierArticle();

        for(Article article : panierArticle) {
            System.out.println(article.getNom());
        }

        //initaliser les quantités de chaque article à 1

        for(int i = 0; i<panierArticle.size(); i++) {
            for(int j = 0;j<panierArticle.size();j++) {
                if(panierArticle.get(i).getId() == panierArticle.get(j).getId() && i != j) {
                    panierArticle.get(i).setArticlePanier(panierArticle.get(i).getArticlePanier() + 1);
                    panierArticle.remove(j);
                }
            }
        }

        Stage newStage = new Stage();

        Button button = new Button("Retour");
        Button button_achat = new Button("Commander et payer");

        button.setOnAction(e -> newStage.close());

        Label label = new Label("Voici votre panier :");
        Label label_article = new Label("Article");
        Label label_prix = new Label("Prix");
        Label label_quantite = new Label("Quantité    ");
        Label label_prixBulk = new Label("Prix en gros     ");
        Label label_prixTotal = new Label("Prix total");
        Label label_prixTotalPanier = new Label("Prix total du panier : ");

        Label labelEspace1 = new Label(" ");
        Label labelEspace2 = new Label(" ");
        Label labelEspace3 = new Label(" ");
        Label labelEspace4 = new Label(" ");

        double prixTotalPanier = 0;

        Label[] label_articleNom = new Label[panierArticle.size()];
        Label[] label_prixArticle = new Label[panierArticle.size()];
        Label[] label_quantiteArticle = new Label[panierArticle.size()];
        Label[] label_prixBulkArticle = new Label[panierArticle.size()];
        Label[] label_prixTotalArticle = new Label[panierArticle.size()];

        for(int i = 0; i < panierArticle.size(); i++) {
            label_articleNom[i] = new Label(panierArticle.get(i).getNom());
            label_prixArticle[i] = new Label((panierArticle.get(i).getPrix())+"€");
            label_quantiteArticle[i] = new Label(String.valueOf(panierArticle.get(i).getArticlePanier()));
            label_prixBulkArticle[i] = new Label((panierArticle.get(i).getPrixBulk())+"€ si qte > "+panierArticle.get(i).getQuantiteBulk()+"               ");
            label_prixTotalArticle[i] = new Label((panierArticle.get(i).calculPrix())+"€");
        }

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.add(label, 0, 0);
        grid.add(labelEspace2, 0, 1);
        grid.add(label_article, 0, 2);
        grid.add(label_prix, 1, 2);
        grid.add(label_quantite, 2, 2);
        grid.add(label_prixBulk, 3, 2);
        grid.add(label_prixTotal, 4, 2);
        grid.add(labelEspace1, 0, 3);

        for(int i = 0; i < panierArticle.size(); i++) {
            grid.add(label_articleNom[i], 0, i + 4);
            grid.add(label_prixArticle[i], 1, i + 4);
            grid.add(label_quantiteArticle[i], 2, i + 4);
            grid.add(label_prixBulkArticle[i], 3, i + 4);
            grid.add(label_prixTotalArticle[i], 4, i +4);
        }

        for (Article article : panierArticle) {
            prixTotalPanier += article.calculPrix();
        }

        label_prixTotalPanier.setText(label_prixTotalPanier.getText() + (prixTotalPanier)+ "€");
        grid.add(labelEspace3, 0, panierArticle.size() + 4);
        grid.add(label_prixTotalPanier, 0, panierArticle.size() + 5);
        grid.add(labelEspace4, 0, panierArticle.size() + 6);
        grid.add(button, 0, panierArticle.size() + 7);
        grid.add(button_achat, 1, panierArticle.size() + 7);

        StackPane root = new StackPane();
        root.getChildren().add(grid);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene newScene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        newStage.setTitle("Panier");
        newStage.setScene(newScene);
        newStage.show();
    }
}
