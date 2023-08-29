/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package optativo2desktop;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Optativo2Desktop {
    private static String userDB = "postgres";
    private static String passDB = "Alumno2023";
    private static String portDB = "5432";
    private static String dataBase = "postgres";
    
    private static String url = "jdbc:postgresql://localhost:5432/"+dataBase;
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, userDB, passDB);
        } catch (SQLException ex) {
            Logger.getLogger(Optativo2Desktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
