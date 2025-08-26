package com.mycompany.siasangre;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Mankeke
 */
public class SistemaGestion {
    private List<Campana> listaCampanas;
    private Map<String, Donante> mapaDonantes;

    public SistemaGestion() {
        this.listaCampanas = new ArrayList<>();
        this.mapaDonantes = new HashMap<>();
    }
    public void cargarDatosCodigo(){

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

        c1.AgregarDonante(d1);
        c1.AgregarDonante(d2);
        c2.AgregarDonante(d3);
        c3.AgregarDonante(d4);
        c3.AgregarDonante(d1);

        listaCampanas.add(c1);
        listaCampanas.add(c2);
        listaCampanas.add(c3);
        
        System.out.println("Donantes y campanas cargadas");
    }
    public void cargarDonantes() {
        try (BufferedReader br = new BufferedReader(new FileReader("donantes.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#") || linea.trim().isEmpty()) continue;
                
                String[] datos = linea.split(",");
                Donante donante = new Donante(datos[0], datos[1], datos[2]);
                mapaDonantes.put(donante.getRUT(), donante);
            }
            System.out.println(mapaDonantes.size() + " donantes cargados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al leer archivo");
        }
    }
    public void cargarCampanas() {
        try (BufferedReader br = new BufferedReader(new FileReader("campanas.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("#") || linea.trim().isEmpty()) continue;

                String[] datos = linea.split(",");
                Campana campana = new Campana(datos[0], datos[1]);
                
                if (datos.length == 3) {
                    String[] rutsDonantes = datos[2].split("\\|");
                    for (String rut : rutsDonantes) {
                        Donante donanteAsignar = mapaDonantes.get(rut.trim());
                        if (donanteAsignar != null) {
                            campana.AgregarDonante(donanteAsignar);
                        } else {
                            System.err.println("No se encontro el donante.");
                        }
                    }
                }
                listaCampanas.add(campana);
            }
            System.out.println(">>> " + listaCampanas.size() + " campanas cargadas exitosamente.");
        } catch (IOException e) {
            System.err.println("!!! Error al leer 'campanas.csv': " + e.getMessage());
        }
    }
    
    public void buscarCampana(String lugar) {
        System.out.println("\nBuscando campanas en el lugar:'" + lugar );
        int encontrada = 0;
        for (Campana campana : listaCampanas) {
            if (campana.getLugar().toLowerCase().contains(lugar.toLowerCase())) {
                System.out.println("Encontrada: " + campana.getNombreCampana() + " en " + campana.getLugar());
                encontrada = 1;
            }
        }
        if (encontrada == 0) {
            System.out.println("No se encontraron en ese lugar.");
        }
    }
    //-------------------------------------Segunda sobreCatga-------------------------------------------------------
    public void buscarCampana(String nombre, String lugar) {
        System.out.println("\nBuscando campanas con el nombre: '" + nombre + "' y lugar: '" + lugar + "' ---");
        int encontrada = 0;
        for (Campana campana : listaCampanas) {
            if (campana.getNombreCampana().equalsIgnoreCase(nombre) && campana.getLugar().equalsIgnoreCase(lugar)) {
                System.out.println("Coincidencia exacta encontrada: " + campana.getNombreCampana());
                encontrada = 1;
            }
        }
        if (encontrada == 0) {
            System.out.println("No se encontraron campanas.");
        }
    }
    //---------------------------------------------------------------------------------------------------------------
    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        if (listaCampanas.isEmpty()){
            System.out.println("!!! No hay campanas cargadas para mostrar. Revisa los archivos .csv.");
            return;
        }

        System.out.println("\nSeleccione una campana para gestionar");
        for (int i = 0; i < listaCampanas.size(); i++) {
            System.out.println((i + 1) + ". " + listaCampanas.get(i).getNombreCampana());
        }

        System.out.print("Ingrese el numero de la campana: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice < 0 || indice >= listaCampanas.size()) {
             System.out.println("Seleccion invalida. Saliendo.");
             scanner.close();
             return;
        }
        
        Campana campanaSeleccionada = listaCampanas.get(indice);
        
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\nMenu Campana: " + campanaSeleccionada.getNombreCampana());
            System.out.println("1. Agregar donante");
            System.out.println("2. Mostrar donantes de la campana");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese RUT del nuevo donante: ");
                    String rut = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Tipo de Sangre: ");
                    String tipoSangre = scanner.nextLine();
                    
                    Donante nuevoDonante = new Donante(rut, nombre, tipoSangre);
                    campanaSeleccionada.AgregarDonante(nuevoDonante);
                    mapaDonantes.put(rut, nuevoDonante);
                    
                    System.out.println("Donante agregado");
                    break;
                case 2:
                    campanaSeleccionada.mostrarDonantes();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }
}
