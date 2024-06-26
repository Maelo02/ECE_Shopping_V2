package Controller;
import java.sql.*;
import java.util.*;

public class UserSQL {



    /**
     * Fonction de connexion à la base de données pour les utilisateurs
     * renvoie une connexion
     */
    public static Connection connect() {
        Connection conn = null;

        try {
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:8889/user";

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);

        } catch (Exception e) {

            System.err.println("Impossible de se connecter à la base de données");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Fonction de récupération des utilisateurs de la base de données
     * renvoie un HashMap avec les utilisateurs et leurs mots de passe
     */
    public static HashMap<String, String> getUsers()
    {
        HashMap<String, String> users = new HashMap<String, String>();
        Connection conn = connect();

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM utilisateur";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("nom_utilisateur");
                String password = rs.getString("mot_de_passe");
                users.put(username, password);
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête");
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Fonction d'ajout d'un utilisateur dans la base de données
     * @param nomUtilisateur le nom de l'utilisateur
     * @param motDePasse le mot de passe de l'utilisateur
     * @param admin si l'utilisateur est administrateur ou non
     */
    public static void ajouterUtilisateur(String nomUtilisateur, String motDePasse, boolean admin)
    {
        Connection conn = connect();

        try {
            String query = "INSERT INTO utilisateur (nom_utilisateur, mot_de_passe, admin) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nomUtilisateur);
            pstmt.setString(2, motDePasse);
            pstmt.setBoolean(3, admin);
            pstmt.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur");
            e.printStackTrace();
        }
    }

    /**
     * Fonction de verification de droit d'administrateur
     * @param username le nom de l'utilisateur
     */
    public static boolean isAdmin(String username) {
        Connection conn = connect();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT admin FROM utilisateur WHERE nom_utilisateur = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                boolean isAdmin = rs.getBoolean("admin");
                conn.close();
                return isAdmin;
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'exécution de la requête");
            e.printStackTrace();
        }

        return false; // Si aucun utilisateur correspondant n'a été trouvé, retourner false
    }

    /**
     * Fonction de vérification de l'authentification d'un utilisateur
     * @param nomUtilisateur le nom de l'utilisateur
     * @param motDePasse le mot de passe de l'utilisateur
     */
    public static boolean authentifierUtilisateur(String nomUtilisateur, String motDePasse) {
        HashMap<String, String> users = getUsers();
        if (users.containsKey(nomUtilisateur) && users.get(nomUtilisateur).equals(motDePasse)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Fonction de création d'un utilisateur
     * @param username le nom de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     */
    public static boolean creerUtilisateur(String username, String password) {
        HashMap<String, String> users = getUsers();
        if (users.containsKey(username)) {
            return false;
        } else {
            ajouterUtilisateur(username, password, false);
            return true;
        }
    }
}
