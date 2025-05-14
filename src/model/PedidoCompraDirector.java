package model;

import java.util.Date;

public class PedidoCompraDirector {
    private PedidoCompraBuilder builder;

    public PedidoCompraDirector(PedidoCompraBuilder builder) {
        this.builder = builder;
    }

    public PedidoCompra construirPedido() {
        return builder
                .setNoPedido(1)
                .setFecha(new Date())
                .setCostoTotal(10000)
                // Agrega los demás atributos necesarios aquí
                .buildPedidoCompra();
    }
}

