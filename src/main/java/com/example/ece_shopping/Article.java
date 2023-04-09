package com.example.ece_shopping;

public class Article {

    private double prix;
    private double prixBulk;
    private int quantiteBulk;
    private int quantite;
    private String nom;
    private long id;

    public Article(long id, String nom, double prix, double prixBulk, int quantiteBulk, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixBulk = prixBulk;
        this.quantiteBulk = quantiteBulk;
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public double getPrixBulk() {
        return prixBulk;
    }

    public int getQuantite() {
        return quantite;
    }

    public int getQuantiteBulk() {
        return quantiteBulk;
    }

    public String getNom() {
        return nom;
    }

    public long getId() {
        return id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double calculPrix()
    {
        int difference;

        if(getQuantite()>= getQuantiteBulk())
        {
            difference = getQuantite() - getQuantiteBulk();
            return (getQuantiteBulk() * getPrixBulk()) + (difference * getPrix());
        }
        else
        {
            return getQuantite() * getPrix();
        }
    }
    public void ajouterPanier()
    {
        setQuantite(getQuantite() + 1);
    }

}
