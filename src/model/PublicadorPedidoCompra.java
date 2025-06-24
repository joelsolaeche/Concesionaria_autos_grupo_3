package model;

import java.util.ArrayList;
import java.util.List;

public class PublicadorPedidoCompra {

    private List<Area> observadores;

    public PublicadorPedidoCompra() {
        this.observadores = new ArrayList<>(); //Se inicializa la lista al crear el publicador
    }

    public void agregarObservador(Area area) {
        this.observadores.add(area);
    }

    public void quitarObservador(Area area) {
        this.observadores.remove(area);
    }

    public void notificarObservadores() {
        for (Area area : observadores) {
            area.notificarArea(); // Cada área recibe su notificación al instante
        }
    }

}
