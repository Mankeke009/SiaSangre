/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.siasangre;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mankeke
 */
public class VentanaGestionDonantes extends javax.swing.JDialog {
    private Campana campanaSeleccionada; 
    private DefaultListModel<String> modeloListaDonantes;
    private SistemaGestion sistema;
//----------------------------------CONSTRUCTOR--------------------------------     
    public VentanaGestionDonantes(java.awt.Frame parent, boolean modal, SistemaGestion sistema, Campana campana) {
        super(parent, modal);
        this.sistema = sistema; 
        this.campanaSeleccionada = campana;
        initComponents();
    
        this.setTitle("Gestionando Donantes de la campana: " + this.campanaSeleccionada.getNombreCampana());
        modeloListaDonantes = new DefaultListModel<>();
        this.listaDonantesUI.setModel(modeloListaDonantes);
        actualizarListaDonantes();
    }
//----------------------------------CONSTRUCTOR--------------------------------    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaDonantesUI = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listaDonantesUI.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaDonantesUI);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        VentanaAgregarDonante ventanaAgregar = new VentanaAgregarDonante((java.awt.Frame) this.getParent(), true);
        ventanaAgregar.setVisible(true);

        Donante donanteCreado = ventanaAgregar.getNuevoDonante();

        if (donanteCreado != null) {
            this.sistema.agregarDonanteASistema(donanteCreado, this.campanaSeleccionada);
            this.actualizarListaDonantes(); 
            JOptionPane.showMessageDialog(this, "Donante agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int indiceSeleccionado = this.listaDonantesUI.getSelectedIndex();
        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un donante para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Donante donanteSeleccionado = this.campanaSeleccionada.getDonantesregistrados().get(indiceSeleccionado);
        VentanaModificarDonante ventanaModificar = new VentanaModificarDonante((java.awt.Frame) this.getParent(), true, donanteSeleccionado);
        ventanaModificar.setVisible(true);
        this.actualizarListaDonantes();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int indiceSeleccionado = this.listaDonantesUI.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un donante para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de que desea eliminar a este donante?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            Donante donanteAEliminar = this.campanaSeleccionada.getDonantesregistrados().get(indiceSeleccionado);

            this.campanaSeleccionada.getDonantesregistrados().remove(donanteAEliminar);

            this.actualizarListaDonantes();

            JOptionPane.showMessageDialog(this, "Donante eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       Object[] opciones = {"Buscar por RUT", "Buscar por Nombre"};
        int seleccion = JOptionPane.showOptionDialog(this, "Seleccione cómo desea buscar", "Buscar Donante",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        
//----------------------------SI ES QUE QUEREMOS BUSCAR AL DONANTE POR RUT --------------------------------------------------------------------
        if (seleccion == 0) { // Búsqueda por RUT
            List<Donante> resultados = new ArrayList<>();
            String rutTexto = JOptionPane.showInputDialog(this, "Ingrese el RUT a buscar:");
            if (rutTexto != null && !rutTexto.trim().isEmpty()) {
                try {
                    int rutNum = Integer.parseInt(rutTexto.trim());
                    resultados = this.sistema.buscarDonante(rutNum, this.campanaSeleccionada);
                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "El RUT debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }        
            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron donantes.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
                } 
                else {
                    StringBuilder mensaje = new StringBuilder("Donantes encontrados:\n");
                    for (Donante donante : resultados) {
                        mensaje.append("- ").append(donante.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(this, mensaje.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                }
        }
//----------------------------SI ES QUE QUEREMOS BUSCAR AL DONANTE POR NOMBRE --------------------------------------------------------------------        
        else if (seleccion == 1) { 
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre (o parte del nombre):");
            if (nombre != null && !nombre.trim().isEmpty()) {
                
                List<Donante> donantesEncontrados = this.sistema.buscarDonante(nombre, this.campanaSeleccionada); //USO SOBRECARGA 

                if (donantesEncontrados.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se encontraron donantes con ese nombre.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
                } 
                else {
                    StringBuilder mensaje = new StringBuilder("Donantes encontrados:\n");
                    for (Donante donante : donantesEncontrados) {
                        mensaje.append("- ").append(donante.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(this, mensaje.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaDonantesUI;
    // End of variables declaration//GEN-END:variables

    private void actualizarListaDonantes() {
    modeloListaDonantes.clear();
    for (Donante donante : this.campanaSeleccionada.getDonantesregistrados()) {
       modeloListaDonantes.addElement("Nombre : " + donante.getNombre() + " - RUT:" + donante.getRUT() + " - Sangre: " + donante.getTipoSangre());
    }
}
}
