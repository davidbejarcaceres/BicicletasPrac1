package com.caceres.bejar.david.bicicletasprac1;

public class Bike {
    String numero;
    String descripcion;
    int IDicono;

    public Bike(String numero, String descripcion, int icono) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.IDicono= icono;
    }

    public Bike(String numero, String descripcion) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.IDicono= R.mipmap.ic_bike;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIDicono() {
        return IDicono;
    }

    public void setIDicono(int IDicono) {
        this.IDicono = IDicono;
    }
}
