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

}
