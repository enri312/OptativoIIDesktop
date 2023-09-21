package org.example.Infrastructure.Services;

import org.example.Infrastructure.Models.CiudadModels;

import java.util.List;

public class Ciudad {
    Ciudad ciudadDB;
    public Ciudad(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        ciudadDB = new Ciudad(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCiudad(CiudadModels ciudad){
        if(validarDatos(ciudad)){
            return ciudadDB.registrarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }

    public String modificarCiudad(CiudadModels ciudad){
        if(validarDatos(ciudad)){
            return ciudadDB.modificarCiudad(ciudad);
        }
        return "Ocurrió algún error, contactese con el Administrador";
    }


    public List<Ciudad> consultarCiudad(){
        return  ciudadDB.consultarCiudad();
    }

    public CiudadModels eliminarCiudad(CiudadModels id){
        return ciudadDB.eliminarCiudad(id);
    }

    private boolean validarDatos(CiudadModels ciudad) {
        try {
            if(ciudad.Ciudad.trim().isEmpty())
                throw new Exception("El nombre no debe estar vacío");
            else if (ciudad.Ciudad.trim().length() < 3) {
                throw new Exception("El nombre no tiene la longitud necesaria");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}

