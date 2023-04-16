package View;

import Controller.UserSQL;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import java.util.HashMap;
import javafx.scene.control.Button;

public class ListeCompteInterface extends Application {

    public void start(Stage primaryStage) {
    }

    /**
     * Fonction d'affichage de la page de liste des comptes
     */
    public static void afficherListeDesComptes()
    {
        HashMap<String, String> users = UserSQL.getUsers();
        Stage newStage = new Stage();

        Button button_retour = new Button("Retour");

        // Affichage des utilisateurs
        for (String username : users.keySet()) {
            String password = users.get(username);
            System.out.println("Nom d'utilisateur : " + username + ", Mot de passe : " + password);
        }

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        Label label_username = new Label("Nom d'utilisateur:");
        Label label_password = new Label("Mot de passe:");
        label_username.setFont(new Font("Arial", 18));
        label_password.setFont(new Font("Arial", 18));


        grid.add(label_username, 0, 0);
        grid.add(label_password, 1, 0);

        Label label_espace = new Label(" ");
        Label label_espace2 = new Label(" ");
        grid.add(label_espace, 0, 1);
        grid.add(label_espace2, 1, 1);

        int i = 2;
        for (String username : users.keySet()) {
            String password = users.get(username);
            Label label_username2 = new Label(username);
            Label label_password2 = new Label(password);
            grid.add(label_username2, 0, i);
            grid.add(label_password2, 1, i);
            i++;
        }

        grid.add(button_retour, 0, i);
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
