package org.example.Infrastructure.DbManagment.Contactos;

import org.example.Infrastructure.Conexion.Conexiones;
import org.example.Infrastructure.Models.PersonaModels;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persona {


    private Conexiones conexion;

    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String RegistrarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO personas(" +
                    "'idCiudad', " +
                    "'Nombre', " +
                    "'Apellido', " +
                    "'TipoDocumento'," +
                    "'NroDocumento', " +
                    "'Direccion', " +
                    "'celular', " +
                    "'email'," +
                    "'Estado') " +
                    "values('" +
                    persona.Id + "', '" +
                    persona.IdCiudad + "', '" +
                    persona.Nombre + "', '" +
                    persona.Apellido + "', '" +
                    persona.TipoDocumento + "', '" +
                    persona.NroDocumento + "', '" +
                    persona.Direccion + "', '" +
                    persona.Celular + "', '" +
                    persona.Email + "', '" +
                    persona.Estado + "'))");
            conexion.connexionDB().close();
            return "La persona " + persona.Nombre + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String ModificarPersona(PersonaModels persona){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE personas SET " +
                    "idCiudad = '" + persona.IdCiudad + "'," +
                    "Nombre = '" + persona.Nombre + "'," +
                    "Apellido = '" + persona.Apellido + "'," +
                    "TipoDocumento = '" + persona.TipoDocumento + "'," +
                    "NroDocumento = '" + persona.NroDocumento + "'," +
                    "Direccion = '" + persona.Direccion + "'," +
                    "celular = '" + persona.Celular + "'," +
                    "email = '" + persona.Email + "'," +
                    "Estado = '" + persona.Estado + "' Where personas.id = " + persona.Id);
            conexion.connexionDB().close();
            return "Los datos de la persona " + persona.Nombre + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonaModels ConsultarPersona(int id){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from persona where Id = " + id));
            if(conexion.getResultadoQuery().next()){
                persona.IdCiudad = conexion.getResultadoQuery().getInt("idCiudad");
                persona.Nombre = conexion.getResultadoQuery().getString("Nombre");
                persona.Apellido = conexion.getResultadoQuery().getString("Apellido");
                persona.TipoDocumento = conexion.getResultadoQuery().getString("TipoDocumento");
                persona.NroDocumento = conexion.getResultadoQuery().getString("NroDocumento");
                persona.Direccion = conexion.getResultadoQuery().getString("Direccion");
                persona.Celular = conexion.getResultadoQuery().getString("celular");
                persona.Email = conexion.getResultadoQuery().getString("email");
                persona.Estado = conexion.getResultadoQuery().getString("Estado");

                return persona;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<PersonaModels> ConsultarPersona() {

        List<PersonaModels> personas = new ArrayList<>();

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("SELECT * FROM personas"));

            while (conexion.getResultadoQuery().next()) {
                PersonaModels persona = new PersonaModels();
                persona.Nombre = conexion.getResultadoQuery().getString("nombre");
                persona.Apellido = conexion.getResultadoQuery().getString("apellido");
                persona.TipoDocumento = conexion.getResultadoQuery().getString("tipo_documento");
                persona.NroDocumento = conexion.getResultadoQuery().getString("nro_documento");
                persona.Direccion = conexion.getResultadoQuery().getString("direccion");
                persona.Celular = conexion.getResultadoQuery().getString("celular");
                persona.Email = conexion.getResultadoQuery().getString("email");
                persona.Estado = conexion.getResultadoQuery().getString("estado");
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personas;
    }

    public  String EliminarPersona(int id){
        PersonaModels persona = new PersonaModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());

            int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM persona WHERE id = " + id);
            conexion.connexionDB().close();

            if (rowCount > 0) {
                return "La persona con ID " + id + " ha sido eliminada correctamente.";
            } else {
                return "No se encontró ninguna persona con ID " + id+ ". No se realizó ninguna eliminación.";
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
