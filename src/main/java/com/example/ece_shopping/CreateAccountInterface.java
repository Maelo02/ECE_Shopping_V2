package com.example.ece_shopping;

import javafx.application.Application;
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
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CreateAccountInterface extends Application {
    private String username;
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Création des éléments de l'interface
        Label label_username = new Label("Nom d'utilisateur:");
        TextField field_username = new TextField();
        Label label_password = new Label("Mot de passe:");
        PasswordField field_password = new PasswordField();
        Label label_confirm_password = new Label("Confirmer le mot de passe:");
        PasswordField field_confirm_password = new PasswordField();
        Button button_create_account = new Button("Créer un compte");
        Button button_back = new Button("Retour");
        ImageView logo = new ImageView("file:ressource/logo.png");
        logo.setFitWidth(140);
        logo.setFitHeight(100);

        // Ajout d'un gestionnaire de clic pour le bouton de création de compte
        button_create_account.setOnAction(event -> {
            username = field_username.getText();
            String password = field_password.getText();
            String confirm_password = field_confirm_password.getText();

            if (password.equals(confirm_password)) {
                if (UserSQL.creerUtilisateur(username, password)) {
                    System.out.println("Compte créé avec succès !");
                    //UserSQL.setNomUtilisateur(username);
                    ClientInterface clientInterface = new ClientInterface();
                    try {
                        clientInterface.start(new Stage());
                        primaryStage.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
        // Création d'un conteneur HBox pour le logo et le label de nom d'utilisateur
        HBox hbLogo = new HBox(10);
        hbLogo.setAlignment(Pos.TOP_LEFT);
        hbLogo.getChildren().addAll(logo);

        // Ajout des éléments à la grille
        grid.add(hbLogo, 0, 0, 2, 1);
        grid.add(hbBtn, 1, 3);

        // Ajout des boutons à la HBox
        hbBtn.getChildren().addAll(button_create_account, button_back);

        // Déplacement du logo et du label vers le haut de 50 pixels
        GridPane.setMargin(hbLogo, new Insets(-120, 0, 0, 0));

        // Ajout de la grille au conteneur VBox
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(grid);

        // Ajout de la VBox au conteneur racine BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(vbox);

        // Création de la scène
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran

        // Configuration de la fenêtre principale
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}