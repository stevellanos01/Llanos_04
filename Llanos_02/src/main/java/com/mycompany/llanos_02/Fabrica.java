/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llanos_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Fabrica {

    private ArrayList<Polera> poleras = new ArrayList<>();

    /**
     * Metodo fabrica es el constructor de la clase Fabrica que se encarga de
     * ejecutar de manera secuencial los metodos pertenecientes a la clase.
     *
     * @param ruta : ubicacion del archivo que se utilizara
     */
    public void fabrica(String ruta) {
        mostrarContenidoArchivo(ruta);
        String info = leerArchivo(ruta);
        String[] datos = obtenerDatos(info);
        crearPolera(datos);
        mostarPoleras();
        //crearNuevaPolera(ruta ,"algodon", "XL" , "false");
    }

    /**
     * Metodo mostrarContenidoArchivo muestra por consola el texto contenidos en
     * el archivo.
     *
     * @param ruta : ruta de donde se encuentra el archivo
     * @return : retorna el texto contenido en el archivo
     */
    public String mostrarContenidoArchivo(String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es: ");
            System.out.println("");
            System.out.println(texto);
            System.out.println("\n");

        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
            System.out.println("");
        }
        return texto;
    }

    /**
     * Metodo leerArchivo solo lee y retorna el texto contenido en el archivo,
     * pero no lo muestra por consola.
     *
     * @param ruta : ruta de donde se encuentra el archivo
     * @return : retorna el texto contenido por el archivo
     */
    public String leerArchivo(String ruta) {
        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
            System.out.println("");
        }
        return texto;
    }

    /**
     * metodo obtenerDatos se encarga de deserializar el texto contenido en el
     * archivo que anteriormente fue leido, eliminando las comas " , " y los
     * saltos de linea " \n ", para posteriormente almacenar los datos en un
     * arreglo de String.
     *
     * @param info : texto contenido en el archivo que sera deserializado.
     * @return : retorna el arreglo que contendra los datos que posteriormente
     * se utilizaran para crear objetos.
     */
    public String[] obtenerDatos(String info) {
        String[] arreglo = info.split("(\\,|\\\n)");
        //mostrar arreglo
        /*
        for (int b = 0; b < arreglo.length; b++) {
            System.out.print(" " + arreglo[b] + " " );
        }
         */
        return arreglo;
    }

    /**
     * Metodo crearPolera crea objetos tipo Polera con los datos contenidos en
     * el arreglo. estos objetos seran almacenados en el ArrayList poleras.
     *
     * @param arreglo : arreglo que contiene los datos para crear cada objeto.
     *
     */
    public void crearPolera(String[] arreglo) {
        int n = 3;
        int c = arreglo.length / 3 - 1;
        for (int i = 0; i < c; i++) {
            String material = arreglo[n++];
            String talla = arreglo[n++];
            String estampado = arreglo[n++];
            poleras.add(new Polera(material, talla, estampado));
        }
    }

    /**
     * Metodo crearNuevaPolera crea un nuevo objeto tipo Polera con los
     * parametros de entrada. Al crear el nuevo objeto inmediatamente se
     * actualiza el archivo, agregando una nueva linea con la informacion del
     * objeto creado
     *
     * @param material
     * @param talla
     * @param estampado
     */
    public void crearNuevaPolera(String ruta, String material, String talla, String estampado) {
        poleras.add(new Polera(material, talla, estampado));
        String linea = material + "," + talla + "," + estampado;
        //String ruta = "listado.csv";
        actualizarArchivo(ruta, linea);
    }

    /**
     * Metodo mostrarPoleras muestra por consola el contenido de el ArrayList
     * poleras, que almacena los objetos tipo Polera, mostrando los atributos de
     * cada uno, es decir el Material, Talla y Estampado pertenecientes a cada
     * objeto.
     */
    public void mostarPoleras() {
        for (int i = 0; i < poleras.size(); i++) {
            System.out.println("Polera " + (i + 1));
            System.out.println("Material: " + poleras.get(i).getMaterial());
            System.out.println("Talla: " + poleras.get(i).getTalla());
            System.out.println("Estampado: " + poleras.get(i).getEstampado());
            System.out.println();
        }
    }

    /**
     * Metodo actualizarArchivo se encarga de actualizar el archivo con una
     * nueva linea de texto, que tendra la informacion o las caracteristicas del
     * nuevo objeto Polera creado.
     *
     * @param ruta : ruta de el archivo a actualizar
     * @param nuevaLinea : linea de texto a agregar al archivo
     * @return
     */
    public String actualizarArchivo(String ruta, String nuevaLinea) {

        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));  //TEXTO CONTENIDO EN EL ARCHIVO EXISTENTE
            texto = texto + "\n" + nuevaLinea;

            Files.write(archivo, texto.getBytes());
            System.out.println("Se ha actualizado el archivo");
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo");
        }
        mostrarContenidoArchivo(ruta);
        return texto;
    }
}
