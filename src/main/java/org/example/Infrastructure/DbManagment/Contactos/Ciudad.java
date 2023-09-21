package org.example.Infrastructure.DbManagment.Contactos;

import org.example.Infrastructure.Conexion.Conexiones;
import org.example.Infrastructure.Models.CiudadModels;
import org.example.Infrastructure.Models.PersonaModels;

import java.sql.SQLException;
public class Ciudad {
    private Conexiones conexion;

    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModels ciudad){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO ciudad(" +
                    "'Id', " +
                    "'Ciudad', " +
                    "'Departamento', " +
                    "'PostalCOde') " +
                    "values('" +
                    ciudad.Id + "', '" +
                    ciudad.Ciudad + "', '" +
                    ciudad.Departamento + "', '" +
                    ciudad.PostalCode +  "'))");
            conexion.connexionDB().close();
            return "La ciudad " + ciudad.Ciudad + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String modificarCiudad(CiudadModels ciudad){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "Id' = '" + ciudad.Id + "'," +
                    "Ciudad = '" + ciudad.Ciudad + "'," +
                    "Departamento = '" + ciudad.Departamento + "'," +
                    "PostalCode = '" + ciudad.PostalCode + "'," +
                    "' Where ciudad.id = " + ciudad.Id);
            conexion.connexionDB().close();
            return "La ciudad " + ciudad.Ciudad + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CiudadModels consultarCiudad(int id){
        CiudadModels ciudad = new CiudadModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from ciudad where Id = " + id));
            if(conexion.getResultadoQuery().next()){
                ciudad.Ciudad = conexion.getResultadoQuery().getString("ciudad");
                ciudad.Departamento = conexion.getResultadoQuery().getString("departamento");
                ciudad.PostalCode = conexion.getResultadoQuery().getInt("PostalCOde");

                return ciudad;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String EliminarCiudad(CiudadModels id){
        CiudadModels ciudad = new CiudadModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());

            int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM ciudad WHERE id = " + id);
            conexion.connexionDB().close();

            if (rowCount > 0) {
                return "La ciudad con ID " + id + " ha sido eliminada correctamente.";
            } else {
                return "No se encontró ninguna ciudad con ID " + id+ ". No se realizó ninguna eliminación.";
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
