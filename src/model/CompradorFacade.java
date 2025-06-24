package model;

import java.util.List;

public class CompradorFacade implements UsuarioFacade {

    private Comprador comprador;

    public CompradorFacade(Comprador comprador) {
        this.comprador = comprador;
    }

    @Override
    public boolean accederSistema(String nombreUsuario, String contrasena) {
        return comprador.accederSistema(nombreUsuario, contrasena);
    }

    public List<Vehiculo> buscarVehiculosDisponibles(List<Vehiculo> catalogo, String marca, String color, TipoVehiculo tipo) {
        return comprador.buscarVehiculosDisponibles(catalogo, marca, color, tipo);
    }


    public void comprar(PedidoCompra pedido, FormaPago formaPago) {
        comprador.comprarVehiculo(pedido, formaPago);
    }

    public void verSeguimiento(PedidoCompra pedido) {
        comprador.realizarSeguimiento(pedido);
    }

    public List<PedidoCompra> obtenerHistorial() {
        return comprador.verHistorial();
    }


}
