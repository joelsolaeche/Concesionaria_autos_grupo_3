package model;

import java.util.Date;

public interface PedidoCompraBuilder {
    PedidoCompraBuilder setNoPedido(int nro);
    PedidoCompraBuilder setFecha(Date fecha);
    PedidoCompraBuilder setCliente(Cliente cliente);
    PedidoCompraBuilder setVehiculo(Vehiculo vehiculo);
    PedidoCompraBuilder setCostoTotal(double costoTotal);
    PedidoCompraBuilder setFormaPago(FormaPago formaPago);
    PedidoCompraBuilder setAreaResponsableActual(String area);
    PedidoCompraBuilder setHistorialPedido(HistorialPedidoCompra historialPedidoCompra);
    PedidoCompraBuilder setEstadoPedido(EstadoPedido estadoPedido);
    PedidoCompraBuilder setPublicador(PublicadorPedidoCompra publicador);
    PedidoCompra buildPedidoCompra();
}
