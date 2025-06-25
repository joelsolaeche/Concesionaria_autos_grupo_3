package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoCompraDirector {
    private PedidoCompraBuilder builder;

    public PedidoCompraDirector(PedidoCompraBuilder builder) {
        this.builder = builder;
    }


    public PedidoCompra construirPedido(
            int nroPedido,
            Date fecha,
            double costoTotal,
            Cliente cliente,
            Vehiculo vehiculo,
            FormaPago formaPago,
            Area area,
            EstadoPedido estadoPedido,
            List<HistorialPedidoCompra> historialPedidoCompra,
            PublicadorPedidoCompra publicadorPedidoCompra
    ) {
        return builder
                .setNoPedido(nroPedido)
                .setFecha(new Date())
                .setCostoTotal(costoTotal)
                .setCliente(new Cliente(3, "lucia", "De la Cruz", "34567890", "lucia@mail.com", "clave123", "Serrano 665", 123456785L,new Date()))
                .setVehiculo(new Vehiculo("Fiesta", "Ford", "Rojo", 1001, "2001",50000, TipoVehiculo.AUTO))
                .setFormaPago(new Contado())
                .setAreaResponsableActual(new Ventas())
                .setEstadoPedido(new EstadoPedido(1, new Ventas()))
                .setHistorialPedido(new ArrayList<HistorialPedidoCompra>())
                .buildPedidoCompra();
    }

}

