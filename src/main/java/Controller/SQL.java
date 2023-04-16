package Controller;

import Model.Article;
import Model.Commande;

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

    public static ArrayList<Commande> remplirCommande() {
        ArrayList<Commande> commandeRempli = new ArrayList<Commande>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/commande", "root", "root");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM commande")) {

            while (rs.next()) {
                Commande commande = new Commande(rs.getInt("numero_commande"),rs.getDate("date"), rs.getString("utilisateur"), rs.getInt("nombre_articles"), rs.getFloat("prix_total"), rs.getString("adresse"), rs.getString("ville"));
                commandeRempli.add(commande);
            }

        } catch (SQLException e) {
            System.err.println("Error executing query");
            e.printStackTrace();
        }

        return commandeRempli;
    }


    public static void ajouterCommandeSQL(Commande commande) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/commande", "root", "root")) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO commande (numero_commande, date, utilisateur, nombre_articles, prix_total, adresse, ville) VALUES (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, commande.getNumero());
            pstmt.setDate(2, commande.getDate());
            pstmt.setString(3, commande.getUtilisateur());
            pstmt.setInt(4, commande.getNombre_articles());
            pstmt.setFloat(5, commande.getPrix_total());
            pstmt.setString(6, commande.getAdresse());
            pstmt.setString(7, commande.getVille());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void suppCommandeSQL(int numero_commande) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/commande", "root", "root")) {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM commande WHERE numero_commande = ?");
            pstmt.setInt(1, numero_commande);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void ajoutQuantite(long id) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            String query = "UPDATE article SET Quantite = Quantite + 1 WHERE Id = " + id;
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void retirQuantite(long id){
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            String query = "UPDATE article SET Quantite = Quantite - 1 WHERE Id = " + id;
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
