/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.*;



/**
 *
 * @author Esteban
 */
public class Archivos {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\Esteban\\Documents\\NetBeansProjects\\Archivos\\texto.txt" ;
        String linea = "The first man who stepped on the moon.";
        leerArchivo2(ruta);
        actualizarArchivo2(ruta,linea);
        //menu();
    }

    public static int validar() {                 //VALIDACION DE ENTRADA POR TECLADO
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        try {
            opcion = teclado.nextInt();
            return opcion;
        } catch (Exception e) {
            System.out.println("ERROR!!");
            return -1;
        }
    }

    public static void menu() {                 //MENU DEL PROGRAMA
        System.out.println("      // MENU: //   ");
        System.out.println("Selecciona la operacion a realizar");
        System.out.println("1 - Leer archivo");
        System.out.println("2 - Agregar lineas al archivo");
        System.out.println("3 - Salir");
        System.out.println("");
        int opcion = 0;
        //VALIDACION DE ENTRADA DE LA OPCION
        while (opcion < 1 || opcion > 3) {
            opcion = validar();
            if (opcion >= 1 && opcion <= 3) {
                seleccion(opcion);
            }
        }
        System.out.println("");
    }

    public static void seleccion(int op) {
        switch (op) {
            case 1:
                leerArchivo();
                break;
            case 2:
                actualizarArchivo();               
                break;
            case 3:
                System.out.println("");
                break;
        }
    }



//METODOS PARA RUTA DE ARCHIVO INGRESADA POR EL USUARIO
    public static void leerArchivo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta completa del archivo");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es: ");
            System.out.println("");
            System.out.println(texto);
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
            System.out.println("");
        }
        menu();
    }

    
    public static void actualizarArchivo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta completa del archivo");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        String texto1 = "";     //TEXTO CONTENIDO EN EL ARCHIVO EXISTENTE
        String linea;           //TEXTO A AGREGAR AL ARCHIVO
        try{
            System.out.println("Ingrese el texto a agregar");    
            texto1 = new String(Files.readAllBytes(archivo));
            linea = teclado.nextLine();
            texto1 = texto1 + "\n" + linea;
                
            Files.write(archivo,texto1.getBytes());
            System.out.println("Se ha guardado el archivo");
        } catch (IOException e){
                System.out.println("No se puede leer el archivo");
        }
        menu();
    }

//METODOS PARA TEST

     public static String leerArchivo2(String ruta) { 
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es: ");
            System.out.println("");
            System.out.println(texto);
            
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
            System.out.println("");
        }
        return texto;
    }   
     
    public static String actualizarArchivo2(String ruta, String nuevaLinea){
        
        Path archivo = Paths.get(ruta);
        String texto = "";     
        try{   
            texto = new String(Files.readAllBytes(archivo));  //TEXTO CONTENIDO EN EL ARCHIVO EXISTENTE
            texto = texto + "\n" + nuevaLinea;
                
            Files.write(archivo,texto.getBytes());
            System.out.println("Se ha actualizado el archivo");
        } catch (IOException e){
                System.out.println("No se puede leer el archivo");
        }
        leerArchivo2(ruta);
        return texto;
    } 
    
    
   
}


    
    

