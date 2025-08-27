/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.siasangre;

/**
 *
 * @author Mankeke
 */
public class SiaSangre {

    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        sistema.cargarDatosCodigo();
        //sistema.cargarDonantes();
        //sistema.cargarCampanas();
        sistema.iniciarMenuPrincipal();
    }
}
