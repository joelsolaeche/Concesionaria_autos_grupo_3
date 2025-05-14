package model;

public class Embarque implements Area {

    private String nombreArea = "Embarque";



    @Override
    public void notificarArea() {
        System.out.println("Notificación enviada al área de Embarque.");
    }


    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
