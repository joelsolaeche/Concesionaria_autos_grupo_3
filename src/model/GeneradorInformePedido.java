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

    // Genera un informe con todos los pedidos creados exactamente en una fecha dada
    public List<PedidoCompra> generarPorFecha(Date fecha) {
        return pedidos.stream()
                .filter(pedido -> pedido.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }

    // Genera un informe con todos los pedidos que coincidan con una descripción textual del estado
    public List<PedidoCompra> generarPorEstado(String estadoTexto) {
        return pedidos.stream()
                .filter(pedido -> pedido.getEstadoPedido().getAreaResponsable().getNombreArea().equalsIgnoreCase(estadoTexto))
                .collect(Collectors.toList());
    }


    // Genera un informe con todos los pedidos realizados dentro de un rango de fechas
    public List<PedidoCompra> generarPorRango(Date fechaInicio, Date fechaFin) {
        return pedidos.stream()
                .filter(pedido -> !pedido.getFecha().before(fechaInicio) && !pedido.getFecha().after(fechaFin))
                .collect(Collectors.toList());
    }

    // Exporta una lista de pedidos al formato CSV simulado
    public void exportarCSV(List<PedidoCompra> pedidosFiltrados) {
        System.out.println("Exportando informe a CSV:");
        for (PedidoCompra pedido : pedidosFiltrados) {
            System.out.println(pedido.toCSV());
        }
    }

    // Exporta una lista de pedidos al formato PDF simulado
    public void exportarPDF(List<PedidoCompra> pedidosFiltrados) {
        System.out.println("Exportando informe a PDF:");
        for (PedidoCompra pedido : pedidosFiltrados) {
            System.out.println(pedido.toPDF());
        }
    }

}
