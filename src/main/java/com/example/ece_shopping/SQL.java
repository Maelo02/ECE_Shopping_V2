package com.example.ece_shopping;

import java.sql.*;
import java.util.*;

public class SQL {
    public static Connection connect() {
        Connection conn = null;

        try {
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:8889/article";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            System.out.println("Database connection established");

        } catch (Exception e) {

            System.err.println("Cannot connect to database server");
            e.printStackTrace();
        }
        return conn;
    }

    public static ArrayList<Article> remplirStock()
    {
        ArrayList<Article> stockRempli = new ArrayList<Article>();
        Connection conn = connect();

        int i = 1;

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM article";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Article article = new Article(rs.getLong("Id"), rs.getString("Nom"), rs.getDouble("Prix"), rs.getDouble("PrixBulk"), rs.getInt("QuantiteBulk"), rs.getInt("Quantite"));
                stockRempli.add(article);
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println("Error executing query");
            e.printStackTrace();
        }

        return stockRempli;
    }

    public static ArrayList<Commande> remplirCommande()
    {
        Connection conn = null;

        try {
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:8889/commande";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            System.out.println("Database connection established");

        } catch (Exception e) {

            System.err.println("Cannot connect to database server");
            e.printStackTrace();
        }
        ArrayList<Commande> commandeRempli = new ArrayList<Commande>();


        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM commande";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Commande commande = new Commande(rs.getInt("numero_commande"),rs.getDate("date"), rs.getString("utilisateur"), rs.getInt("nombre_articles"), rs.getFloat("prix_total"));
                commandeRempli.add(commande);
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println("Error executing query");
            e.printStackTrace();
        }

        return commandeRempli;
    }


    public static void ajouterArticle(String nomF, double prix, double prixBulk, int quantite, int quantiteBulk, int id)
    {
        Connection conn = connect();
        Scanner sc = new Scanner(System.in);

        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO article (Id, Nom, Prix, PrixBulk, QuantiteBulk, Quantite) VALUES (" + id + ", '" + nomF + "', " + prix + ", " + prixBulk + ", " + quantiteBulk + ", " + quantite + ")";
            stmt.executeUpdate(query);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
