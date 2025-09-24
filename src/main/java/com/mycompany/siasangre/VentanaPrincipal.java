/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.siasangre;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Mankeke
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private SistemaGestion sistema; 
    private DefaultListModel<String> modeloLista; 

    public VentanaPrincipal(SistemaGestion sistema) { 
        this.sistema = sistema;
        initComponents();
        
        modeloLista = new DefaultListModel<>();
        this.listaCampanasUI.setModel(modeloLista); 
        actualizarListaCampanas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaCampanasUI = new javax.swing.JList<>();
        btnAgregarCampana = new javax.swing.JButton();
        btnEliminarCampana = new javax.swing.JButton();
        btnGestionarDonantes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaCampanasUI.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaCampanasUI);

        btnAgregarCampana.setText("Agregar Campaña");
        btnAgregarCampana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCampanaActionPerformed(evt);
            }
        });

        btnEliminarCampana.setText("Eliminar Campaña");
        btnEliminarCampana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCampanaActionPerformed(evt);
            }
        });

        btnGestionarDonantes.setText("Gestionar Donantes de Campaña");
        btnGestionarDonantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarDonantesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGestionarDonantes, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnGestionarDonantes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCampanaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCampanaActionPerformed

    private void btnEliminarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCampanaActionPerformed
        

    }//GEN-LAST:event_btnEliminarCampanaActionPerformed

    private void btnGestionarDonantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarDonantesActionPerformed
        int indiceSeleccionado = this.listaCampanasUI.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una campaña para gestionar.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Campana campanaSeleccionada = this.sistema.getListaCampanas().get(indiceSeleccionado);
        VentanaGestionDonantes ventanaDonantes = new VentanaGestionDonantes(this, true, campanaSeleccionada);
        ventanaDonantes.setVisible(true);
        }
    }//GEN-LAST:event_btnGestionarDonantesActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCampana;
    private javax.swing.JButton btnEliminarCampana;
    private javax.swing.JButton btnGestionarDonantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaCampanasUI;
    // End of variables declaration//GEN-END:variables
    private void actualizarListaCampanas() {
        modeloLista.clear();
        for (Campana campana : sistema.getListaCampanas()) {
            modeloLista.addElement(campana.getNombreCampana() + " (" + campana.getLugar() + ")");
        }
    }
}
