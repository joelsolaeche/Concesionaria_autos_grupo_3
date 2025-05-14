package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GeneradorInformePedido {


    private List<PedidoCompra> pedidos;

    public GeneradorInformePedido(List<PedidoCompra> pedidos) {
        this.pedidos = pedidos;
    }

    public List<PedidoCompra> generarPorFecha(Date fecha) {
        return pedidos.stream()
                .filter(pedido -> pedido.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    public List<PedidoCompra> generarPorEstado(String estado) {
        return pedidos.stream()
                .filter(pedido -> pedido.getEstadoPedido().equals(estado))
                .collect(Collectors.toList());
    }

    public List<PedidoCompra> generarPorRango(Date fechaInicio, Date fechaFin) {
        return pedidos.stream()
                .filter(pedido -> !pedido.getFecha().before(fechaInicio) && !pedido.getFecha().after(fechaFin))
                .collect(Collectors.toList());
    }

    public void exportarCSV(List<PedidoCompra> pedidos) {
        // Example implementation for exporting to CSV
        System.out.println("Exporting to CSV...");
        for (PedidoCompra pedido : pedidos) {
            System.out.println(pedido.toCSV());
        }
    }

    public void exportarPDF(List<PedidoCompra> pedidos) {
        // Example implementation for exporting to PDF
        System.out.println("Exporting to PDF...");
        for (PedidoCompra pedido : pedidos) {
            System.out.println(pedido.toPDF());
        }
    }

}
