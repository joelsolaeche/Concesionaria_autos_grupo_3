package model;

public class Logistica implements Area {

    private String nombreArea = "Logística";

    @Override
    public void notificarArea() {
        System.out.println("Notificación enviada al área de Logística.");
    }

    public String getNombreArea() {return nombreArea;}
    public void setNombreArea(String nombreArea) {this.nombreArea = nombreArea;}
}
