package com.example.ece_shopping;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;



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