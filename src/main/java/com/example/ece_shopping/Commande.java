package com.example.ece_shopping;

import java.util.Date;


public class Commande {
    private int numero;
    private Date date;
    private String utilisateur;
    int nombre_articles;
    float prix_total;

    public Commande(int numero, Date date, String utilisateur, int nombre_articles, float prix_total) {
        this.numero = numero;
        this.date = date;
        this.utilisateur = utilisateur;
        this.nombre_articles = nombre_articles;
        this.prix_total = prix_total;
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
}
