/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clase14agost.EncapsulamientoYHerencia;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lab217-16
 */
public class main {
    public static void main(String args[]) throws IOException{
        Scanner scanner = new Scanner(System.in);
        Auto auto = new Auto();
        System.out.println("Ingrese el numero de chapa");
        String name = scanner.nextLine();
        auto.setChapa(name);
        System.out.println("El numero de chapa es: " + auto.getChapa());
        
    }
}
