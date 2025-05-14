package model;

import java.util.Date;

public class HistorialPedidoCompra {
    private Date fecha;
    private String estadoAnterior;
    private String estadoActual;



    public void actualizarEstado(String nuevoEstado){
        this.estadoAnterior = this.estadoActual;
        this.estadoActual = nuevoEstado;
        this.fecha = new Date();
    }
}
