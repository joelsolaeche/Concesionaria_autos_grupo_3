package model;

public class Impuesto {
    private String nombre;
    private double porcentaje;
    private ImpuestoStrategy estrategia;
    private String descripcion;

    public Impuesto(String nombre, double porcentaje, ImpuestoStrategy estrategia, String descripcion) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.estrategia = estrategia;
        this.descripcion = descripcion;
    }

    public double calcularImpuestoTotal(double montoBase) {
        return estrategia.calcularImpuesto(montoBase);
    }

    public boolean esAplicable(double montoBase) {
        return montoBase > 0;
    }

    public String mostrarDetalle() {
        return "Impuesto: " + nombre + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Porcentaje: " + (porcentaje * 100) + "%";
    }
}
