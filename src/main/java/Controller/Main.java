package Controller;
import View.LoginInterface;
import javafx.application.Application;

public class Main {

    /**
     * Fonction de lancement de notre application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(LoginInterface.class, args);
    }
}