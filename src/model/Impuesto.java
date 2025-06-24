package model;

public class Impuesto {
    private ImpuestoStrategy estrategia;


    public Impuesto(ImpuestoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularImpuestoTotal(Vehiculo vehiculo) {
        return estrategia.calcularImpuesto(vehiculo);
    }

    public void setEstrategia(ImpuestoStrategy estrategia) {
        this.estrategia = estrategia;
    }
}
