/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.siasangre;
import javax.swing.SwingUtilities; // Importante para la GUI
/**
 *
 * @author Mankeke
 */

public class SiaSangre {

    public static void main(String[] args) {
        // 1. Creamos la instancia del sistema
        SistemaGestion sistema = new SistemaGestion();
        sistema.cargarDatosCodigo(); // Cargamos los datos de ejemplo
        //sistema.cargarDonantes();
        //sistema.cargarCampanas();

        // 2. Creamos y mostramos la ventana gráfica de forma segura
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal(sistema);
            ventana.setVisible(true);
        });
    }
}