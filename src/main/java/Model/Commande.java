package Model;

import java.sql.Date;


public class Commande {
    private int numero;
    private Date date;
    private String utilisateur;
    int nombre_articles;
    float prix_total;
    private String adresse;
    private String ville;

    /**
     * Constructeur de la classe Commande
     * @param numero son numéro
     * @param date sa date
     * @param utilisateur son utilisateur
     * @param nombre_articles son nombre d'articles
     * @param prix_total son prix total
     * @param adresse son adresse
     * @param ville sa ville
     */
    public Commande(int numero, Date date, String utilisateur, int nombre_articles, float prix_total, String adresse, String ville) {
        this.numero = numero;
        this.date = date;
        this.utilisateur = utilisateur;
        this.nombre_articles = nombre_articles;
        this.prix_total = prix_total;
        this.adresse = adresse;
        this.ville = ville;
    }

    public int getNumero() {
        return numero;
    }
    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }
    public String getUtilisateur() {
        return utilisateur;
    }
    public int getNombre_articles() {
        return nombre_articles;
    }
    public float getPrix_total() {
        return prix_total;
    }
    public String getAdresse() {return adresse;}
    public String getVille() {return ville;}
}
