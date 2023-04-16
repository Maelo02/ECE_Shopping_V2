package Model;

import Controller.SQL;

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

    /**
     * Fonction d'ajout d'une commande à la liste des commandes
     *
     * @param numero_commande son numéro
     * @param date            sa date
     * @param utilisateur     son utilisateur
     * @param nombre_articles son nombre d'articles
     * @param prix_total      son prix total
     * @param adresse         son adresse
     * @param ville           sa ville
     */
    public static void ajouterCommande(int numero_commande, Date date, String utilisateur, int nombre_articles, float prix_total, String adresse, String ville) {
        Commande nouvelleCommande = new Commande(numero_commande, date, utilisateur, nombre_articles, prix_total, adresse, ville);
        SQL.ajouterCommandeSQL(nouvelleCommande);
       // listeCommande.add(nouvelleCommande);
    }
}
