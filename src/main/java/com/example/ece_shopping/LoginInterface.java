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
import javafx.stage.Stage;


public class LoginInterface extends Application {
    private String utilisateur;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création des éléments de l'interface
        Label label_username = new Label("Nom d'utilisateur:");
        TextField field_username = new TextField();
        Label label_password = new Label("Mot de passe:");
        PasswordField field_password = new PasswordField();
        Button button_login = new Button("Se connecter");
        Button button_signup = new Button("Créer un compte");

        // Ajout d'un gestionnaire de clic pour le bouton de connexion
        button_login.setOnAction(event -> {
            String username = field_username.getText();
            utilisateur = username;
            String password = field_password.getText();

            if (UserSQL.authentifierUtilisateur(username, password)) {
                System.out.println("Vous êtes connecté !");

                System.out.println(utilisateur);
                if(UserSQL.isAdmin(utilisateur)) {
                    AdminInterface adminInterface = new AdminInterface();
                    try {
                        adminInterface.start(new Stage());
                        primaryStage.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                 else {
                    ClientInterface clientInterface = new ClientInterface();
                    try {
                        clientInterface.start(new Stage());
                        primaryStage.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
            }
        });

        // Ajout d'un gestionnaire de clic pour le bouton de création de compte
        button_signup.setOnAction(event -> {
            CreateAccountInterface createAccountInterface = new CreateAccountInterface();
            try {
                createAccountInterface.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //System.out.println("Créer un compte");
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

        // Ajout d'un conteneur HBox pour les boutons de connexion et de création de compte
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(button_login, button_signup);
        grid.add(hbBtn, 1, 2);

        // Ajout de la grille au conteneur racine BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(grid);

        // Création de la scène
        Scene scene = new Scene(root, 600, 400);

        // Configuration de la fenêtre principale
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
