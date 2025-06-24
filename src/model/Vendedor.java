package model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario {
    private String zonaAsignada;
    private List<Venta> vehiculosVendidos;

    public Vendedor(int id, String nombre, String apellido, String dni, String email, String contraseña, String zonaAsignada) {
        super(id, nombre, apellido, dni, email, contraseña);
        this.zonaAsignada = zonaAsignada;
        this.vehiculosVendidos = new ArrayList<>();
    }

    // Registra una venta genérica asociando el ID del vehículo y comprador
    public boolean registrarVenta(Vehiculo vehiculo, Comprador comprador) {
        if (vehiculo == null || comprador == null) return false;

        Venta nuevaVenta = new Venta(vehiculo, comprador, this);
        vehiculosVendidos.add(nuevaVenta);

        System.out.println("Venta registrada: " + vehiculo.getModelo() + " vendido a " + comprador.getNombre());
        return true;
    }

    // Devuelve una lista de compradores únicos a los que este vendedor les vendió
    public List<Comprador> verClientes() {
        List<Comprador> clientes = new ArrayList<>();
        for (Venta v : vehiculosVendidos) {
            if (!clientes.contains(v.getComprador())) {
                clientes.add(v.getComprador());
            }
        }
        return clientes;
    }

    // Simula una lista de vehículos disponibles
    public List<Vehiculo> verListaVehiculosDisponibles(List<Vehiculo> catalogo) {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo v : catalogo) {
            if (v != null /*y si no está vendido*/) {
                disponibles.add(v);
            }
        }
        return disponibles;
    }

    // Setters and Getters
    public String getZonaAsignada() {return zonaAsignada;}
    public void setZonaAsignada(String zonaAsignada) {this.zonaAsignada = zonaAsignada;}
    public List<Venta> getVehiculosVendidos() {return vehiculosVendidos;}
    public void setVehiculosVendidos(List<Venta> vehiculosVendidos) {this.vehiculosVendidos = vehiculosVendidos;}
}