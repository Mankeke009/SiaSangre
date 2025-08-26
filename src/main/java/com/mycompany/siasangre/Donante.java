/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.siasangre;

/**
 *
 * @author Mankeke
 */
public class Donante {
    private String RUT;
    private String nombre;
    private String tipoSangre;
    
    public Donante(String RUT, String nombre, String tipoSangre){
        this.RUT = RUT;
        this.nombre = nombre;
        this.tipoSangre = tipoSangre;        
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
    
}
