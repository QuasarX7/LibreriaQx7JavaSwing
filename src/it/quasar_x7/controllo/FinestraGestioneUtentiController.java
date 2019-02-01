package it.quasar_x7.controllo;



import it.quasar_x7.modello.DatiUtente;
import it.quasar_x7.modello.LivelloAccesso;
import it.quasar_x7.swing.vista.FinestraGestioneUtenti;
import it.quasar_x7.swing.vista.RigaSelettiva;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr. Domenico della Peruta
 * @version 1.0.0 ultima modifica
 */
public class FinestraGestioneUtentiController {

    public static String utente;
    private final DatiUtente datiUtente;

    private final FinestraGestioneUtenti finestra;
    
    
    public FinestraGestioneUtentiController(FinestraGestioneUtenti finestra,DatiUtente dati) {
        this.finestra= finestra;
        datiUtente = dati;
        
    }
    
    public void salva() {
        for(Component riga :finestra.pannello.getComponents()){
            if(((RigaSelettiva)riga).attivo()){
                datiUtente.modificaLivello(
                        ((RigaSelettiva)riga).etichetta(),
                        ((RigaSelettiva)riga).selezione()
                    );
            }
        }
    }
    
    public void creaLista(){
        ArrayList<String> utenti = datiUtente.tuttiUtenti();
        if(utenti != null){
            int nrRighe = datiUtente.tuttiUtenti().size();
            if(nrRighe < 15)
                nrRighe = 15;
            finestra.pannello.setLayout(new GridLayout(nrRighe,1));
            ArrayList<String> voci =new ArrayList<>();
            voci.add(LivelloAccesso.OSSERVATORE);
            voci.add(LivelloAccesso.OPERATORE);
            voci.add(LivelloAccesso.AMMINISTRATORE);
            for(String utente: utenti){
                RigaSelettiva riga =new RigaSelettiva(utente,null,voci);
                String livello = datiUtente.livello(utente);
                if(livello != null)
                    riga.selezione(livello);
                finestra.pannello.add(riga);
            }
        }
    }

    public void salva(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            String livello = datiUtente.livello(utente);
            if(livello != null)
                if(livello.compareTo(LivelloAccesso.AMMINISTRATORE)==0){
                    salva();
                    JOptionPane.showMessageDialog(
                            finestra, "Lista livelli modificata!","avviso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    finestra.setVisible(false);
                    finestra.dispose();
                    if(finestra.uscita == javax.swing.WindowConstants.EXIT_ON_CLOSE)
                        System.exit(0);
                    return;
                }
            JOptionPane.showMessageDialog(
                    finestra, "Solo l'AMMINISTRATORE può modifivare la lista.","errore",
                    JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(
                        getClass().getResource("/it/quasar_x7/immagini/infermiera_attesa.gif"))

            );
            
        }
    }

    public void elimina(ActionEvent evt) {
        if(evt.getSource() instanceof javax.swing.JButton){
            if(datiUtente.verifica(utente, LivelloAccesso.AMMINISTRATORE)){
                String utente = (String) JOptionPane.showInputDialog(
                        finestra,
                        "seleziona l'utente da ELIMINARE:",
                        "attenzione!",
                        JOptionPane.QUESTION_MESSAGE,
                        new ImageIcon(getClass().getResource("/it/quasar_x7/immagini/infermiera_attesa.gif")),
                        datiUtente.tuttiUtenti().toArray(),
                        null
                );
                if(utente != null){
                    datiUtente.eliminaUtente(utente);
                    javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "Utenti"+utente+" eliminato!",
                    "ERRORE", javax.swing.JOptionPane.WARNING_MESSAGE
                    );
                    finestra.setVisible(false);
                    finestra.dispose();
                    if(finestra.uscita == javax.swing.WindowConstants.DISPOSE_ON_CLOSE)
                        System.exit(0);
                }
                
            }else{
                javax.swing.JOptionPane.showMessageDialog(
                    null,
                    "solo l'Amministratore puo' eliminare gli utenti. :P ",
                    "ERRORE", javax.swing.JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(
                        getClass().getResource("/it/quasar_x7/immagini/infermiera_attesa.gif")));
            }
        }
    }
    
}
