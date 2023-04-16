package Model;

public class Article {

    private double prix;
    private double prixBulk;
    private int quantiteBulk;
    private int quantite;
    private String nom;
    private long id;
    private int articlePanier;

    /**
     * Constructeur de la classe Article
     * @param id son id
     * @param nom son nom
     * @param prix son prix
     * @param prixBulk son prix en gros
     * @param quantiteBulk sa quantité en gros
     * @param quantite sa quantité dans le panier
     */
    public Article(long id, String nom, double prix, double prixBulk, int quantiteBulk, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixBulk = prixBulk;
        this.quantiteBulk = quantiteBulk;
        this.quantite = quantite;
        this.articlePanier = 1;
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

    public int getArticlePanier() {
        return articlePanier;
    }

    public void setArticlePanier(int articlePanier) {
        this.articlePanier = articlePanier;
    }

    /**
     * Fonction de calcul du prix de l'article
     * @return le prix des articles
     */
    public double calculPrix()
    {
        if(getArticlePanier()>= getQuantiteBulk())
        {
            return (getQuantiteBulk() * getPrixBulk());
        }
        else
        {
            return getArticlePanier() * getPrix();
        }
    }
}
