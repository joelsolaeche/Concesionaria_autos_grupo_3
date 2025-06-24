package model;

import java.util.Date;

public class HistorialPedidoCompra {
    private Date fecha;
    private String estadoAnterior;
    private String estadoActual;

    public HistorialPedidoCompra(Date fecha, String estadoAnterior, String estadoActual) {
        this.fecha = fecha;
        this.estadoAnterior = estadoAnterior;
        this.estadoActual = estadoActual;
    }

    // Constructor usado desde PedidoCompra cuando cambia de estado
    public HistorialPedidoCompra(Date fecha, EstadoPedido nuevoEstado, Area nuevaArea) {
        this.fecha = fecha;
        this.estadoAnterior = null; // o podés traer el anterior
        this.estadoActual = nuevoEstado.getNumeroPedido() + " - " + nuevaArea.getNombreArea();
    }


    public void actualizarEstado(String nuevoEstado){
        this.estadoAnterior = this.estadoActual;
        this.estadoActual = nuevoEstado;
        this.fecha = new Date();
    }

    // Getters
    public Date getFecha() { return fecha; }
    public String getEstadoAnterior() { return estadoAnterior; }
    public String getEstadoActual() { return estadoActual; }

}
