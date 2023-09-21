package org.example.Infrastructure.DbManagment.Contactos;

import org.example.Infrastructure.Conexion.Conexiones;
import org.example.Infrastructure.Models.CiudadModels;
import org.example.Infrastructure.Models.ClienteModels;

import java.sql.SQLException;
public class Cliente {
    private Conexiones conexion;
    public Cliente(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String registrarCliente(ClienteModels cliente){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cliente(" +
                    "'IdPersona', " +
                    "'FechaIngreso', " +
                    "'Calificacion', " +
                    "'Estado') " +
                    "values('" +
                    cliente.IdCliente + "', '" +
                    cliente.IdPersona + "', '" +
                    cliente.FechaIngreso + "', '" +
                    cliente.Calificacion + "', '" +
                    cliente.Estado +  "'))");
            conexion.connexionDB().close();
            return "El cliente " + cliente.IdCliente + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String ModificarCliente(ClienteModels cliente){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE ciudad SET " +
                    "IdPersona = '" + cliente.IdPersona + "'," +
                    "FechaIngreso = '" + cliente.FechaIngreso + "'," +
                    "Calficacion = '" + cliente.Calificacion + "'," +
                    "Estado = '" + cliente.Estado + "'," +
                    "' Where cliente.idCliente = " + cliente.IdCliente);
            conexion.connexionDB().close();
            return "El cliente " + cliente.IdCliente + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClienteModels ConsultarCliente(int IdCliente){
        ClienteModels cliente = new ClienteModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from cliente where IdCliente = " + IdCliente));
            if(conexion.getResultadoQuery().next()){
                cliente.IdPersona = conexion.getResultadoQuery().getInt("IdPersona");
                cliente.FechaIngreso = conexion.getResultadoQuery().getDate("IdPersona");
                cliente.Calificacion = conexion.getResultadoQuery().getString("IdPersona");
                cliente.Estado = conexion.getResultadoQuery().getString("IdPersona");

                return cliente;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String EliminarCliente(ClienteModels idCliente){
        ClienteModels cliente = new ClienteModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());

            int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cliente WHERE idCliente = " + idCliente);
            conexion.connexionDB().close();

            if (rowCount > 0) {
                return "El cliente con ID " + idCliente + " ha sido eliminado correctamente.";
            } else {
                return "No se encontró ningún cliente con ID " + idCliente+ ". No se realizó ninguna eliminación.";
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
