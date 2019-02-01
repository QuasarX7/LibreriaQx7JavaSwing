package it.quasar_x7.swing;



import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Classe che implementa tutti i comportamenti e i metodi comuni.
 * 
 * @author Dr. Domenico della Peruta
 * @version 3.0.0 ultima modifica 02/11/2018
 */
public class Finestra {
    
    public static  JFrame finestra;
    
    public static Object[] impostazioni;
    /**
     * Crea ed instanzia una finestra grafica che occupa il centro dello schermo.
     * 
     * @param finestra 
     */
    static public void creaFinestra(final javax.swing.JFrame finestra){
        java.awt.EventQueue.invokeLater(() -> {
            double altezza = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
            final int y = (int) ((altezza - finestra.getHeight())/2);
            double lunghezza = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
            final int x = (int) ((lunghezza - finestra.getWidth())/2);
            finestra.setLocation(x,y);
            finestra.setVisible(true);
        });
    }
    
    
    
    
    
}
