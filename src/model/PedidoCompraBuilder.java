package model;

import java.util.Date;
import java.util.List;

public interface PedidoCompraBuilder {
    PedidoCompraBuilder setNoPedido(int nro);
    PedidoCompraBuilder setFecha(Date fecha);
    PedidoCompraBuilder setCliente(Cliente cliente);
    PedidoCompraBuilder setVehiculo(Vehiculo vehiculo);
    PedidoCompraBuilder setCostoTotal(double costoTotal);
    PedidoCompraBuilder setFormaPago(FormaPago formaPago);
    PedidoCompraBuilder setAreaResponsableActual(Area area);
    PedidoCompraBuilder setHistorialPedido(List<HistorialPedidoCompra> historialPedidoCompra);
    PedidoCompraBuilder setEstadoPedido(EstadoPedido estadoPedido);
    PedidoCompraBuilder setPublicador(PublicadorPedidoCompra publicador);
    PedidoCompra buildPedidoCompra();
}
