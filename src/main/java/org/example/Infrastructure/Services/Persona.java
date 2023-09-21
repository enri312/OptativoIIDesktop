package org.example.Infrastructure.Services;

import org.example.Infrastructure.Models.PersonaModels;

import java.util.List;

public class Persona {
    Persona personasDB;
    public Persona(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        personasDB = new Persona(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String RegistrarPersona(PersonaModels persona){
        if(validarDatos(persona)){
            return personasDB.RegistrarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String ModificarPersona(PersonaModels persona){
        if(validarDatos(persona)){
            return personasDB.ModificarPersona(persona);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public List<Persona> ConsultarPersona(int id){
        return  personasDB.ConsultarPersona(id);
    }

    public String EliminarPersona(PersonaModels id){
        return personasDB.EliminarPersona(id);
    }

    private boolean validarDatos(PersonaModels persona) {
        try {
            if(persona.Nombre.trim().isEmpty())
                throw new Exception("El nombre no debe estar vacío");
            else if (persona.Nombre.trim().length() < 3) {
                throw new Exception("El nombre no tiene la longitud necesaria");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}