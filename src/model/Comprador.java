package model;

import java.util.ArrayList;
import java.util.List;

public class Comprador extends Usuario {
    private String direccion;
    private String telefono;
    private List<PedidoCompra> historialCompras;
    private List<FormaPago> mediosDePago;

    public Comprador(int id, String nombre, String apellido, String dni, String email, String contraseña,
                     String direccion, String telefono) {
        super(id, nombre, apellido, dni, email, contraseña);
        this.direccion = direccion;
        this.telefono = telefono;
        this.historialCompras = new ArrayList<>();
        this.mediosDePago = new ArrayList<>();
    }

    // Permite filtrar vehículos del catálogo según cierto criterios
    public List<Vehiculo> buscarVehiculosDisponibles(List<Vehiculo> catalogo, String marcaDeseada, String colorDeseado, TipoVehiculo tipoDeseado) {
        List<Vehiculo> resultado = new ArrayList<>();

        for (Vehiculo v : catalogo) {
            boolean coincideMarca = (marcaDeseada == null || v.getMarca().equalsIgnoreCase(marcaDeseada));
            boolean coincideColor = (colorDeseado == null || v.getColor().equalsIgnoreCase(colorDeseado));
            boolean coincideTipo = (tipoDeseado == null || v.getTipoVehiculo().equals(tipoDeseado));

            if (coincideMarca && coincideColor && coincideTipo) {
                resultado.add(v);
            }
        }

        return resultado;
    }

    // Registra la compra de un vehículo con una forma de pago válida
    public boolean comprarVehiculo(PedidoCompra pedido, FormaPago formaPago) {
        if (formaPago == null || pedido == null) return false;
        this.historialCompras.add(pedido);
        this.mediosDePago.add(formaPago);
        System.out.println("Vehículo comprado correctamente: " + pedido.getVehiculo().getModelo());
        return true;
    }

    // Devuelve una lista de todos los pedidos realizados por el comprador
    public List<PedidoCompra> verHistorial() {
        return historialCompras;
    }

    // Permite simular que se está haciendo seguimiento del estado de un vehiculo
    public void realizarSeguimiento(PedidoCompra pedido) {
        System.out.println("Seguimiento del pedido #" + pedido.getNroPedido() +
                " – Estado actual: " + pedido.getEstadoPedido());
    }

    // Informa si este comprador debe emitir factura con CUIT (según si es consumidor final o empresa)
    public boolean aplicaCuitt() {
        return dni.startsWith("3"); // ejemplo ficticio de validación
    }

    // Getters and Setters
    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public List<PedidoCompra> getHistorialCompras() {return historialCompras;}
    public void setHistorialCompras(List<PedidoCompra> historialCompras) {this.historialCompras = historialCompras;}
    public List<FormaPago> getMediosDePago() {return mediosDePago;}
    public void setMediosDePago(List<FormaPago> mediosDePago) {this.mediosDePago = mediosDePago;}
}