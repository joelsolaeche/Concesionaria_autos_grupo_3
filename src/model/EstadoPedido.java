package model;

import java.util.Date;

public class EstadoPedido {

    private int numeroPedido;
    private Date fechaCreacion;
    private Area areaResponsable;

    public EstadoPedido(int numeroPedido, Area areaResponsable) {
        this.numeroPedido = numeroPedido;
        this.areaResponsable = areaResponsable;
        this.fechaCreacion = new Date();
    }

    // Avanza a la siguiente etapa del proceso cambiando el área responsable
    public void pasarASiguienteEtapa() {
        String actual = areaResponsable.getNombreArea();

        switch (actual) {
            case "Ventas":
                areaResponsable = new Cobranzas();
                break;
            case "Cobranzas":
                areaResponsable = new Embarque();
                break;
            case "Embarque":
                areaResponsable = new Logistica();
                break;
            case "Logística":
                areaResponsable = new Entrega();
                break;
            case "Entrega":
                System.out.println("El pedido #" + numeroPedido + " ya fue entregado. No hay más etapas.");
                return;
            default:
                System.out.println("Área desconocida: " + actual + ". No se puede avanzar.");
                return;
        }

        fechaCreacion = new Date(); // Se actualiza la fecha cada vez que cambia de etapa
        System.out.println("Pedido #" + numeroPedido + " pasó a la etapa: " + areaResponsable.getNombreArea());
    }


    // Getters and Setters
    public int getNumeroPedido() {return numeroPedido;}
    public void setNumeroPedido(int numeroPedido) {this.numeroPedido = numeroPedido;}
    public Date getFechaCreacion() {return fechaCreacion;}
    public void setFechaCreacion(Date fechaCreacion) {this.fechaCreacion = fechaCreacion;}
    public Area getAreaResponsable() {return areaResponsable;}
    public void setAreaResponsable(Area areaResponsable) {this.areaResponsable = areaResponsable;}
}
