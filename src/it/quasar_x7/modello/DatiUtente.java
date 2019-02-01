package it.quasar_x7.modello;

import java.util.ArrayList;

/**
 *
 * @author Dr. Domenico della Peruta
 */
public interface DatiUtente {

    
    public void modificaLivello(String utente, String livello);    

    public ArrayList<String> tuttiUtenti();

    public String livello(String utente);
    /**
     * Verifica il livello di accesso.
     * 
     * @param utente
     * @param livello
     * @return 
     */
    public boolean verifica(String utente, String livello);

    public void eliminaUtente(String utente);

    public void aggiungiUtente(String nome, String password);
}
