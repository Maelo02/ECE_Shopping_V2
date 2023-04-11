package com.example.ece_shopping;

import java.util.ArrayList;

public class ListeCommande {

    private ArrayList<Commande> listeCommande;

    public ListeCommande(ArrayList<Commande> listeCommande) {
        this.listeCommande = listeCommande;
    }

    public ArrayList<Commande> getListeCommande() {
        return listeCommande;
    }

    public void afficherCommande(int i)
    {
        System.out.println("--------------------Commande--------------------");
        System.out.println("numero : " + getListeCommande().get(i).getNumero());
        System.out.println("date : " + getListeCommande().get(i).getDate());
        System.out.println("utilisateur : " + getListeCommande().get(i).getUtilisateur());
        System.out.println("nombre d'articles : " + getListeCommande().get(i).getNombre_articles());
        System.out.println("prix total : " + getListeCommande().get(i).getPrix_total());
    }
}
