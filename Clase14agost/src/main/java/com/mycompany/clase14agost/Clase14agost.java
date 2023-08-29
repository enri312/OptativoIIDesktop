/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.clase14agost;

/**
 *
 * @author lab217-16
 */
public class Clase14agost {

    public static void main(String[] args) {
        Camioneta camioneta1 = new Camioneta
        ("Mercedes Benz", "C220 CD", 2009, "Plateado");
        System.out.println(camioneta1.toString());
        
        Camioneta camioneta2 = new Camioneta();
        camioneta2.setMarca("BMW");
        camioneta2.setModelo("X6");
        camioneta2.setAño(2015);
        camioneta2.setColor("Negro");
        System.out.println(camioneta2.toString());

    }
}
