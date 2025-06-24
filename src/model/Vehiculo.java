package model;

import java.util.List;

public class Vehiculo {
    private String modelo;
    private String marca;
    private String color;
    private int nroChasis;
    private String nroMotor;
    private TipoVehiculo tipoVehiculo;


    public Vehiculo(String modelo, String marca, String color, int nroChasis, String nroMotor, TipoVehiculo tipoVehiculo) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.nroChasis = nroChasis;
        this.nroMotor = nroMotor;
        this.tipoVehiculo = tipoVehiculo;

    }



    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(int nroChasis) {
        this.nroChasis = nroChasis;
    }

    public String getNroMotor() {
        return nroMotor;
    }

    public void setNroMotor(String nroMotor) {
        this.nroMotor = nroMotor;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }


}
