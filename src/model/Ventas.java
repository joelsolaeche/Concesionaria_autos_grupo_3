package model;

public class Ventas implements Area {

    private String nombreArea = "Ventas";



    @Override
    public void notificarArea() {
        System.out.println("Notificación enviada al área de Ventas.");
    }


    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
