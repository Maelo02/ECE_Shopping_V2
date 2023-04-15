package Controller;
import java.util.HashMap;

import View.LoginInterface;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> users = UserSQL.getUsers();

        // Affichage des utilisateurs
        for (String username : users.keySet()) {
            String password = users.get(username);
            System.out.println("Nom d'utilisateur : " + username + ", Mot de passe : " + password);
        }

        Application.launch(LoginInterface.class, args);
    }
}