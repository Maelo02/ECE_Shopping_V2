package com.example.ece_shopping;
import java.util.HashMap;
import java.util.Scanner;
import javafx.application.Application;


public class Main {
    public static void main(String[] args) {

        int i = 1;
        Stock stock1 = new Stock(SQL.remplirStock());

        for(int j = 0; j < 20; j++)
        {
            stock1.afficherStock(j,i);
            i++;
        }

        HashMap<String, String> users = UserSQL.getUsers();

        // Affichage des utilisateurs
        for (String username : users.keySet()) {
            String password = users.get(username);
            System.out.println("Nom d'utilisateur : " + username + ", Mot de passe : " + password);
        }
        Application.launch(LoginInterface.class, args);
        /*
        // Connexion
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre nom d'utilisateur : ");
        String nomUtilisateur = scanner.nextLine();

        System.out.println("Entrez votre mot de passe : ");
        String motDePasse = scanner.nextLine();


        */

    }
}