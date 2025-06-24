package model;

import java.util.Date;

public class Venta {
    private Vehiculo vehiculo;
    private Comprador comprador;
    private Vendedor vendedor;
    private Date fechaVenta;

    public Venta(Vehiculo vehiculo, Comprador comprador, Vendedor vendedor) {
        this.vehiculo = vehiculo;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.fechaVenta = new Date(); // La venta se registra con la fecha actual
    }

    // Devuelve información útil para reportes o seguimiento
    public String getResumenVenta() {
        return "Vehículo vendido: " + vehiculo.getMarca() + " " + vehiculo.getModelo() +
                " | Comprador: " + comprador.getNombre() +
                " | Vendedor: " + vendedor.getNombre() +
                " | Fecha: " + fechaVenta;
    }

    // Getters
    public Vehiculo getVehiculo() { return vehiculo; }
    public Comprador getComprador() { return comprador; }
    public Vendedor getVendedor() { return vendedor; }
    public Date getFechaVenta() { return fechaVenta; }


}
