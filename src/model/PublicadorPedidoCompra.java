package model;

import java.util.List;

public class PublicadorPedidoCompra {

    private List<Area> observadores;


    //metodos
    public void agregarObservador(Area area) {
        this.observadores.add(area);
    }

    public void quitarObservador(Area area) {
        this.observadores.remove(area);
    }

    public void notificarObservadores() {
        for (Area area : observadores) {
            area.notificarArea();
        }
    }

}
