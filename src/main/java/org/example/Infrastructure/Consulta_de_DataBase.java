
package org.example.Infrastructure;

import org.example.Infrastructure.DbManagment.Contactos.Persona;
import org.example.Infrastructure.Models.PersonaModels;
import java.util.List;


public class Consulta_de_DataBase {

    public static void main(String[] args) {
        Persona personas = new Persona("postgres", "12345", "localhost", "5432", "postgres");
        // este bloque de codigo ingresa un registro nuevo en la tabla personas

        PersonaModels persona1 = new PersonaModels();
        persona1.IdCiudad = 1;
        persona1.Nombre = "Juan";
        persona1.Apellido = "Lopez";
        persona1.TipoDocumento = "CI";
        persona1.NroDocumento = "5729790";
        persona1.Direccion = "Avda Von Grutter";
        persona1.Celular = "0994114188";
        persona1.Email = "josespelt6@gmail.com";
        persona1.Estado = "Soltero";
        personas.RegistrarPersona(persona1);

        // este bloque del codigo realiza la consulta a la base de datos y trae los datos de la tabla personas
        List<PersonaModels> listaPersonas = personas.ConsultarPersona();
        for (PersonaModels persona : listaPersonas) {

            System.out.println("idCiudad: " + persona.getId_ciudad());
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());

        }

        // este bloque del codigo realiza una modificacion en la tabla personas de la base de datos

        PersonaModels persona2 = new PersonaModels();
        persona2.Nombre = "Jose";
        persona2.Apellido = "Spelt";
        persona2.TipoDocumento = "CI";
        persona2.NroDocumento = "5729790";
        persona2.Direccion = "Avda Von Grutter";
        persona2.Celular = "09941141128";
        persona2.Email = "josespelt6@gmail.com";
        persona2.Estado = "Soltero";
        personas.ModificarPersona(persona2);

        // este bloque de codigo realiza un delete en la base de datos de la tabla personas
        int id_persona = 1;
        String resultado = personas.EliminarPersona(id_persona);
        System.out.println(resultado);
    }
}




