package View;

import Controller.UserSQL;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class LoginInterface extends Application {
    private String utilisateur;
    @Override
    /**
     * Fonction de lancement de l'interface de connexion
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception {
        // Création des éléments de l'interface
        Label label_username = new Label("Nom d'utilisateur:");
        TextField field_username = new TextField();
        Label label_password = new Label("Mot de passe:");
        PasswordField field_password = new PasswordField();
        Button button_login = new Button("Se connecter");
        Button button_signup = new Button("Créer un compte");
        ImageView logo = new ImageView("file:ressource/logo.png");
        logo.setFitWidth(280);
        logo.setFitHeight(200);


        // Ajout d'un gestionnaire de clic pour le bouton de connexion
        button_login.setOnAction(event -> {
            String username = field_username.getText();
            utilisateur = username;
            String password = field_password.getText();

            if (UserSQL.authentifierUtilisateur(username, password)) {
                System.out.println("Vous êtes connecté !");
                //UserSQL.setNomUtilisateur(utilisateur);
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
                    ClientInterface clientInterface = new ClientInterface(username, password);
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
        HBox hbLogo = new HBox(10);
        hbLogo.setAlignment(Pos.CENTER);
        hbLogo.setMargin(logo, new Insets(-200, 0, 0, 0));
        hbLogo.getChildren().addAll(logo);



        grid.add(hbLogo, 0, 0, 2, 1);

        // Ajout du logo et du label du nom d'utilisateur dans un conteneur HBox
        GridPane.setMargin(hbLogo, new Insets(-120, 0, 0, 0));

        grid.add(label_username, 0, 0);
        grid.add(field_username, 1, 0);
        grid.add(label_password, 0, 1);
        grid.add(field_password, 1, 1);

        // Ajout d'un conteneur HBox pour les boutons de connexion et de création de compte
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(button_login, button_signup);
        grid.add(hbBtn, 1, 3);

        // Ajout de la grille au conteneur racine BorderPane
        BorderPane root = new BorderPane();
        root.setCenter(grid);

        // Création de la scène
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        Scene scene = new Scene(root, bounds.getWidth() * 0.8, bounds.getHeight() * 0.8); //80% de la taille de l'écran


        // Configuration de la fenêtre principale
        primaryStage.setTitle("Connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
