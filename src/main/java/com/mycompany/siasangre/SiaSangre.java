/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.siasangre;
import javax.swing.SwingUtilities; 
/**
 *
 * @author Mankeke
 */

public class SiaSangre {
    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        //sistema.cargarDatosCodigo(); // Cargamos los datos de ejemplo
        sistema.cargarDonantes();
        sistema.cargarCampanas();

        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal(sistema);
            ventana.setVisible(true);
        });
    }
    
}