package org.example.Infrastructure.DbManagment.Contactos;

import org.example.Infrastructure.Conexion.Conexiones;
import org.example.Infrastructure.Models.CiudadModels;
import org.example.Infrastructure.Models.CuentaModels;


import java.sql.SQLException;

public class Cuentas {
    private Conexiones conexion;

    public Cuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String RegistrarCuenta(CuentaModels cuenta){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO cuentas(" +
                    "'IdCliente', " +
                    "'NroCuenta', " +
                    "'FechaAlta', " +
                    "'TipoCuenta'," +
                    "'Estado', " +
                    "'Saldo', " +
                    "'nroContrato', " +
                    "'CostoMantenimiento'," +
                    "'PromedioAcreditacion'," +
                    "'Moneda') " +
                    "values('" +
                    cuenta.Id + "', '" +
                    cuenta.IdCliente + "', '" +
                    cuenta.NroCuenta + "', '" +
                    cuenta.FechaAlta + "', '" +
                    cuenta.TipoCuenta + "', '" +
                    cuenta.Estado + "', '" +
                    cuenta.Saldo + "', '" +
                    cuenta.nroContrato + "', '" +
                    cuenta.CostoMantenimiento + "', '" +
                    cuenta.PromedioAcreditacion + "', '" +
                    cuenta.Moneda + "'))");
            conexion.connexionDB().close();
            return "Los datos de la  cuenta " + cuenta.NroCuenta + " fueron registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String ModificarCuenta(CuentaModels cuenta){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE cuenta SET " +
                    "idCliente = '" + cuenta.IdCliente + "'," +
                    "NroCuenta = '" + cuenta.NroCuenta + "'," +
                    "FechaAlta = '" + cuenta.FechaAlta + "'," +
                    "TipoCuenta = '" + cuenta.TipoCuenta + "'," +
                    "Estado = '" + cuenta.Estado + "'," +
                    "Saldo = '" + cuenta.Saldo + "'," +
                    "nroContrato = '" + cuenta.nroContrato + "'," +
                    "CostoMantenimiento = '" + cuenta.CostoMantenimiento + "'," +
                    "PromedioAcreditacion = '" + cuenta.PromedioAcreditacion + "'," +
                    "Moneda = '" + cuenta.Moneda + "' Where cuenta.Id = " + cuenta.Id);
            conexion.connexionDB().close();
            return "Los datos de la cuenta " + cuenta.NroCuenta + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CuentaModels ConsultarCuenta(int id){
        CuentaModels cuenta = new CuentaModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from Cuentas where Id = " + id));
            if(conexion.getResultadoQuery().next()){
                cuenta.IdCliente = conexion.getResultadoQuery().getInt("idCliente");
                cuenta.NroCuenta = conexion.getResultadoQuery().getString("NroCuenta");
                cuenta.FechaAlta = conexion.getResultadoQuery().getDate("FechaAlta");
                cuenta.TipoCuenta = conexion.getResultadoQuery().getString("TipoCuenta");
                cuenta.Estado = conexion.getResultadoQuery().getString("Estado");
                cuenta.Saldo = conexion.getResultadoQuery().getDouble("Saldo");
                cuenta.nroContrato = conexion.getResultadoQuery().getDouble("nroContrato");
                cuenta.CostoMantenimiento = conexion.getResultadoQuery().getDouble("CostoMantenimiento");
                cuenta.PromedioAcreditacion = conexion.getResultadoQuery().getString("PromedioAcreditacion");
                cuenta.Moneda = conexion.getResultadoQuery().getString("Moneda");

                return cuenta;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String EliminarCuenta(CuentaModels id){
        CuentaModels cuenta = new CuentaModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());

            int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM cuentas WHERE id = " + id);
            conexion.connexionDB().close();

            if (rowCount > 0) {
                return "La cuenta con ID " + id + " ha sido eliminada correctamente.";
            } else {
                return "No se encontró ninguna cuenta con ID " + id+ ". No se realizó ninguna eliminación.";
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
