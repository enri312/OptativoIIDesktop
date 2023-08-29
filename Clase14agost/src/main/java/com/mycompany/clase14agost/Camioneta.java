/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase14agost;

/**
 *
 * @author lab217-16
 */
public class Camioneta {

    @Override
    public String toString() {
        return "Camioneta{" + "Marca=" + Marca + ", Modelo=" + Modelo + ", A\u00f1o=" + Año + ", Color=" + Color + '}';
    }
    private String Marca ;
    private String Modelo;
    public int Año;
    private String Color;
    private int Velocidad;
    

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }

    public int getVelocidad() {
        return Velocidad;
    }

public Camioneta (String Marca, String Modelo, int Año, String Color, int Velocidad){
this.Marca = Marca;
this.Modelo = Modelo;
this.Año = Año;
this.Color = Color;
this.Velocidad = Velocidad;
}

    Camioneta() {      
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public int getAño() {
        return Año;
    }

    public String getColor() {
        return Color;
    }
    public String acelerar (int velocidad)
    {
                this.Velocidad + = velocidad;
        if (this.Velocidad > 180){
            return "ya no puede acelerar, ya supera el limite";
        }
        return "La velocidad ahora es " + this.Velocidad;
        }
    public String  frenar (int velocidad);
    this.Velocidad -= veolocidad;
    if (this.velocidad <= 0) {
    return "Ya no puede frenar, ya se detuvo";
}
    
}


