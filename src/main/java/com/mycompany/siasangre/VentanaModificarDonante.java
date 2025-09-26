/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.siasangre;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author Mankeke
 */
public class VentanaModificarDonante extends javax.swing.JDialog {
    private Donante donanteAEditar;
//----------------------------------CONSTRUCTOR--------------------------------    
    public VentanaModificarDonante(java.awt.Frame parent, boolean modal, Donante donante) {
        super(parent, modal);
        this.donanteAEditar = donante; 
        initComponents();
        this.setTitle("Modificar Donante");
        setLocationRelativeTo(parent);

        this.txtRut.setText(String.valueOf(donanteAEditar.getRUT()));
        this.txtNombre.setText(donanteAEditar.getNombre());
        this.txtTipoSangre.setText(donanteAEditar.getTipoSangre());
        
        this.txtRut.setEditable(false);
    }
//----------------------------------CONSTRUCTOR--------------------------------    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTipoSangre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("RUT");

        jLabel1.setText("NOMBRE");

        jLabel2.setText("TIPO DE SANGRE");

        txtRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtTipoSangre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoSangreActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(23, 23, 23)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRut, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtTipoSangre))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRut, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTipoSangre, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRutActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtTipoSangreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSangreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSangreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {//-----> SIA 2.8
            String nuevoNombre = this.txtNombre.getText().trim();
            String nuevoTipoSangre = this.txtTipoSangre.getText().trim();
//----------------------------------VALIDACIONES POR SI SI ESCRIBE ALGUN "CARACTER" NO DESEADO--------------------------------

            if (nuevoNombre.isEmpty() || nuevoTipoSangre.isEmpty()) {
                throw new DatoVacioException("Los campos de nombre y tipo de sangre son obligatorios.");//-----> SIA 2.9
            }
            if (!nuevoNombre.matches("^[a-zA-Z\\s]+$")) {
                throw new DatoVacioException("El nombre solo puede contener letras y espacios.");//-----> SIA 2.9
            }
            if (!nuevoTipoSangre.matches("^(?i)(A|B|O|AB)[\\+-]$")) {
                throw new DatoVacioException("El tipo de sangre no es válido. Ej: A+, O-, AB+");//-----> SIA 2.9
            }
            
//----------------------------------VALIDACIONES POR SI SI ESCRIBE ALGUN "CARACTER" NO DESEADO--------------------------------

            this.donanteAEditar.setNombre(nuevoNombre);
            this.donanteAEditar.setTipoSangre(nuevoTipoSangre);
            this.dispose();

        }catch (DatoVacioException e) {//-----> SIA 2.9 Y  2.8
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTipoSangre;
    // End of variables declaration//GEN-END:variables
}
