package model;

public class Entrega implements Area {
    private String nombreArea = "Entrega";

    @Override
    public void notificarArea() {
        System.out.println("Notificación enviada al área de Entrega.");
    }


    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
