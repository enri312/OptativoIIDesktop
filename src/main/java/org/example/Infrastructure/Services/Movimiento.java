package org.example.Infrastructure.Services;

import org.example.Infrastructure.Models.MovimientoModels;

import java.util.List;

public class Movimiento {
    Movimiento movimientoDB;
    public Movimiento(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        movimientoDB = new Movimiento(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String RegistrarMovimiento(MovimientoModels movimiento){
        return movimientoDB.RegistrarMovimiento(movimiento);

    }
    public String ModificarMovimiento(MovimientoModels movimiento){
        return movimientoDB.ModificarMovimiento(movimiento);
    }

    public List<Movimiento> ConsultarMovimiento(int idMovimiento){
        return  movimientoDB.ConsultarMovimiento(idMovimiento);
    }

    public String EliminarMovimiento(MovimientoModels idMovimiento){
        return movimientoDB.EliminarMovimiento(idMovimiento);
    }

}