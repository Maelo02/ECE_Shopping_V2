package View;

import Controller.SQL;
import Controller.UserSQL;
import Model.ListeCommande;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ListeCommandeInterface extends Application {

    public void start(Stage primaryStage) {
    }

    public static void afficherListeDeCommandes() {

        ListeCommande commande1 = new ListeCommande(SQL.remplirCommande());

        Stage newStage = new Stage();
        newStage.setTitle("Liste de commandes");
        newStage.setResizable(false);

        Button button_retour = new Button("Retour");

        // Affichage des utilisateurs
        for (int i = 0; i < commande1.getListeCommande().size(); i++) {
            System.out.println("Numero de commande : " + commande1.getListeCommande().get(i).getNumero() +
                    ", Date : " + commande1.getListeCommande().get(i).getDate() +
                    ", Client : " + commande1.getListeCommande().get(i).getUtilisateur() +
                    ", Nombre de produits : " + commande1.getListeCommande().get(i).getNombre_articles() +
                    ", Total : " + commande1.getListeCommande().get(i).getPrix_total());
        }

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Label label_numero = new Label("Numero de commande");
        Label label_date = new Label("Date");
        Label label_user = new Label("Client");
        Label label_nombre = new Label("Nombre de produits");
        Label label_total = new Label("Total");

        label_numero.setFont(new Font("Arial", 18));
        label_date.setFont(new Font("Arial", 18));
        label_user.setFont(new Font("Arial", 18));
        label_nombre.setFont(new Font("Arial", 18));
        label_total.setFont(new Font("Arial", 18));

        grid.add(label_numero, 0, 0);
        grid.add(label_date, 1, 0);
        grid.add(label_user, 2, 0);
        grid.add(label_nombre, 3, 0);
        grid.add(label_total, 4, 0);

        Label label_espace = new Label(" ");
        Label label_espace2 = new Label(" ");
        Label label_espace3 = new Label(" ");
        Label label_espace4 = new Label(" ");
        Label label_espace5 = new Label(" ");
        grid.add(label_espace, 0, 1);
        grid.add(label_espace2, 1, 1);
        grid.add(label_espace3, 2, 1);
        grid.add(label_espace4, 3, 1);
        grid.add(label_espace5, 4, 1);

        for (int i = 0; i < commande1.getListeCommande().size(); i++) {

            int numero = commande1.getListeCommande().get(i).getNumero();
            Date date = commande1.getListeCommande().get(i).getDate();
            String user = commande1.getListeCommande().get(i).getUtilisateur();
            int nombre = commande1.getListeCommande().get(i).getNombre_articles();
            float total = commande1.getListeCommande().get(i).getPrix_total();

            Label label_numero2 = new Label(Integer.toString(numero));
            Label label_date2 = new Label(date.toString());
            Label label_user2 = new Label(user);
            Label label_nombre2 = new Label(Integer.toString(nombre));
            Label label_total2 = new Label(Float.toString(total));
            grid.add(label_numero2, 0, i + 2);
            grid.add(label_date2, 1, i + 2);
            grid.add(label_user2, 2, i + 2);
            grid.add(label_nombre2, 3, i + 2);
            grid.add(label_total2, 4, i + 2);
        }

        grid.add(button_retour, 0, commande1.getListeCommande().size() + 2);
        button_retour.setOnAction(e -> {
            newStage.close();
        });

        StackPane root = new StackPane();
        root.getChildren().add(grid);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        newStage.setScene(scene);
        newStage.show();
    }
}