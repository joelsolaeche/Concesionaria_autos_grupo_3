package model;

import java.util.Date;
import java.util.List;

public class PedidoCompraBuilderConcreto implements PedidoCompraBuilder {
    private PedidoCompra pedido;

    public PedidoCompraBuilderConcreto() {
        this.pedido = new PedidoCompra(); // Instancia inicial vacía
    }

    @Override
    public PedidoCompraBuilder setNoPedido(int nro) {
        pedido.setNroPedido(nro);
        return this;
    }

    @Override
    public PedidoCompraBuilder setFecha(Date fecha) {
        pedido.setFecha(fecha);
        return this;
    }

    @Override
    public PedidoCompraBuilder setCliente(Cliente cliente) {
        pedido.setCliente(cliente);
        return this;
    }

    @Override
    public PedidoCompraBuilder setVehiculo(Vehiculo vehiculo) {
        pedido.setVehiculo(vehiculo);
        return this;
    }

    @Override
    public PedidoCompraBuilder setCostoTotal(double costoTotal) {
        pedido.setCostoTotal(costoTotal);
        return this;
    }

    @Override
    public PedidoCompraBuilder setFormaPago(FormaPago formaPago) {
        pedido.setFormaPago(formaPago);
        return this;
    }

    @Override
    public PedidoCompraBuilder setAreaResponsableActual(Area area) {
        pedido.setAreaResponsableActual(area);
        return this;
    }
    @Override
    public PedidoCompraBuilder setHistorialPedido(List<HistorialPedidoCompra> historial) {
        pedido.setHistorialPedidoCompra(historial);
        return this;
    }

    @Override
    public PedidoCompraBuilder setEstadoPedido(EstadoPedido estadoPedido) {
        pedido.setEstadoPedido(estadoPedido);
        return this;
    }

    @Override
    public PedidoCompraBuilder setPublicador(PublicadorPedidoCompra publicador) {
        //Inicializa el publicador con observadores registrados, si es necesario
        return this;
    }

    @Override
    public PedidoCompra buildPedidoCompra() {
        return pedido;
    }
}

