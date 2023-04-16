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
}
