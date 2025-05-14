package model;

import java.util.List;

public class Vendedor extends Usuario {
    private String zonaAsignada;
    private List<Venta> vehiculosVendidos;

    public boolean registrarVenta(int vehiculoId, int compradorId) {
        return true; // lógica para registrar la venta
    }

    public List<Comprador> verClientes() {
        return null; // lógica para obtener los clientes
    }

    public List<Vehiculo> verListaVehiculosDisponibles() {
        return null; // lógica para obtener vehículos
    }
}