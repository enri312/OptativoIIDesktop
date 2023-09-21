package org.example.Infrastructure.Models;

public class CiudadModels {


    public int Id;
    public String Ciudad;
    public String Departamento;
    public int PostalCode;

    public int getId_ciudad() {
        return Id;
    }

    public void setId_ciudad(int id_ciudad) {
        this.Id = id_ciudad;
    }

    public String getNombreCiudad() {
        return Ciudad;
    }

    public void setNombreCiudad(String NombreCiudad) {
        this.Ciudad = NombreCiudad;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public int getCodigoPostal() {
        return PostalCode;
    }

    public void setCodigoPostal(int CodigoPostal) {
        this.PostalCode = CodigoPostal;
    }

}
