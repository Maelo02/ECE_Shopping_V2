package Model;

import java.util.ArrayList;

public class Panier {
    ArrayList<Article> panierArticle = new ArrayList<Article>();

    public Panier() {
    panierArticle = new ArrayList<Article>();
    }

    public void ajouterArticle(Article article) {
        panierArticle.add(article);
    }

    public void suppArticle(Article article) {
        panierArticle.remove(article);
    }

    public ArrayList<Article> getPanierArticle() {
        return panierArticle;
    }
}
