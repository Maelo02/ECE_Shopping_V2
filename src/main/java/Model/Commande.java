package Model;

import java.util.Date;


public class Commande {
    private int numero;
    private Date date;
    private String utilisateur;
    int nombre_articles;
    float prix_total;
    private String adresse;
    private String ville;

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
