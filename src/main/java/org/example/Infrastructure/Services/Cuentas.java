package org.example.Infrastructure.Services;

import org.example.Infrastructure.Models.CuentaModels;

import java.util.List;

public class Cuentas {
    Cuentas cuentaDB;
    public Cuentas(String userBD, String passDB, String hostDB, String portDB, String dataBase){
        cuentaDB = new Cuentas(userBD, passDB, hostDB, portDB, dataBase);
    }

    public String RegistrarCuenta(CuentaModels cuenta){
        return cuentaDB.RegistrarCuenta(cuenta);

    }
    public String ModificarCuenta(CuentaModels cuenta){
        return cuentaDB.ModificarCuenta(cuenta);
    }


    public List<Cliente> ConsultarCuenta(CuentaModels id){
        return  cuentaDB.ConsultarCuenta(id);
    }

    public String EliminarCuenta(int id){ return cuentaDB.EliminarCuenta(id);
    }


}