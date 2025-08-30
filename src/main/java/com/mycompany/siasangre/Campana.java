/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.siasangre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mankeke
 */
public class Campana {
    private String nombreCampana;
    private String lugar;
    private List<Donante> donantesregistrados;

    public Campana(String nombreCampana, String lugar) {
        this.nombreCampana = nombreCampana;
        this.lugar = lugar;
        this.donantesregistrados = new ArrayList<>();
    }

    public String getNombreCampana() {
        return nombreCampana;
    }

    public void setNombreCampana(String nombreCampana) {
        this.nombreCampana = nombreCampana;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    public List<Donante> getDonantesregistrados() {
        return donantesregistrados;
    }

    public void setDonantesregistrados(List<Donante> donantesregistrados) {
        this.donantesregistrados = donantesregistrados;
    }
    //------------------------TERCERA SOBRECARGA----------------------------------------
    public void AgregarDonante(Donante donante) {
        this.donantesregistrados.add(donante);
    }
    //------------------------TERCERA SOBRECARGA----------------------------------------
    public void AgregarDonante(String rut, String nombre, String tipoSangre) {
        Donante nuevoDonante = new Donante(rut, nombre, tipoSangre);
        this.donantesregistrados.add(nuevoDonante);
    }
    //--------------------------------------------------------------------------
    public void  mostrarDonantes(){
        System.out.printf("\nDonantes de la campana %s.", this.nombreCampana);
        if (donantesregistrados.isEmpty()){
            System.out.println("No hay donantes registrados en la campana");
            
        }
        else{
            for(Donante donante : donantesregistrados){
                System.out.println("\n" + donante);
            }
        }
    }
    
}
