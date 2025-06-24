package model;

// Es una clase de soporte que encapsula estadísticas generales del sistema
import java.util.List;

public class Reporte {
    private int totalPedidos;
    private double totalFacturado;
    private int pedidosPendientes;
    private int pedidosProcesados;
    private int pedidosEntregados;

    public void generarDesdePedidos(List<PedidoCompra> pedidos) {
        //  Itera por los pedidos y actualiza los contadores
        totalPedidos = 0;
        totalFacturado = 0;
        pedidosPendientes = 0;
        pedidosProcesados = 0;
        pedidosEntregados = 0;

        for (PedidoCompra pedido : pedidos) {
            totalPedidos++;
            totalFacturado += pedido.getCostoTotal();

            String estado = pedido.getEstadoPedido().toString().toLowerCase();

            if (estado.contains("pendiente")) {
                pedidosPendientes++;
            } else if (estado.contains("procesado")) {
                pedidosProcesados++;
            } else if (estado.contains("entregado")) {
                pedidosEntregados++;
            }
        }
    }

    public void mostrar() {
        System.out.println("=== Reporte de Pedidos ===");
        System.out.println("Total de pedidos: " + totalPedidos);
        System.out.println("Total facturado: $" + totalFacturado);
        System.out.println("Pedidos pendientes: " + pedidosPendientes);
        System.out.println("Pedidos procesados: " + pedidosProcesados);
        System.out.println("Pedidos entregados: " + pedidosEntregados);
    }

    // Getters
    public int getTotalPedidos() { return totalPedidos; }
    public double getTotalFacturado() { return totalFacturado; }
    public int getPedidosPendientes() { return pedidosPendientes; }
    public int getPedidosProcesados() { return pedidosProcesados; }
    public int getPedidosEntregados() { return pedidosEntregados; }
}
