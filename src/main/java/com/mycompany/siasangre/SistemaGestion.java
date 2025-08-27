package com.mycompany.siasangre;
//Commit NetBeans
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
    
    //-----------------------------------------sobreCatga-----------------------------------------------------------
    public List<Campana> buscarCampana(String lugar) {
        List<Campana> encontrados = new ArrayList<>();
        for (Campana campana : listaCampanas) {
            if (campana.getLugar().toLowerCase().contains(lugar.toLowerCase())) {
               encontrados.add(campana);
            }
        }
        return encontrados;
    }
    //-------------------------------------Segunda sobreCatga-------------------------------------------------------
    public  List<Campana> buscarCampana(String nombre, String lugar) {
        List<Campana> encontrados = new ArrayList<>();
        for (Campana campana : listaCampanas) {
            if (campana.getNombreCampana().equalsIgnoreCase(nombre) && campana.getLugar().equalsIgnoreCase(lugar)) {
                if (campana.getNombreCampana().equalsIgnoreCase(nombre) && campana.getLugar().equalsIgnoreCase(lugar)) {
                encontrados.add(campana);
                }             
            }
        }
        return encontrados;
    }
    //---------------------------------------------------------------------------------------------------------------
    
    private void MenuGestionDonante(Scanner scanner, Campana campana){   
        int opcionGestion = 0;
        while (opcionGestion != 3) {
            System.out.println("\n--- Menu Gestion: " + campana.getNombreCampana() + " ---");
            System.out.println("1. Agregar donante");
            System.out.println("2. Mostrar donantes de la campana");
            System.out.println("3. Volver al menu principal");
            System.out.print("Elija una opcion: ");
            opcionGestion = scanner.nextInt();
            scanner.nextLine();

            switch (opcionGestion) {
                case 1:
                    System.out.print("Ingrese RUT del nuevo donante: ");
                    String rut = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Tipo de Sangre: ");
                    String tipoSangre = scanner.nextLine();
                    
                    campana.agregarDonante(rut, nombre, tipoSangre);
                    mapaDonantes.put(rut, new Donante(rut, nombre, tipoSangre));
                    
                    System.out.println("Donante agregado");
                    break;
                case 2:
                    campana.mostrarDonantes();
                    break;
                case 3:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
    
    private void SeleccionyGestionCampana(Scanner scanner, List<Campana> listaDeCampanas){
        if (listaDeCampanas.isEmpty()){
            System.out.println("\nNo hay campanas que coincidan.");
            return;
        }

        System.out.println("\n----SELECCIONE CAMPANA----");
        for (int i = 0; i < listaDeCampanas.size(); i++) {
            System.out.println((i + 1) + ". " + listaDeCampanas.get(i).getNombreCampana() + " (" + listaDeCampanas.get(i).getLugar() + ")");
        }

        System.out.print("Ingrese el numero de la campana o 0 para volver : ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice == -1) {
            return; 
        }
        
        if (indice < 0 || indice >= listaDeCampanas.size()) {
             System.out.println("Seleccion invalida. Volviendo al menu principal.");
             return;
        }
        
        
        Campana campanaSeleccionada = listaDeCampanas.get(indice);
        
        MenuGestionDonante(scanner, campanaSeleccionada);
    }
    
    private void menuBuscarCampana(Scanner scanner) {
        System.out.println("\n------BUSCAR CAMPANA------");
        System.out.println("1. Buscar por lugar");
        System.out.println("2. Buscar por nombre y lugar");
        System.out.print("Elija una opcion de busqueda: ");
        int opcionBusqueda = scanner.nextInt();
        scanner.nextLine(); 
        
        List<Campana> resultados = new ArrayList<>();
        String lugar;
        String nombre;
       
        switch (opcionBusqueda) {
            case 1:
                System.out.print("Ingrese el lugar a buscar: ");
                lugar = scanner.nextLine();
                // ---------------Utilizacion de sobrecarga-----------------
                resultados = buscarCampana(lugar);
                //----------------------------------------------------------
                break;
            case 2:  
                System.out.print("Ingrese el nombre de la campana a buscar: ");
                nombre = scanner.nextLine();
                System.out.print("Ingrese el lugar a buscar: ");
                lugar = scanner.nextLine();
                // ---------------Utilizacion de sobrecarga-----------------
                resultados = buscarCampana(nombre,lugar);
                //----------------------------------------------------------
                break;
            default:
                System.out.println("Opcion de busqueda no valida.");
                break;
        }
        SeleccionyGestionCampana(scanner, resultados);
    }
    
    public void iniciarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in); 
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("\n--------MENU PRINCIPAL--------");
            System.out.println("1. Gestionar una Campana");
            System.out.println("2. Buscar Campana y Gestionar");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    SeleccionyGestionCampana(scanner, this.listaCampanas);
                    break;
                case 2:
                    menuBuscarCampana(scanner);
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
