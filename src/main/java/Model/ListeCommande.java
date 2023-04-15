package Model;

import Controller.SQL;
import Model.Commande;

import java.sql.Date;
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

    public void ajouterCommande(int numero_commande, Date date, String utilisateur, int nombre_articles, float prix_total) {
        Commande nouvelleCommande = new Commande(numero_commande, date, utilisateur, nombre_articles, prix_total);
        SQL.ajouterCommandeSQL(nouvelleCommande);
        listeCommande.add(nouvelleCommande);
    }
    public void suppCommande(int numero_commande) {
        SQL.suppCommandeSQL(numero_commande);
        for(int i = 0; i < listeCommande.size(); i++)
        {
            if(listeCommande.get(i).getNumero() == numero_commande)
            {
                listeCommande.remove(i);
            }
        }
    }

}
