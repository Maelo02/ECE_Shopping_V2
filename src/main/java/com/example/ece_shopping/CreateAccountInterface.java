package com.example.ece_shopping;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateAccountInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création des éléments de l'interface
        Label label_title = new Label("Création de compte");
        Label label_username = new Label("Nom d'utilisateur:");
        TextField field_username = new TextField();
        Label label_password = new Label("Mot de passe:");
        PasswordField field_password = new PasswordField();
        Label label_confirm_password = new Label("Confirmer le mot de passe:");
        PasswordField field_confirm_password = new PasswordField();
        Button button_create_account = new Button("Créer un compte");
        Button button_back = new Button("Retour");

        // Ajout d'un gestionnaire de clic pour le bouton de création de compte
        button_create_account.setOnAction(event -> {
            String username = field_username.getText();
            String password = field_password.getText();
            String confirm_password = field_confirm_password.getText();

            if (password.equals(confirm_password)) {
                if (UserSQL.creerUtilisateur(username, password)) {
                    System.out.println("Compte créé avec succès !");
                } else {
                    System.out.println("Erreur lors de la création du compte.");
                }
            } else {
                System.out.println("Les mots de passe ne correspondent pas.");
            }
        });

        // Ajout d'un gestionnaire de clic pour le bouton de retour
        button_back.setOnAction(event -> {
            LoginInterface loginInterface = new LoginInterface();
            try {
                loginInterface.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Création d'une grille pour organiser les éléments
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(label_username, 0, 0);
        grid.add(field_username, 1, 0);
        grid.add(label_password, 0, 1);
        grid.add(field_password, 1, 1);
        grid.add(label_confirm_password, 0, 2);
        grid.add(field_confirm_password, 1, 2);

        // Ajout d'un conteneur HBox pour les boutons de création de compte et de retour
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(button_create_account, button_back);
        grid.add(hbBtn, 1, 3);

        // Ajout de la grille au conteneur VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label_title, grid);

        // Ajout de la VBox au conteneur racine BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(vbox);

        // Création de la scène
        Scene scene = new Scene(root, 600, 400);

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Création de compte");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
