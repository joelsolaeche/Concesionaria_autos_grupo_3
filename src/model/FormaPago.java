package model;

import java.time.LocalDateTime;

public abstract class FormaPago {
    protected float costo;
    protected String moneda;
    protected LocalDateTime fechaPago;
    protected String estadoPago;

    public abstract boolean procesarPago();

    public void cancelarPago() {
        estadoPago = "Cancelado";
    }

    public String obtenerEstado() {
        return estadoPago;
    }

    public String generarComprobante() {
        return "Comprobante generado para el pago de " + costo + " " + moneda;
    }


    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}
