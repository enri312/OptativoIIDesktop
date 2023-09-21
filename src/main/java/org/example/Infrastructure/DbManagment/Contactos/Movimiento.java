package org.example.Infrastructure.DbManagment.Contactos;

import org.example.Infrastructure.Conexion.Conexiones;
import org.example.Infrastructure.Models.CuentaModels;
import org.example.Infrastructure.Models.MovimientoModels;

import java.sql.SQLException;
public class Movimiento {
    private Conexiones conexion;

    public Movimiento(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        conexion = new Conexiones(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String RegistrarMovimiento(MovimientoModels movimiento){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("INSERT INTO movimiento(" +
                    "'IdCuenta', " +
                    "'FechaMovimiento', " +
                    "'TipoMovimiento', " +
                    "'SaldoAnterior'," +
                    "'SaldoActual', " +
                    "'MontoMovimiento', " +
                    "'CuentaOrigen', " +
                    "'CuentaDestino'," +
                    "'Canal') " +
                    "values('" +
                    movimiento.IdMovimiento + "', '" +
                    movimiento.IdCuenta + "', '" +
                    movimiento.FechaMovimiento + "', '" +
                    movimiento.TipoMovimento + "', '" +
                    movimiento.SaldoAnterior + "', '" +
                    movimiento.SaldoActual + "', '" +
                    movimiento.MontoMovimiento + "', '" +
                    movimiento.CuentaOrigen + "', '" +
                    movimiento.CuentaDestino + "', '" +
                    movimiento.Canal + "'))");
            conexion.connexionDB().close();
            return "El movimiento " + movimiento.IdMovimiento + " fue registrado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String ModificarMovimiento(MovimientoModels movimiento){

        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            boolean execute = conexion.getQuerySQL().execute("UPDATE movmiento SET " +
                    "IdCuenta = '" + movimiento.IdCuenta + "'," +
                    "FechaMovimiento = '" + movimiento.FechaMovimiento + "'," +
                    "TipoMovimiento = '" + movimiento.TipoMovimento + "'," +
                    "SaldoAnterior = '" + movimiento.SaldoAnterior + "'," +
                    "SaldoActual = '" + movimiento.SaldoActual + "'," +
                    "MontoMovimiento = '" + movimiento.MontoMovimiento + "'," +
                    "CuentaOrigen = '" + movimiento.CuentaOrigen + "'," +
                    "CuentaDestino = '" + movimiento.CuentaDestino + "'," +
                    "Canal = '" + movimiento.Canal + "' Where IdMovimiento = " + movimiento.IdMovimiento);
            conexion.connexionDB().close();
            return "El movimiento " + movimiento.IdMovimiento + " fue modificado correctamente!!!";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MovimientoModels ConsultarMovimiento(int idMovimiento){
        MovimientoModels movimiento = new MovimientoModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());
            conexion.setResultadoQuery(conexion.getQuerySQL().executeQuery("Select * from Movimiento where Id = " + idMovimiento));
            if(conexion.getResultadoQuery().next()){
                movimiento.IdCuenta = conexion.getResultadoQuery().getInt("IdCuenta");
                movimiento.FechaMovimiento = conexion.getResultadoQuery().getDate("FechaMovimiento");
                movimiento.TipoMovimento = conexion.getResultadoQuery().getString("TipoMovimiento");
                movimiento.SaldoAnterior = conexion.getResultadoQuery().getDouble("SaldoAnterior");
                movimiento.MontoMovimiento = conexion.getResultadoQuery().getDouble("MontoMovimiento");
                movimiento.CuentaOrigen = conexion.getResultadoQuery().getDouble("CuentaOrigen");
                movimiento.CuentaDestino = conexion.getResultadoQuery().getDouble("CuentaDestino");
                movimiento.Canal = conexion.getResultadoQuery().getDouble("Canal");

                return movimiento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public String EliminarMovimiento(MovimientoModels idMovimiento){
        MovimientoModels cuenta = new MovimientoModels();
        try {
            conexion.setQuerySQL(conexion.connexionDB().createStatement());

            int rowCount = conexion.getQuerySQL().executeUpdate("DELETE FROM movimientos WHERE id = " + idMovimiento);
            conexion.connexionDB().close();

            if (rowCount > 0) {
                return "El movimiento con ID " + idMovimiento + " ha sido eliminada correctamente.";
            } else {
                return "No se encontró ningún movimiento con ID " + idMovimiento+ ". No se realizó ninguna eliminación.";
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
