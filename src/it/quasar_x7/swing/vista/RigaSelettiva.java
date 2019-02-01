package it.quasar_x7.swing.vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.util.ArrayList;

/*******************************************************************************
 *
 * @version 2.0.0 ultima modifica 27/01/15
 * @author Ing. Domenico della Peruta
 ******************************************************************************/
public class RigaSelettiva extends javax.swing.JPanel {

    ;

    /**
     * Creates new form RigaPresenza
     */
    public RigaSelettiva() {
        initComponents();
    }
    
    /***************************************************************************
     * 
     * @param nomeEtichetta
     * @param valorePredefinito
     * @param voci 
     **************************************************************************/
    public RigaSelettiva(String nomeEtichetta,String valorePredefinito,ArrayList<String> voci) {
        this();
        if(valorePredefinito != null)
            selezione.addItem(valorePredefinito);
        if(voci != null){
            for(String posizione: voci){
                selezione.addItem(posizione);
            }
        }
        this.selezione.setSelectedIndex(-1);
        this.etichetta.setText(nomeEtichetta);
    }
    
    public String etichetta(){
        return this.etichetta.getText();
    }
    
    public String selezione(){
        if(this.selezione.getSelectedItem()!= null)
            return this.selezione.getSelectedItem().toString();
        return "";
    }

    public void selezione(Object _posizione) {
        this.selezione.setSelectedItem(_posizione);
    }
    
    public void colora(){
        String posizione = this.selezione();
        if(posizione != null){
            if(posizione.compareTo("")!=0){
                this.etichetta.setForeground(Color.black);
            }else{
                this.etichetta.setForeground(Color.gray);
            }
        }
    }
    
    public boolean attivo(){
        return this.selezione.getSelectedIndex() >= 0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selezione = new javax.swing.JComboBox();
        etichetta = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        selezione.setBackground(new java.awt.Color(204, 204, 204));
        selezione.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selezioneItemStateChanged(evt);
            }
        });

        etichetta.setBackground(new java.awt.Color(204, 204, 204));
        etichetta.setFont(new java.awt.Font("Arial Black", 1, 13)); // NOI18N
        etichetta.setText("......................................................................");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(etichetta, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selezione, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etichetta)
                    .addComponent(selezione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selezioneItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selezioneItemStateChanged
        if(evt.getSource() instanceof javax.swing.JComboBox){
            colora();
        }
    }//GEN-LAST:event_selezioneItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etichetta;
    private javax.swing.JComboBox selezione;
    // End of variables declaration//GEN-END:variables

    
}
