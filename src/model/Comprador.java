package model;

import java.util.List;

public class Comprador extends Usuario {
    private String direccion;
    private String telefono;
    private List<PedidoDeCompra> historialCompras;
    private List<FormaDePago> mediosDePago;

    public List<Vehiculo> buscarVehiculo(Filtro filtro) {
        return null; // lógica de búsqueda
    }

    public boolean comprarVehiculo(int vehiculoId, FormaDePago formaPago) {
        return true; // lógica de compra
    }

    public List<Vehiculo> verHistorial() {
        return null; // lógica para ver historial
    }

    public void realizarSeguimiento(Vehiculo vehiculo) {
        // lógica de seguimiento
    }

    public boolean aplicaCuitt() {
        return true;
    }
}