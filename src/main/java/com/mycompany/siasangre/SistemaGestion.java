package com.mycompany.siasangre;
//Commit NetBeans
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mankeke
 */
public class SistemaGestion {
    
    private List<Campana> listaCampanas;
    private Map<Integer, Donante> mapaDonantes;
    
    public SistemaGestion() {
        this.listaCampanas = new ArrayList<>();
        this.mapaDonantes = new HashMap<>();
    }
    
    /*public void cargarDatosCodigo(){

        Donante d1 = new Donante("11111111-1", "Juan Perez", "O+");
        Donante d2 = new Donante("22222222-2", "Ana Lopez", "A-");
        Donante d3 = new Donante("33333333-3", "Pedro Soto", "B+");
        Donante d4 = new Donante("44444444-4", "Maria Rojas", "AB-");

        mapaDonantes.put(d1.getRUT(), d1);
        mapaDonantes.put(d2.getRUT(), d2);
        mapaDonantes.put(d3.getRUT(), d3);
        mapaDonantes.put(d4.getRUT(), d4);

        Campana c1 = new Campana("Dona Vida Valparaiso", "Plaza Sotomayor");
        Campana c2 = new Campana("Sangre para Vina", "Mall Marina");
        Campana c3 = new Campana("Campana de Invierno", "Hospital G. Fricke");
//-----------------------------------------------------------------------------------
        c1.AgregarDonante(d1);//Uso Tercera Sobre carga
        c1.AgregarDonante(d2);//Uso Tercera Sobre carga
        c2.AgregarDonante(d3);//Uso Tercera Sobre carga
        c3.AgregarDonante(d4);//Uso Tercera Sobre carga
        c3.AgregarDonante(d1);//Uso Tercera Sobre carga
//-------------------------------------------------------------------------------------
        listaCampanas.add(c1);
        listaCampanas.add(c2);
        listaCampanas.add(c3);
        
        System.out.println("Donantes y campanas cargadas");
    }
    */
    //-----------------------------------------CARGAR DONANTES DE CSV---------------------------------------------
    public void cargarDonantes() {
        try (BufferedReader br = new BufferedReader(new FileReader("donantes.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#") || linea.trim().isEmpty()) continue;
                String[] datos = linea.split(",");
                try {
                    String rutLimpio = datos[0].replace(".", "").split("-")[0];
                    int rutNum = Integer.parseInt(rutLimpio);

                    Donante donante = new Donante(rutNum, datos[1], datos[2]);
                    mapaDonantes.put(donante.getRUT(), donante);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("Error de formato en RUT, se omitirá la línea del CSV: " + linea);
                }
            }
            System.out.println(mapaDonantes.size() + " donantes cargados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de donantes.");
        }
    }
    
    //-----------------------------------------------CARGAR CAMPANAS DE CSV---------------------------------------

    public void cargarCampanas() {
        try (BufferedReader br = new BufferedReader(new FileReader("campanas.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#") || linea.trim().isEmpty()) continue;

                String[] datos = linea.split(",");
                Campana campana = new Campana(datos[0], datos[1]);

                
                if (datos.length == 3) {
                    String[] rutsDonantesTexto = datos[2].split("\\|");
                    for (String rutTexto : rutsDonantesTexto) {
                        try {
                            int rutNum = Integer.parseInt(rutTexto.trim());
                            Donante donanteAsignar = mapaDonantes.get(rutNum);

                            if (donanteAsignar != null) {
                                campana.AgregarDonante(donanteAsignar);
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("RUT inválido, se omitirá: " + rutTexto);
                        }
                    }
                }
                listaCampanas.add(campana);
            }
            System.out.println( + listaCampanas.size() + " campañas cargadas ");
        } catch (IOException e) {
            System.err.println(" Error al leer el archivo " + e.getMessage());
        }
    }
    
    //-----------------------------------------SEGUNDA SOBRECARGA-----------------------------------------------------------
    public List<Campana> buscarCampana(String lugar) {
        List<Campana> encontrados = new ArrayList<>();
        for (Campana campana : listaCampanas) {
            if (campana.getLugar().toLowerCase().contains(lugar.toLowerCase())) {
               encontrados.add(campana);
            }
        }
        return encontrados;
    }
    //-------------------------------------SEGUNDA SOBRECARGA-------------------------------------------------------
    public  List<Campana> buscarCampana(String nombre, String lugar) {
        List<Campana> encontrados = new ArrayList<>();
        for (Campana campana : listaCampanas) {
            if (campana.getNombreCampana().equalsIgnoreCase(nombre) && campana.getLugar().equalsIgnoreCase(lugar)) {
                encontrados.add(campana);           
            }
        }
        return encontrados;
    }
    //----------------------------PRIMERA SOBRECARGA--------------------------------------------------------
    public List<Donante> buscarDonante(int rut, Campana campana) {
        List<Donante> encontrados = new ArrayList<>(); 
        for (Donante donante : campana.getDonantesregistrados()) {
            if (donante.getRUT() == rut) {
                encontrados.add(donante); 
                break; 
            }
        }
        return encontrados;
    }
    //----------------------------PRIMERA SOBRECARGA----------------------------------------------------------------
    public List<Donante> buscarDonante(String nombre, Campana campana) {
        List<Donante> encontrados = new ArrayList<>();
        nombre = nombre.trim().toLowerCase();
        for (Donante donante : campana.getDonantesregistrados()) {
            if (donante.getNombre().toLowerCase().contains(nombre)) {
            encontrados.add(donante);
            }
        }
        return encontrados;
}

    //-----------------------------------------GUARDAR DONANTES EN CSV-----------------------------------------------

    public void guardarDonantesCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("donantes.csv"))) { //CUMPLIENTO SIA 2.8
            pw.println("# RUT,Nombre,TipoSangre");

            for (Donante donante : this.mapaDonantes.values()) {
                pw.println(donante.getRUT() + "," + donante.getNombre() + "," + donante.getTipoSangre());
            }
            System.out.println("Donantes guardados en donantes.csv");
        } catch (IOException e) { //CUMPLIMIENTO SIA 2.8
            System.err.println("Error al guardar en 'donantes.csv': " + e.getMessage());
        }
    }
    //--------------------------------------------GUARDAR CAMPANAS EN CSV----------------------------------------------
    public void guardarCampanasCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("campanas.csv"))) { //-------> CUMPLMIENTO SIA 2.8
            pw.println("# Nombre,Lugar,RUTs_Donantes_Separados_Por_|");

            for (Campana campana : this.listaCampanas) {
                StringBuilder linea = new StringBuilder();
                linea.append(campana.getNombreCampana());
                linea.append(",");
                linea.append(campana.getLugar());

                if (!campana.getDonantesregistrados().isEmpty()) {
                    linea.append(",");
                    List<String> rutsDonantes = new ArrayList<>();
                    for (Donante donante : campana.getDonantesregistrados()) {
                        rutsDonantes.add(String.valueOf(donante.getRUT()));
                    }
                    linea.append(String.join("|", rutsDonantes));
                }
                pw.println(linea.toString());
            }
            System.out.println("Campanas guardadas campanas.csv");
        } catch (IOException e) { // ------------>CUMPLIMIENTO SIA 2.8
            System.err.println("Error al guardar en 'campanas.csv': " + e.getMessage());
        }
    }
    //---------------------------------------------------------------------------------------------------------------
   
    public List<Campana> getListaCampanas() {
        return this.listaCampanas;
    }
    //---------------------------------------------------------------------------------------------------------------
    
    public void agregarDonanteASistema(Donante donante, Campana campana) {
        this.mapaDonantes.put(donante.getRUT(), donante);
        campana.AgregarDonante(donante);
    }
}
