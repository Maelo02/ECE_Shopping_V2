package com.example.ece_shopping;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;

public class ListeCompteInterface extends Application {

    public void start(Stage primaryStage) {
    }

    public void afficherListeDesComptes()
    {
        HashMap<String, String> users = UserSQL.getUsers();

        // Affichage des utilisateurs
        for (String username : users.keySet()) {
            String password = users.get(username);
            System.out.println("Nom d'utilisateur : " + username + ", Mot de passe : " + password);
        }


    }
}
