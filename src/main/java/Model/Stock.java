package Model;


import java.util.ArrayList;

public class Stock {

    private ArrayList<Article> stockArticle;

    public Stock(ArrayList<Article> stockArticle) {
        this.stockArticle = stockArticle;
    }

    public ArrayList<Article> getStockArticle() {
        return stockArticle;
    }

    public void afficherStock(int i,int j)
    {
        System.out.println("--------------------Article " + j + "--------------------");
        System.out.println("Id : " + getStockArticle().get(i).getId());
        System.out.println("Nom : " +getStockArticle().get(i).getNom());
        System.out.println("Prix : " + getStockArticle().get(i).getPrix());
        System.out.println("Prix en gros : " + getStockArticle().get(i).getPrixBulk());
        System.out.println("Qantité de gros : " + getStockArticle().get(i).getQuantiteBulk());
        System.out.println("Stock : " + getStockArticle().get(i).getQuantite());
    }
}
