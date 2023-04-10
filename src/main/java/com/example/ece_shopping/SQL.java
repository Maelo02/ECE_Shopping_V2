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

    public static void ajouterArticle()
    {
        Connection conn = connect();
        Scanner sc = new Scanner(System.in);

        String nom;
        double prix;
        double prixBulk;
        int quantiteBulk;
        int quantite;
        int id;

        System.out.println("Nom de l'article : ");
        nom = sc.nextLine();
        System.out.println("Prix de l'article : ");
        prix = sc.nextDouble();
        System.out.println("Prix en gros de l'article : ");
        prixBulk = sc.nextDouble();
        System.out.println("Quantité de gros de l'article : ");
        quantiteBulk = sc.nextInt();
        System.out.println("Quantité de l'article : ");
        quantite = sc.nextInt();
        System.out.println("Id de l'article : ");
        id = sc.nextInt();

        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO article (Id, Nom, Prix, PrixBulk, QuantiteBulk, Quantite) VALUES (" + id + ", '" + nom + "', " + prix + ", " + prixBulk + ", " + quantiteBulk + ", " + quantite + ")";
            stmt.executeUpdate(query);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
