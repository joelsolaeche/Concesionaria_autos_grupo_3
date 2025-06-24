package model;

public class Cobranzas implements Area {

    private String nombreArea = "Cobranzas";

    @Override
    public void notificarArea() {
        System.out.println("Notificación enviada al área de Cobranzas.");
    }


    public String getNombreArea() {
        return nombreArea;
    }
    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }
}
