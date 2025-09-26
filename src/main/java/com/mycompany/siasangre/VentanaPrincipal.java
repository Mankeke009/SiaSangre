/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.siasangre;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.File;
/**
 *
 * @author Mankeke
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private SistemaGestion sistema; 
    private DefaultListModel<String> modeloLista; 
//----------------------------------CONSTRUCTOR--------------------------------    
    public VentanaPrincipal(SistemaGestion sistema) {
        this.sistema = sistema;
        initComponents();

        modeloLista = new DefaultListModel<>();
        this.listaCampanasUI.setModel(modeloLista);
        actualizarListaCampanas();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                sistema.guardarDonantesCSV();
                sistema.guardarCampanasCSV();
            }
    });
}
//----------------------------------CONSTRUCTOR--------------------------------    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaCampanasUI = new javax.swing.JList<>();
        btnAgregarCampana = new javax.swing.JButton();
        btnEliminarCampana = new javax.swing.JButton();
        btnGestionarDonantes = new javax.swing.JButton();
        btnBuscarCampana = new javax.swing.JButton();
        btnGenerarReporte = new javax.swing.JButton();

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

        btnGenerarReporte.setText("GENERAR REPORTE");
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGestionarDonantes, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnBuscarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminarCampana, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnGestionarDonantes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCampanaActionPerformed
        String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre de la nueva campaña:", "Agregar Campaña", JOptionPane.PLAIN_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }
        nombre = nombre.trim(); 

        if (!nombre.matches("^[a-zA-Z\\s]+$")) {
            JOptionPane.showMessageDialog(this, "El nombre de la campaña solo puede contener letras y espacios.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String lugar = JOptionPane.showInputDialog(this, "Ingrese el lugar de la campaña:", "Agregar Campaña", JOptionPane.PLAIN_MESSAGE);
        if (lugar == null || lugar.trim().isEmpty()) {
            return;
        }
        lugar = lugar.trim(); 

        if (!lugar.matches("^[a-zA-Z0-9\\s]+$")) {
            JOptionPane.showMessageDialog(this, "El lugar solo puede contener letras, números y espacios.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "Seleccione una campaña para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "Está seguro de que desea eliminar esta campaña y todos sus donantes",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            this.sistema.getListaCampanas().remove(indiceSeleccionado);

            this.actualizarListaCampanas();

            JOptionPane.showMessageDialog(this, "Campaña eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarCampanaActionPerformed

    private void btnGestionarDonantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarDonantesActionPerformed
        int indiceSeleccionado = this.listaCampanasUI.getSelectedIndex();

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una campaña para gestionar.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        else {
        Campana campanaSeleccionada = this.sistema.getListaCampanas().get(indiceSeleccionado);
        VentanaGestionDonantes ventanaDonantes = new VentanaGestionDonantes(this, true, this.sistema, campanaSeleccionada);
        ventanaDonantes.setVisible(true);
        }
    }//GEN-LAST:event_btnGestionarDonantesActionPerformed

    private void btnBuscarCampanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCampanaActionPerformed
        Object[] opciones = {"Por Lugar", "Por Nombre y Lugar"};
        int seleccion = JOptionPane.showOptionDialog(this, "Seleccione el tipo de búsqueda", "Buscar Campaña",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        List<Campana> resultados = new ArrayList<>(); 
//------------------------------SI ES QUE QUEREMOS BUSCAR CAMPANA SOLO POR LUGAR ------------------------------------------
        if (seleccion == 0) { 
            String lugar = JOptionPane.showInputDialog(this, "Ingrese el lugar:");
            if (lugar != null && !lugar.trim().isEmpty()) {
                resultados = this.sistema.buscarCampana(lugar); //UTILIZACION DE SOBRECARGA 
            }
        }
//------------------------------SI ES QUE QUEREMOS BUSCAR CAMPANA POR NOMBRE Y LUGAR ------------------------------------------           
        else if (seleccion == 1) {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre :");
            String lugar = JOptionPane.showInputDialog(this, "Ingrese el lugar :");
            if (nombre != null && !nombre.trim().isEmpty() && lugar != null && !lugar.trim().isEmpty()) {
                
                resultados = this.sistema.buscarCampana(nombre, lugar);//UTILIZACION DE SOBRECARGA 
            }
        } 
        else {
            
            return;
        }
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron campañas", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
        } 
        else {
            StringBuilder mensaje = new StringBuilder("Campañas encontradas:\n");
            for (Campana campana : resultados) {
                mensaje.append("- ").append(campana.getNombreCampana()).append(" (").append(campana.getLugar()).append(")\n");
            }
            JOptionPane.showMessageDialog(this, mensaje.toString(), "Resultados de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarCampanaActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
        //SIA 2,10 COMPLETADO!!!!! 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setSelectedFile(new File("reporte_donaciones.txt")); 

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File archivoParaGuardar = fileChooser.getSelectedFile();

            try (PrintWriter pw = new PrintWriter(new FileWriter(archivoParaGuardar))) {

                pw.println("=============================================");
                pw.println("      REPORTE DE CAMPAÑAS DE DONACIÓN");
                pw.println("=============================================");
                pw.println();

                for (Campana campana : this.sistema.getListaCampanas()) {
                    pw.println("--- CAMPAÑA: " + campana.getNombreCampana().toUpperCase() + " ---");
                    pw.println("Lugar: " + campana.getLugar());

                    List<Donante> donantes = campana.getDonantesregistrados();
                    if (donantes.isEmpty()) {
                        pw.println("Donantes: No hay donantes registrados.");
                    } 
                    else {
                        pw.println("Donantes registrados: " + donantes.size());
                        for (Donante donante : donantes) {
                            pw.printf("- %s (RUT: %d, Sangre: %s)\n", 
                                      donante.getNombre(), donante.getRUT(), donante.getTipoSangre());
                        }
                    }
                    pw.println();
                }

                pw.println("--- FIN DEL REPORTE ---"); 
                JOptionPane.showMessageDialog(this, 
                        "Reporte generado exitosamente en:\n" + archivoParaGuardar.getAbsolutePath(), 
                        "Éxito", 
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, 
                        "Error al guardar el reporte: " + e.getMessage(), 
                        "Error de Archivo", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCampana;
    private javax.swing.JButton btnBuscarCampana;
    private javax.swing.JButton btnEliminarCampana;
    private javax.swing.JButton btnGenerarReporte;
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
