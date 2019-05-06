/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.llanos_02;

/**
 *
 * @author Esteban
 */
public class Principal {
    public static void main(String []args){
        Fabrica f = new Fabrica();
        String ruta = "listado.csv";
        f.fabrica(ruta);
    }
}
