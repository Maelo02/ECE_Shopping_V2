package View;

import Controller.Main;
import Model.Article;
import Model.Panier;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ArticleInterface extends Application {

    public void start(Stage primaryStage){

    }

    public static void afficherArticle(Article article,Panier panier)
    {
        //On récupère les informations de l'article
        String nom = article.getNom();
        double prix = article.getPrix();
        double prixBulk = article.getPrixBulk();
        int quantite = article.getQuantite();
        int quantiteBulk = article.getQuantiteBulk();
        ImageView imageView = null;

        Image image = new Image("file:ressource/article_" + article.getId() + ".png");
        imageView = new ImageView(image);

        if(imageView.getImage().isError())
        {
            Image image2 = new Image("file:ressource/Placeholder.png");
            imageView = new ImageView(image2);
        }

        //On crée une nouvelle fenêtre
        Stage newStage = new Stage();

        //On crée un bouton de retour et on ajoute son fonctionnemnt
        Button retourButton = new Button("Retour");
        retourButton.setOnAction(e -> newStage.close());

        Button plusUn = new Button("+1");

        plusUn.setOnAction(e -> {
            System.out.println("Ajout de l'article " + article.getNom() + " au panier");
            panier.ajouterArticle(article);
        });

        Button moinsUn = new Button("-1");

        moinsUn.setOnAction(e -> {
            System.out.println("Retrait de l'article " + article.getNom() + " du panier");
            if(panier.getPanierArticle().contains(article)&&article.getArticlePanier()>1)
            {
                article.setArticlePanier(article.getArticlePanier()-1);
            }
            else
            {
                panier.suppArticle(article);
            }
        });

        //On crée les labels et les textes
        Label label_nom = new Label("Nom de l'article :");
        Label label_prix = new Label("Prix unitaire :");
        Label label_prixBulk = new Label("Prix en gros :");
        Label label_quantite = new Label("Stock:");
        Label label_quantiteBulk = new Label("Quantité pour remise :");

        Text text = new Text("Présentation de l'article");
        text.setFont(Font.font("Verdana", 20));

        Text textNom = new Text(nom);
        Text textPrix = new Text(Double.toString(prix));
        Text textPrixBulk = new Text(Double.toString(prixBulk));
        Text textQuantiteBulk = new Text(Integer.toString(quantiteBulk));
        Text textQuantite = new Text(Integer.toString(quantite));

        //On crée la grille
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //On ajoute les éléments à la grille
        grid.add(hbox, 0, 0, 2, 1);
        grid.add(imageView, 0, 1, 2, 1);

        grid.add(label_nom, 0, 2);
        grid.add(textNom, 1, 2);
        grid.add(label_prix, 0, 3);
        grid.add(textPrix, 1, 3);
        grid.add(label_prixBulk, 0, 4);
        grid.add(textPrixBulk, 1, 4);
        grid.add(label_quantite, 0, 5);
        grid.add(textQuantite, 1, 5);
        grid.add(label_quantiteBulk, 0, 6);
        grid.add(textQuantiteBulk, 1, 6);
        grid.add(plusUn, 0, 7);
        grid.add(moinsUn, 1, 7);
        grid.add(retourButton, 0, 8);

        StackPane root = new StackPane(grid);

        Scene newScene = new Scene(root, 400, 600);

        newStage.setScene(newScene);
        newStage.show();

    }
}
