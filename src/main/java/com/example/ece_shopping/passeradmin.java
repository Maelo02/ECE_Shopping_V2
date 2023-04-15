package com.example.ece_shopping;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class passeradmin {

    public void start(Stage primaryStage) {

        Stage newStage = new Stage();
        // Création des éléments de l'interface
        Label label_password = new Label("Mot de passe:");
        PasswordField field_password = new PasswordField();
        Button button_login = new Button("Se connecter");
        Button button_retour = new Button("Retour");

        button_retour.setOnAction(event -> {
            ClientInterface clientInterface = new ClientInterface("Compte client admin", "AMMP");
            try {
                clientInterface.start(new Stage());
                primaryStage.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        ImageView logo = new ImageView("file:ressource/logo.png");
        logo.setFitWidth(140);
        logo.setFitHeight(100);


        // Ajout d'un gestionnaire de clic pour le bouton de connexion
        button_login.setOnAction(event -> {

            String password = field_password.getText();




                if (password.equals("AMMP") || password.equals("admin")) {
                    AdminInterface adminInterface = new AdminInterface();
                    try {
                        adminInterface.start(new Stage());
                        primaryStage.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            else {
                System.out.println("Ce mot de passe ne vous permet pas de passer admin.");
            }
        });


        // Création d'une grille pour organiser les éléments
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        HBox hbLogo = new HBox(10);
        hbLogo.setAlignment(Pos.TOP_CENTER);
        hbLogo.getChildren().addAll(logo);

        grid.add(hbLogo, 0, 0, 2, 1);

        // Ajout du logo et du label du nom d'utilisateur dans un conteneur HBox
        GridPane.setMargin(hbLogo, new Insets(-120, 0, 0, 0));


        grid.add(label_password, 0, 1);
        grid.add(field_password, 1, 1);

        // Ajout d'un conteneur HBox pour les boutons de connexion et de création de compte
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(button_retour);

        hbBtn.getChildren().addAll(button_login);
        grid.add(hbBtn, 1, 3);

        // Ajout de la grille au conteneur racine BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(grid);

        // Création de la scène
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root, 600, 400);


        // Configuration de la fenêtre principale
        primaryStage.setTitle("Passer admin : ");
        primaryStage.setScene(scene);
        primaryStage.show();


    // test pole

    }
}
