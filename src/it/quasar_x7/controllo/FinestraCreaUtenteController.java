
package it.quasar_x7.controllo;

import it.quasar_x7.java.utile.CifrarioVigeneve;
import it.quasar_x7.modello.DatiUtente;
import static it.quasar_x7.modello.LivelloAccesso.CHIAVE_CODIFICA;
import it.quasar_x7.swing.vista.FinestraCreaUtente;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ing. Domenico della Peruta
 * @version 1.0.0 ultima modifica 13/03/2015
 */
public class FinestraCreaUtenteController {
    
    private final DatiUtente db;
    private final FinestraCreaUtente finestra;

    public FinestraCreaUtenteController(FinestraCreaUtente finestra,DatiUtente dati) {
        this.finestra = finestra;
        db = dati;
    }

    
    public boolean controlloUtente(String chiave) {
        ArrayList<String> utenti = db.tuttiUtenti();
        CifrarioVigeneve codifica = new CifrarioVigeneve(CHIAVE_CODIFICA);
        if(utenti != null)
            for(String s: utenti){
                 if(s.compareTo(codifica.cifra(chiave))==0){
                     return false;
                 }
            }
         return true;
    }

    public void pulsanteSalva(ActionEvent evt, JTextField campoNome, JPasswordField campoPasswordNuova, JPasswordField campoPasswordConferma) {
        char[] passNuova,conf;
        String nome = campoNome.getText();
        boolean errore = false;
        if(evt.getSource() instanceof javax.swing.JButton){
            if(nome.compareTo("") != 0){
                if(controlloUtente(nome)){
                    passNuova = campoPasswordNuova.getPassword();
                    conf = campoPasswordConferma.getPassword();
                    if(passNuova.length == conf.length){
                        for(int i=0; i<passNuova.length;i++){
                            if(passNuova[i]!=conf[i]){
                                errore = true;
                                break;
                            }
                        }
                    }else
                        errore = true;
                    if(errore){
                        javax.swing.JOptionPane.showMessageDialog(
                                finestra, "errore password!","errore",
                                javax.swing.JOptionPane.ERROR_MESSAGE);
                        campoPasswordConferma.setText("");
                        campoPasswordNuova.setText("");
                    }else{
                        CifrarioVigeneve codifica = new CifrarioVigeneve(CHIAVE_CODIFICA);

                        db.aggiungiUtente(nome, codifica.cifra(String.valueOf(passNuova)));
                        finestra.setVisible(false);
                        javax.swing.JOptionPane.showMessageDialog(
                                finestra, "creato nuovo utente \""+nome+"\"","info",
                                javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        finestra.setVisible(false);
                        finestra.dispose();
                        if(finestra.uscita == javax.swing.WindowConstants.EXIT_ON_CLOSE){
                            System.exit(0);
                        }
                    }
                }else{
                    javax.swing.JOptionPane.showMessageDialog(
                        finestra, "utente gia' presente!","errore",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    campoNome.setText("");
                }
            }else{
                javax.swing.JOptionPane.showMessageDialog(
                        finestra, "campo nome vuoto!","errore",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
