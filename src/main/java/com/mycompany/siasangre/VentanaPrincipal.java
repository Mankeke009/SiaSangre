/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
        btnBuscarCampana = new javax.swing.JButton();

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

        btnBuscarCampana.setText("Buscar Campaña");
        btnBuscarCampana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCampanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionarDonantes, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnBuscarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnGestionarDonantes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCampanaActionPerformed
        String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre de la nueva campaña:", "Agregar Campaña", JOptionPane.PLAIN_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }

        String lugar = JOptionPane.showInputDialog(this, "Ingrese el lugar de la campaña:", "Agregar Campaña", JOptionPane.PLAIN_MESSAGE);
        if (lugar == null || lugar.trim().isEmpty()) {
            return; 
        }

        Campana nuevaCampana = new Campana(nombre, lugar);
        this.sistema.getListaCampanas().add(nuevaCampana);

        this.actualizarListaCampanas();

        JOptionPane.showMessageDialog(this, "Campaña agregada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAgregarCampanaActionPerformed

    private void btnEliminarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCampanaActionPerformed
        int indiceSeleccionado = this.listaCampanasUI.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una campaña para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de que desea eliminar esta campaña y todos sus donantes asociados?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Simplemente removemos la campaña de la lista principal en SistemaGestion
            this.sistema.getListaCampanas().remove(indiceSeleccionado);

            // Refrescamos la lista en la pantalla
            this.actualizarListaCampanas();

            JOptionPane.showMessageDialog(this, "Campaña eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
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

    private void btnBuscarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCampanaActionPerformed
        Object[] opciones = {"Por Lugar", "Por Nombre y Lugar"};
        int seleccion = JOptionPane.showOptionDialog(this, "Seleccione el tipo de búsqueda", "Buscar Campaña",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        List<Campana> resultados = new ArrayList<>(); // Lista para guardar los resultados

        if (seleccion == 0) { 
            String lugar = JOptionPane.showInputDialog(this, "Ingrese el lugar a buscar:");
            if (lugar != null && !lugar.trim().isEmpty()) {
                //1
                resultados = this.sistema.buscarCampana(lugar); 
            }
        } else if (seleccion == 1) { // El usuario eligió "Por Nombre y Lugar"
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre a buscar:");
            String lugar = JOptionPane.showInputDialog(this, "Ingrese el lugar a buscar:");
            if (nombre != null && !nombre.trim().isEmpty() && lugar != null && !lugar.trim().isEmpty()) {
                //2 
                resultados = this.sistema.buscarCampana(nombre, lugar);
            }
        } else {
            
            return;
        }

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron campañas con ese criterio.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensaje = new StringBuilder("Campañas encontradas:\n");
            for (Campana campana : resultados) {
                mensaje.append("- ").append(campana.getNombreCampana()).append(" (").append(campana.getLugar()).append(")\n");
            }
            JOptionPane.showMessageDialog(this, mensaje.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarCampanaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCampana;
    private javax.swing.JButton btnBuscarCampana;
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
