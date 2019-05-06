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
public class Polera {
    
    private String material;
    private String talla;
    private String estampado;
    
    /*
    * constructor de la clase Polera
    */
    
    public Polera( String material, String talla, String estampado){
        this.material = material;
        this.talla = talla;
        this.estampado = estampado;
    }
    
    public void setMaterial(String material){
        this.material = material;
    }
    
    public String getMaterial(){
        return material;
    }
    
    public void setTalla(String talla){
        this.talla = talla;
    }
    
    public String getTalla(){
        return talla;
    }
    
    public void setEstampado(String estampado){
        this.estampado = estampado;
    }
    
    public String getEstampado(){
        return estampado;
    }
    
}
