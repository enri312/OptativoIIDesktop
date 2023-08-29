/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase14agost.EncapsulamientoYHerencia;

/**
 *
 * @author lab217-16
 */
public class Vehiculo {
    private String color;
    private String chapa;
    private String modelo;
    private int año;
    private String trasmision;

    public String getColor() {

      return color;  
   
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTrasmision() {
        return trasmision;
    }

    public void setTrasmision(String trasmision) {
        this.trasmision = trasmision;
    }
    
    
    
    public int acelerar(int velocidadActual){
    
     return 0;
    }
    
}
