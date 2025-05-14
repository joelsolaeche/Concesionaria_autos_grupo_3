package model;

import java.util.Date;

public class PedidoCompraBuilderConcreto implements PedidoCompraBuilder {
    private PedidoCompra pedido = new PedidoCompra();

    @Override
    public PedidoCompraBuilder setNoPedido(int nro) {
        pedido.nro = nro;
        return this;
    }

    @Override
    public PedidoCompraBuilder setFecha(Date fecha) {
        pedido.setFecha(fecha);
        return this;
    }

    @Override
    public PedidoCompraBuilder setCliente(Cliente cliente) {
        pedido.cliente = cliente;
        return this;
    }

    @Override
    public PedidoCompraBuilder setVehiculo(Vehiculo vehiculo) {
        pedido.vehiculo = vehiculo;
        return this;
    }

    @Override
    public PedidoCompraBuilder setCostoTotal(double costoTotal) {
        pedido.costoTotal = costoTotal;
        return this;
    }

    @Override
    public PedidoCompraBuilder setFormaPago(FormaDePago formaPago) {
        pedido.formaPago = formaPago;
        return this;
    }

    @Override
    public PedidoCompraBuilder setAreaResponsableActual(String area) {
        pedido.areaResponsableActual = area;
        return this;
    }


    public PedidoCompraBuilder setHistorialPedido(HistorialPedido historialPedido) {
        pedido.historialPedido = historialPedido;
        return this;
    }

    @Override
    public PedidoCompraBuilder setEstadoPedido(EstadoPedido estadoPedido) {
        pedido.estadoPedido = estadoPedido;
        return this;
    }

    @Override
    public PedidoCompraBuilder setPublicador(PublicadorPedidoCompra publicador) {
        pedido.publicador = publicador;
        return this;
    }

    @Override
    public PedidoCompra buildPedidoCompra() {
        return pedido;
    }
}

