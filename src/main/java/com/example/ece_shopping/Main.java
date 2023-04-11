package com.example.ece_shopping;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;



public class Main {
    public static void main(String[] args) {

        int i = 1;
        Stock stock1 = new Stock(SQL.remplirStock());


        for(int j = 0; j < 20; j++)
        {
            stock1.afficherStock(j,i);
            i++;
        }

        ListeCommande commande1 = new ListeCommande(SQL.remplirCommande());

        for(int j = 0; j < 20; j++)
        {
            //commande1.afficherCommande(j);
        }

        HashMap<String, String> users = UserSQL.getUsers();

        // Affichage des utilisateurs
        for (String username : users.keySet()) {
            String password = users.get(username);
            System.out.println("Nom d'utilisateur : " + username + ", Mot de passe : " + password);
        }

        Application.launch(LoginInterface.class, args);




    }
}