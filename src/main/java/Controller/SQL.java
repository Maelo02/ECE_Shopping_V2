package Controller;

import Model.Article;
import Model.Commande;

import java.sql.*;
import java.util.*;

public class SQL {

    /**
     * Fonction de connexion à la base de données article
     *
     * @return Connection
     */
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

    /**
     * Fonction de remplissage de la liste des articles
     *
     * @return ArrayList<Article>
     */
    public static ArrayList<Article> remplirStock() {
        ArrayList<Article> stockRempli = new ArrayList<>();
        Connection conn = connect();

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

    /**
     * Fonction d'ajout d'un article dans la base de données
     *
     * @param nomF         le nom de l'article
     * @param prix         le prix de l'article
     * @param prixBulk     le prix de l'article en gros
     * @param quantite     la quantité de l'article
     * @param quantiteBulk la quantité de l'article en gros
     * @param id           l'id de l'article
     */
    public static void ajouterArticle(String nomF, double prix, double prixBulk, int quantite, int quantiteBulk, int id) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO article (Id, Nom, Prix, PrixBulk, QuantiteBulk, Quantite) VALUES (" + id + ", '" + nomF + "', " + prix + ", " + prixBulk + ", " + quantiteBulk + ", " + quantite + ")";
            stmt.executeUpdate(query);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction de connexion et de remplissage de la liste des commandes
     */
    public static ArrayList<Commande> remplirCommande() {
        ArrayList<Commande> commandeRempli = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/commande", "root", "root");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM commande")) {

            while (rs.next()) {
                Commande commande = new Commande(rs.getInt("numero_commande"), rs.getDate("date"), rs.getString("utilisateur"), rs.getInt("nombre_articles"), rs.getFloat("prix_total"), rs.getString("adresse"), rs.getString("ville"));
                commandeRempli.add(commande);
            }

        } catch (SQLException e) {
            System.err.println("Error executing query");
            e.printStackTrace();
        }

        return commandeRempli;
    }

    /**
     * Fonction d'ajout d'une commande dans la base de données
     *
     * @param commande la commande à ajouter
     */
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

    /**
     * Fonction de suppression d'une commande dans la base de données
     *
     * @param numero_commande le numéro de la commande à supprimer
     */
    public static void suppCommandeSQL(int numero_commande) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/commande", "root", "root")) {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM commande WHERE numero_commande = ?");
            pstmt.setInt(1, numero_commande);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fonction permettant d'augmenter le quantité d'un article
     *
     * @param id l'id de l'article dont on doit augmenter la quantite
     */
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

    /**
     * Fonction permettant de diminuer le quantité d'un article
     *
     * @param id l'id de l'article dont on doit diminuer la quantite
     */
    public static void retirQuantite(long id) {
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
